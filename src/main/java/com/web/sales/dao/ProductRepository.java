package com.web.sales.dao;

import com.web.sales.models.Product;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements CrudRepository<Product, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Product entity) {
        String sql = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getProductId(), entity.getManufacturerId(), entity.getProductCode(), entity.getPurchaseCost(), entity.getQuantityOnHand(), entity.getMarkup(), entity.getAvailable(), entity.getDescription());
    }

    @Override
    public Optional<Product> findById(String id) {
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
        Product p = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
        return Optional.of(p);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM PRODUCT";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Product entity) {
        String sql = "UPDATE PRODUCT SET MANUFACTURER_ID=?, PRODUCT_CODE=?, PURCHASE_COST=?, QUANTITY_ON_HAND=?, MARKUP=?, AVAILABLE=?, DESCRIPTION=? WHERE PRODUCT_ID=?";
        jdbcTemplate.update(sql, entity.getManufacturerId(), entity.getProductCode(), entity.getPurchaseCost(), entity.getQuantityOnHand(), entity.getMarkup(), entity.getAvailable(), entity.getDescription(), entity.getProductId());
    }

}
