package org.jon.lv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class EurekaConsumerFeignApplication {
    public static void main(String[] args) {

        SpringApplication.run(EurekaConsumerFeignApplication.class, args);
    }
}