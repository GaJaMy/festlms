package com.zerobase.festlms.admin.Service;

import com.zerobase.festlms.admin.dto.CategoryDto;
import com.zerobase.festlms.admin.model.CategoryInput;

import java.util.List;

public interface CategoryService {
    boolean add(String categoryName);
    boolean update(CategoryInput parameter);
    boolean del(long id);
    List<CategoryDto> list();
    List<CategoryDto> frontList(CategoryDto parameter);
}
