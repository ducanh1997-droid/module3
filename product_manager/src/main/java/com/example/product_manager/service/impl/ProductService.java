package com.example.product_manager.service.impl;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.IService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product> {
    private final List<Product> products;
    private final CategoryService categoryService;
    public ProductService(CategoryService categoryService) {
        //tạo list ảo chứa đối tượng tương tác, sau sẽ thêm Db xử lý
        //id được xử lý tăng tự động khi tạo mới, tương đương với Db sau này
        products = new ArrayList<>();
        this.categoryService = categoryService;
        products.add(new Product("Coca-cola", 8000D, 50,categoryService.returnCategory("drink")));
        products.add(new Product("Sting", 7000D, 110,categoryService.returnCategory("drink")));
        products.add(new Product("Pepsi", 7000D, 65,null));
        products.add(new Product("Socola", 7000D, 65,categoryService.returnCategory("candy")));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                int id = products.indexOf(p);
                products.set(id, product);
            }
        }
    }

    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
        }
    }
}
