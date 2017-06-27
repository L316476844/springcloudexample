package org.jon.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Package org.jon.lv.controller.DemoController
 * @Description: DemoController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/27 15:42
 * version V1.0.0
 */
@RestController
public class ConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient; //LoadBalancerClient接口的命名中，我们就知道这是一个负载均衡客户端的抽象定义
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {

        /**
         * consumer接口的实现中，先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，
         * 这个服务实例的基本信息存储在ServiceInstance中，然后通过这些对象中的信息拼接出访问/dc接口的详细地址，
         * 最后再利用RestTemplate对象实现对服务提供者接口的调用。
         *
         * eureka-server、eureka-client、eureka-consumer都启动
         * 访问http://localhost:2101/consumer ，来跟踪观察eureka-consumer服务是如何消费eureka-client服务的/dc接口的
         */

        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/demo";

        System.out.println("******************************" + url);

        return restTemplate.getForObject(url, String.class);
    }
}
