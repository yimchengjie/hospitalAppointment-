package evil.devil.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */

@WebFilter(
		urlPatterns = { "/jsp/index.jsp",
				"/jsp/contact.jsp",
				"/jsp/doctorDepartment.jsp", 
				"/jsp/gallery.jsp" ,
				"/jsp/UserManegeMain.jsp",
				"/jsp/services.jsp",
				"/jsp/about.jsp", 
				"/jsp/contact.jsp" 
		}  
		)
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest) request;
//		if(req.getParameter("username")!=null) {
//			chain.doFilter(request, response);
//		}
//		else {
			if(req.getSession().getAttribute("user")==null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			// pass the request along the filter chain
			else {
				chain.doFilter(request, response);
			}
		//}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
