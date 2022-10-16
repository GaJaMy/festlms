package com.zerobase.festlms.admin.banner.service;

import com.zerobase.festlms.admin.banner.dto.BannerDto;
import com.zerobase.festlms.admin.banner.model.BannerInput;
import com.zerobase.festlms.admin.banner.model.BannerParam;

import java.util.List;

public interface BannerService {
    List<BannerDto> list(BannerParam parameter);
    BannerDto getById(long id);

    boolean set(BannerInput parameter);

    boolean add(BannerInput parameter);

    List<BannerDto> frontList();
}
