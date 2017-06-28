package org.jon.lv.service;

import org.jon.lv.service.hystrix.DemoServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Package org.jon.lv.service.DemoService
 * @Description: DemoService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/28 10:57
 * version V1.0.0
 */
@FeignClient(value = "eureka-client", fallback = DemoServiceHystrix.class)
public interface DemoService {
    @GetMapping(value= "/demo")
    String demo();
}
