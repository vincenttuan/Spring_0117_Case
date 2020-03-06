package com.web.sales.services;

import com.web.sales.dao.PurchaseOrderRepository;
import com.web.sales.models.PurchaseOrder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository dao;

    public void add(PurchaseOrder entity) {
        dao.save(entity);
    }

    public PurchaseOrder get(String id) {
        return dao.findById(id).get();
    }

    public boolean exists(String id) {
        return dao.existsById(id);
    }

    public List<PurchaseOrder> query() {
        List<PurchaseOrder> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }

    public void delete(String id) {
        dao.deleteById(id);
    }

    public void update(PurchaseOrder entity) {
        dao.update(entity);
    }

}
