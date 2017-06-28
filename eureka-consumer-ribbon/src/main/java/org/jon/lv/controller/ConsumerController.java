package org.jon.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String ribbon() {
        return restTemplate.getForObject("http://eureka-client/demo", String.class);
    }
}
