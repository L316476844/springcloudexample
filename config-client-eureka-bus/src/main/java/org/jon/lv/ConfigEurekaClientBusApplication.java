package org.jon.lv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package org.jon.lv.ConfigClientApplication
 * @Description: ConfigClientApplication
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/3 13:35
 * version V1.0.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigEurekaClientBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaClientBusApplication.class, args);
    }
}
