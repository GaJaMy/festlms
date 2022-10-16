package com.zerobase.festlms.admin.repository;

import com.zerobase.festlms.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
