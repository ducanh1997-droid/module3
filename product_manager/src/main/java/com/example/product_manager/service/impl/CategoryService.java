package com.example.product_manager.service.impl;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.IService;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements IService<Category> {
    private final List<Category> categories;

    public CategoryService() {
        categories = new ArrayList<>();
        categories.add(new Category("candy"));
        categories.add(new Category("drink"));
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void save(Category category) {
        categories.add(category);
    }

    @Override
    public Category findById(Long id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void update(Category category) {
        for (Category c : categories) {
            if (c.getId().equals(category.getId())) {
                int id = categories.indexOf(c);
                categories.set(id, category);
            }
        }
    }

    @Override
    public void delete(Long id) {
        Category category = findById(id);
        if (category != null) {
            categories.remove(category);
        }
    }

    public Category returnCategory(String name){
        for (Category category: categories) {
            if(name.equals(category.getName())){
                return category;
            }
        }
        return null;
    }
}
