package com.zerobase.festlms.admin.mapper;

import com.zerobase.festlms.admin.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryDto> select(CategoryDto parameter);
}
