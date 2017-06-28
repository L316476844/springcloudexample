package org.jon.lv.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Package org.jon.lv.service.DemoService
 * @Description: DemoService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/28 13:58
 * version V1.0.0
 */
@Service
public class DemoService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonError")
    public String ribbon(String name) {
        return name + "----" +restTemplate.getForObject("http://eureka-client/demo", String.class);
    }

    public String ribbonError(String name) {
        return "hi,"+name+",sorry, net error!";
    }
}
