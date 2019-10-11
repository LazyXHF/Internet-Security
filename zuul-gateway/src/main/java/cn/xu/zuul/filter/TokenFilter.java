package cn.xu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器
 * @author ~许小桀
 * @date 2019/10/11 10:21
 */
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //此处为前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0; //优先级为0,数字越大,优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;
        //是否执行过滤器,此处为true,说明需要过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            //返回错误信息
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("accessToken is null");
            return null;
        }
        return null;
    }
}
