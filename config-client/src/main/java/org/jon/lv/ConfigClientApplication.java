package org.jon.lv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package org.jon.lv.ConfigClientApplication
 * @Description: ConfigClientApplication
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/3 13:35
 * version V1.0.0
 */

@RestController
@SpringBootApplication
public class ConfigClientApplication {

    @Value("${jon}")
    String jon;

    @RequestMapping(value = "/jon")
    public String jon(){
        return jon;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
