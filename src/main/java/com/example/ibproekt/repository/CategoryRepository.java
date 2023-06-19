package com.example.ibproekt.repository;

import com.example.ibproekt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findById(long id);
}
