package org.jon.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Package org.jon.lv.ConfigEurekaServerApplication
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/4 13:35
 * version V1.0.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigEurekaServerBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServerBusApplication.class, args);
    }
}
