package org.jon.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Package org.jon.lv.ConfigServerApplication
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/3 10:44
 * version V1.0.0
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
