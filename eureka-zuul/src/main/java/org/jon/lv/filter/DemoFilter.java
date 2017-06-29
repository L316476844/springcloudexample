package org.jon.lv.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package org.jon.lv.filter.DemoFilter
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/29 13:28
 * version V1.0.0
 */
@Component
public class DemoFilter extends ZuulFilter {

    @Override
    public String filterType() {

        /**
         * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
         * pre：路由之前
         * routing：路由之时
         * post： 路由之后
         * error：发送错误调用
         * filterOrder：过滤的顺序
         * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
         * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
         */

        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("token");

        if(accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ok");

        return null;
    }
}
