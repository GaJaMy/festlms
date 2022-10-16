package com.zerobase.festlms.admin.Service;

import com.zerobase.festlms.admin.dto.CategoryDto;
import com.zerobase.festlms.admin.entity.Category;
import com.zerobase.festlms.admin.mapper.CategoryMapper;
import com.zerobase.festlms.admin.model.CategoryInput;
import com.zerobase.festlms.admin.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public boolean add(String categoryName) {
        Category category = Category.builder()
                .categoryName(categoryName)
                .usingYn(true)
                .sortValue(0)
                .build();
        categoryRepository.save(category);
        return false;
    }

    @Override
    public boolean update(CategoryInput parameter) {
        Optional<Category> optionalCategory = categoryRepository.findById(parameter.getId());

        if(optionalCategory.isPresent()) {
            Category category = optionalCategory.get();

            category.setCategoryName(parameter.getCategoryName());
            category.setSortValue(parameter.getSortValue());
            category.setUsingYn(parameter.isUsingYn());
            categoryRepository.save(category);
        }
        return true;
    }

    @Override
    public boolean del(long id) {
        categoryRepository.deleteById(id);

        return true;
    }

    @Override
    public List<CategoryDto> list() {
        List<Category> categories = categoryRepository.findAll(getSortBySortValueDesc());
        return CategoryDto.of(categories);
    }

    @Override
    public List<CategoryDto> frontList(CategoryDto parameter) {
        return categoryMapper.select(parameter);
    }

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC,"sortValue");
    }
}
