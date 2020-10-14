package com.qf.client;

import com.qf.entity.Customer;
import com.qf.factory.SearchClientFallBackFactory;
import com.qf.fallback.SearchClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "SEARCH-API"
  ,fallback = SearchClientFallBack.class
/*,fallbackFactory = SearchClientFallBackFactory.class*/)   // 指定服务名称


public interface SearchClient {

    // value -> 目标服务的请求路径，method -> 映射请求方式
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search();

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    Customer findById(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
    Customer getCustomer(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Customer save(@RequestBody Customer customer);



}
