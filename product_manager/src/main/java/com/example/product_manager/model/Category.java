package com.example.product_manager.model;

public class Category {
    private static Long INDEX = 0L;
    private Long id;
    private String name;

    public Category(String name) {
        this.id = ++INDEX;
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
