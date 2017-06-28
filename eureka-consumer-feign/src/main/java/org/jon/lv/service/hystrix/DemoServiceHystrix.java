package org.jon.lv.service.hystrix;

import org.jon.lv.service.DemoService;
import org.springframework.stereotype.Component;

/**
 * @Package org.jon.lv.service.hystrix.DemoServiceHystrix
 * @Description: DemoServiceHystrix
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/28 11:26
 * version V1.0.0
 */
@Component
public class DemoServiceHystrix implements DemoService{
    @Override
    public String demo() {
        /**
         * demo 接口断路时 fallback返回一个固定值
         */
        return "sorry,net error";
    }
}
