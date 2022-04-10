package com.asset.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.management.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
