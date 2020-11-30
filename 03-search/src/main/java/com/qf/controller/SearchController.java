package com.qf.controller;


import com.qf.entity.Customer;
import com.qf.repo.entity.ShBook;
import com.qf.repo.service.ShBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {
    Logger logger = LoggerFactory.getLogger(SearchController.class);
    @Autowired
    private ShBookService shBookService;

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private  String name;

    @RequestMapping("/search")
    public String search() {

        return String.format("应用信息%s:%d",name,port);
    }


    @RequestMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        ShBook shBook=new ShBook();
        shBook.setId(1);
        shBook.setStock(1000);
        shBookService.updateById(shBook);
        ShBook shBook2 = shBookService.getById(1);
        logger.info("book={}",shBook2);
        return new Customer(id, "张三", (int) (Math.random() * 100000));
    }

    @RequestMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        return new Customer(id, name, 23);
    }

    @RequestMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        logger.info("保存的对象值:" + customer);
        return customer;
    }

}
