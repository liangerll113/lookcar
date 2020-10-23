package com.lookcar.xsyz.ntfirst.filter;

import com.lookcar.xsyz.ntfirst.context.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserTokenFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserTokenFilter.class);

    private static final String[] EXCLUDE_PATH = {"/login", "/loginout", "/test"};

    @Override
    public void init(FilterConfig arg0) {
        logger.info("初始化MyFilter");
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse;
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String servletPath = request.getServletPath();

        logger.info("MyFilter 请求处理, url={}, uri={}, servletPath={}", url, uri, servletPath);


        for (String path: EXCLUDE_PATH){
            if (servletPath.startsWith(path)){
                filterChain.doFilter(srequest, sresponse);
                return;
            }
        }
        String token = request.getHeader("AUTH_TOKEN");

        if (!UserContext.isValid(token)){
            response.setStatus(401);
            response.getWriter().write("{\"code\":\"401\",\"msg\":\"please login\"}");
            return;
        }

        UserContext.delay(token);
        filterChain.doFilter(srequest, sresponse);
    }

}
