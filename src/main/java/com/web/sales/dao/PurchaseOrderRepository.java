package com.web.sales.dao;

import com.web.sales.models.PurchaseOrder;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderRepository implements CrudRepository<PurchaseOrder, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(PurchaseOrder entity) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO PURCHASE_ORDER("
                + "ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, "
                + "SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                entity.getOrderNum(),
                entity.getCustomerId(),
                entity.getProductId(),
                entity.getQuantity(),
                entity.getShippingCost(),
                sdf.format(entity.getSalesDate()),
                sdf.format(entity.getShippingDate()),
                entity.getFreightCompany());
    }

    @Override
    public Optional<PurchaseOrder> findById(String id) {
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        PurchaseOrder purchaseOrder = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return Optional.of(purchaseOrder);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<PurchaseOrder> findAll() {
        String sql = "SELECT * FROM PURCHASE_ORDER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(PurchaseOrder entity) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE PURCHASE_ORDER SET "
                + "CUSTOMER_ID=?, PRODUCT_ID=?, QUANTITY=?, "
                + "SHIPPING_COST=?, SALES_DATE=?, SHIPPING_DATE=?, FREIGHT_COMPANY=? "
                + "WHERE ORDER_NUM=?";
        jdbcTemplate.update(sql,
                entity.getCustomerId(),
                entity.getProductId(),
                entity.getQuantity(),
                entity.getShippingCost(),
                sdf.format(entity.getSalesDate()),
                sdf.format(entity.getShippingDate()),
                entity.getFreightCompany(),
                entity.getOrderNum());
    }

}
