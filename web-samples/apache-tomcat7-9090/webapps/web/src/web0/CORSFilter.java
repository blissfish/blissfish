package web0;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Credentials","true");
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD");
		((HttpServletResponse)response).addHeader("Access-Control-Max-Age","1209600");
		chain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
