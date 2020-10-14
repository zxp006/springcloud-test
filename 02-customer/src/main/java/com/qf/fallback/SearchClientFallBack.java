package com.qf.fallback;

import com.qf.client.SearchClient;
import com.qf.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class SearchClientFallBack implements SearchClient {
    @Override
    public String search() {
        return "出现问题啦！！！-容错数据";
    }

    @Override
    public Customer findById(Integer id) {
        return new Customer(1,"基本数据-容错数据",100);
    }

    @Override
    public Customer getCustomer(Integer id, String name) {
        return new Customer(2,"基本数据-容错数据",100);
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

}
