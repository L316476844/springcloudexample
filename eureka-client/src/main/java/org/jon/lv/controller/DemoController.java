package org.jon.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package org.jon.lv.controller.DemoController
 * @Description: DemoController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/27 15:42
 * version V1.0.0
 */
@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/demo")
    public String demo() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
