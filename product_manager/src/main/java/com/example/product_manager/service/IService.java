package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    void save(E e);
    E findById(Long id);

    void update(E e);
    void delete(Long id);
}
