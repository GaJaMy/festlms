package com.zerobase.festlms.admin.mapper;

import com.zerobase.festlms.admin.dto.BannerDto;
import com.zerobase.festlms.admin.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
}
