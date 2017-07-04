package org.jon.lv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ConfigEurekaClientApplication {

    @Value("${jon}")
    String jon;

    @RequestMapping(value = "/jon")
    public String jon(){
        return jon;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaClientApplication.class, args);
    }
}
