package com.zerobase.festlms.admin.Service;

import com.zerobase.festlms.admin.dto.BannerDto;
import com.zerobase.festlms.admin.model.BannerInput;
import com.zerobase.festlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {
    List<BannerDto> list(BannerParam parameter);
    BannerDto getById(long id);

    boolean set(BannerInput parameter);

    boolean add(BannerInput parameter);

    List<BannerDto> frontList();
}
