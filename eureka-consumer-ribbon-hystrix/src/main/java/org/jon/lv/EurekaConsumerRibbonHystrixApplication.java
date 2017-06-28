package org.jon.lv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
public class EurekaConsumerRibbonHystrixApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        /**
         * Spring Cloud Ribbon的时候，不论是与Eureka还是Consul结合，
         * 都会在引入Spring Cloud Eureka或Spring Cloud Consul依赖的时候通过自动化配置来加载上述所说的配置内容，
         * 所以我们可以快速在Spring Cloud中实现服务间调用的负载均衡。
         */

        return new RestTemplate();
    }
    public static void main(String[] args) {

        SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
    }
}