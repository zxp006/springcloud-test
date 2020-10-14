package com.qf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class SearchApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SearchApplication.class,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
