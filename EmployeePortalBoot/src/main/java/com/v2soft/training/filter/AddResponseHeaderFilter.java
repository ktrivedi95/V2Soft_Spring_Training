package com.v2soft.training.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.v2soft.training.dao.EmployeeDao;
import com.v2soft.training.dao.EmployeeDaoImpl;
import com.v2soft.training.model.LoginSession;
import com.v2soft.training.service.EmployeeService;

//@Component
//@Order(1)
public class AddResponseHeaderFilter implements Filter {
	
	private List<String> excludedUrls;
	
	//@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public Session getCurrentSession() {
        //return sessionFactory.getCurrentSession();
    	return sessionFactory.openSession();
    }
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		//this.context = fConfig.getServletContext();
		//this.context.log("AuthenticationFilter initialized");
		//String excludePattern = fConfig.getInitParameter("excludedUrls");
        //excludedUrls = Arrays.asList(excludePattern.split(","));
		
		excludedUrls = new ArrayList<String>();
		excludedUrls.add("/");
		excludedUrls.add("/login");
		excludedUrls.add("/loginProcess");
        
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(fConfig.getServletContext());
	    sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
	}
	
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        String path = request.getServletPath();
        
        if(!excludedUrls.contains(path))
        {
        	Cookie[] cookies = request.getCookies();
            String loginSessionId = "";
            for(Cookie c: cookies) {
            	if(c.getName().equals("LoginSessionId"))
            		loginSessionId = c.getValue();
            }
            
            if(!checkLoginSession(loginSessionId)) {
            	//THE STATUS IS TERMINATED
            	response.sendRedirect("/login");
            } else {
            	//THE STATUS IS ACTIVE
            	chain.doFilter(request, response);
            }
        }
        
        /*if(path.equals("/login")) {
        	
        }*/
        
        chain.doFilter(request, response);
    }
    
    @Transactional
	public boolean checkLoginSession(String loginSessionId) {
		String createQuery = "from LoginSession";
	    Query<LoginSession> query = getCurrentSession().createQuery(createQuery);
	    String status = "";
	    List<LoginSession> loginSession = query.getResultList();
	    for(LoginSession loginSess: loginSession) {
	        if(loginSessionId.equals(loginSess.getId().getLoginSessionId())){
	            status = loginSess.getStatus();
	        }
	    }
	    if(status.equals("A"))
	        return true;
	    return false;
	}
 
    @Override
    public void destroy() {
    	
    }
}