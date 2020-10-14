package com.qf.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qf.entity.UserParm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-product2",fallback = ProductClient.ProductClientCallBack.class )
public interface ProductClient {

    @RequestMapping("/product/api1/demo1")
    UserParm demo1(@RequestBody UserParm parm);

    @RequestMapping("/product/api1/demo2")
    UserParm demo2(@RequestParam("uid") Integer uid, @RequestParam("telephone") String telephone);

    @RequestMapping("/product/api1/demo2")
    JSONObject demoNever(@RequestParam("uid") Integer uid, @RequestParam("telephone") String telephone);

    @Component
    public class ProductClientCallBack implements  ProductClient{
        @Override
        public UserParm demo1(UserParm parm) {
            return new UserParm(1,"容错数据01");

        }

        @Override
        public UserParm demo2(Integer uid, String telephone) {
            return new UserParm(2,"容错数据02");
        }

        @Override
        public JSONObject demoNever(Integer uid, String telephone) {
            return JSONObject.parseObject(JSON.toJSONString(new UserParm(3,"容错数据03")));
        }
    }
}
