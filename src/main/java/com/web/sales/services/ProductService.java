package com.web.sales.services;

import com.web.sales.dao.ProductRepository;
import com.web.sales.models.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository dao;

    public void add(Product entity) {
        dao.save(entity);
    }

    public Product get(String id) {
        return dao.findById(id).get();
    }

    public boolean exists(String id) {
        return dao.existsById(id);
    }

    public List<Product> query() {
        List<Product> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }

    public void delete(String id) {
        dao.deleteById(id);
    }

    public void update(Product entity) {
        dao.update(entity);
    }

}
