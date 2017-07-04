package org.jon.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Package org.jon.lv.ConfigEurekaServerApplication
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/4 13:35
 * version V1.0.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServerApplication.class, args);
    }
}
