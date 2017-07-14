package org.jon.lv.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package org.jon.lv.web.DemoController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/7/13 17:52
 * version V1.0.0
 */
@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class DemoController {

    @Value("${jon}")
    String jon = "default";

    @RequestMapping(value = "/jon")
    public String jon(){
        return jon;
    }
}
