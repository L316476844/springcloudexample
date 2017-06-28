package org.jon.lv.controller;

import org.jon.lv.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class ConsumerController {

    @Autowired
    DemoService demoService;

    @GetMapping("/feign")
    public String feign(@RequestParam String name) {
        return name + "-----" + demoService.demo();
    }
}
