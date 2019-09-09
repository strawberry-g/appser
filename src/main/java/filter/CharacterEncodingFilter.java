package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

// 过滤器的使用场景之一：设置全局字符集
@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = "/*", initParams = {@WebInitParam(name =
        "characterEncoding", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    private String characterEncoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(characterEncoding);
        resp.setCharacterEncoding(characterEncoding);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        characterEncoding = config.getInitParameter("characterEncoding");
    }

}