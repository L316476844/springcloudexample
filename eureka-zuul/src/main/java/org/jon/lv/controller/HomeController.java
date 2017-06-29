package org.jon.lv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package org.jon.lv.controller.HomeController
 * @Description: HomeController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/29 11:00
 * version V1.0.0
 */
@RestController
public class HomeController {

    @RequestMapping("/index")
    public Object index() {
        return "index";
    }

    @RequestMapping("/home")
    public Object home() {
        return "home";
    }
}
