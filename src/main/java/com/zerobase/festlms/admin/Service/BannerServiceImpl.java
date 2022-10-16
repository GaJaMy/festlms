package com.zerobase.festlms.admin.Service;

import com.zerobase.festlms.admin.dto.BannerDto;
import com.zerobase.festlms.admin.entity.Banner;
import com.zerobase.festlms.admin.mapper.BannerMapper;
import com.zerobase.festlms.admin.model.BannerInput;
import com.zerobase.festlms.admin.model.BannerParam;
import com.zerobase.festlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);
        List<BannerDto> list = bannerMapper.selectList(parameter);
        if(!CollectionUtils.isEmpty(list)) {
            int i =0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }

    @Override
    public BannerDto getById(long id) {
        Banner banner = bannerRepository.getById(id);
        return BannerDto.of(banner);
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner =
                bannerRepository.findById(parameter.getId());
        if(!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerAlterText(parameter.getBannerAlterText());
        banner.setTarget(parameter.getTarget());
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setSortValue(parameter.getSortValue());
        banner.setRegDt(parameter.getRegDt());
        banner.setUsingYn(parameter.isUsingYn());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .bannerAlterText(parameter.getBannerAlterText())
                .target(parameter.getTarget())
                .linkUrl(parameter.getLinkUrl())
                .sortValue(parameter.getSortValue())
                .sortValue(parameter.getSortValue())
                .usingYn(parameter.isUsingYn())
                .regDt(LocalDateTime.now())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .build();
        bannerRepository.save(banner);
        return true;
    }

    @Override
    public List<BannerDto> frontList() {
        List<BannerDto> bannerList = null;

        Optional<List<Banner>> optionalBanners = bannerRepository.findByUsingYnOrderBySortValue(true);

        if (optionalBanners.isPresent()) {
            List<Banner> banners = optionalBanners.get();
            bannerList = BannerDto.of(banners);
        }

        return bannerList;
    }

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC,"sortValue");
    }
}
