package com.web.sales.services;

import com.web.sales.dao.CustomerRepository;
import com.web.sales.dao.ReportRepository;
import com.web.sales.models.Customer;
import com.web.sales.models.ReportCustomer;
import com.web.sales.models.ReportProduct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository dao;

    public List<ReportCustomer> listCustomers() {
        List<ReportCustomer> list = new ArrayList<>();
        dao.findAllCustomers().forEach(data -> list.add(data));
        return list;
    }
    
    public List<ReportProduct> listProducts() {
        List<ReportProduct> list = new ArrayList<>();
        dao.findAllProducts().forEach(data -> list.add(data));
        return list;
    }


}
