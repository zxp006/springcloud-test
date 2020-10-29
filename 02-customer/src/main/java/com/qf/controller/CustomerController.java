package com.qf.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qf.client.ProductClient;
import com.qf.client.SearchClient;
import com.qf.entity.Customer;
import com.qf.entity.User;
import com.qf.entity.UserParm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
//@RefreshScope
public class CustomerController {

    @Autowired
    private User user;

    @Autowired
    private RestTemplate restTemplate;

/*    @Resource
    private EurekaClient eurekaClient;*/


    @Resource
    private SearchClient searchClient;

    @Resource
    private ProductClient productClient;

    @Value("${version}")
    private String version;

    @RequestMapping("/getversion")
    public String getVersion() {
        System.out.println(user);
        return version;
    }

    @RequestMapping("/customer")
    public String customer() {
        System.out.println(Thread.currentThread().getName());
      /*  //1. 通过eurekaClient获取到SEARCH服务的信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("SEARCH", false);

        //2. 获取到访问的地址
        String url = info.getHomePageUrl();
        System.out.println(url);

        //3. 通过restTemplate访问
        String result = restTemplate.getForObject(url + "/search", String.class);
*/

/*        //Robbin时
        String result = restTemplate.getForObject("http://SEARCH/search", String.class);*/

        /**
         * 两边的参数可以用RequestBody,RequestParam,但是必须RequestBody对equestBody,RequestParam对RequestParam,不可交叉。
           如果参数没有注明RequestBody或RequestParam,相当于RequestParam,包括直接传递对象
         */
        UserParm user=productClient.demo1(new UserParm(100,"张三"));
        /**
         * demo2与demoNever调用的是同一个远程方法，说明返回值可以在调用处根据需要反序列化成自定义对象
         * 返回值与远程方法返回值不要求字段完全相同，两边可以部分相同，部分不同,部分相同的接受值,不同的为null；参数同理
         */
        UserParm user2=productClient.demo2(2,"155");
        JSONObject object= productClient.demoNever(2,"2333");
        System.out.println("object:"+object);
        String result = searchClient.search()+" "+user+" "+user2;

        //4. 返回
        return result;
    }

    @RequestMapping("/customer/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "fasle"),
            /* @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")*/

            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })
    public Customer findById(@PathVariable Integer id) throws InterruptedException {
        System.out.println(searchClient.search());
        System.out.println(Thread.currentThread().getName());
//        TimeUnit.SECONDS.sleep(1);
//        if (id == 1) {
//            int i = 1 / 0;
//        }
        Customer customer = searchClient.findById_c(id);
        customer.setName(customer + version);
        return customer;
    }

    //findById的降级方法
    public Customer findByIdFallBack(@PathVariable Integer id) {
        return new Customer(id, "基本数据2" + version, 200);
    }


    @RequestMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        System.out.println(searchClient.search());
        return searchClient.getCustomer(id, name);
    }

    @RequestMapping("/save")
    public Customer save(Customer customer) {
        System.out.println(searchClient.search());
        return searchClient.save(customer);
    }


}
