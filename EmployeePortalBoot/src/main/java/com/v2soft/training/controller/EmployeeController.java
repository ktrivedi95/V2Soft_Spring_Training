package com.v2soft.training.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.v2soft.training.dao.EmployeeDao;
import com.v2soft.training.dao.EmployeeDaoImpl;
import com.v2soft.training.datamodel.EmployeeBasicInfo;
import com.v2soft.training.datamodel.EmployeeLoginMod;
import com.v2soft.training.datamodel.EmployeeMod;
import com.v2soft.training.datamodel.LoginCredentials;
import com.v2soft.training.datamodel.ValidateUser;
import com.v2soft.training.model.Employee;
import com.v2soft.training.service.EmployeeList;
import com.v2soft.training.service.EmployeeService;

@Controller
public class EmployeeController {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() throws JsonProcessingException {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/getEmployeeById/{employeeId}", method=RequestMethod.GET)
	@ResponseBody
	public String getEmployeeById(@PathVariable String employeeId) throws JsonProcessingException {
		return mapper.writeValueAsString(employeeService.getEmployeeById(employeeId));
	}
	
	/*@RequestMapping(value="/getEmployeeAddressByIdAndType", method=RequestMethod.GET)
	@ResponseBody
	public String getEmployeeAddressByIdAndType(@RequestBody String json) throws JsonProcessingException {
		List list = employeeService.getEmployeeAddressByIdAndType("current", "222");
		return mapper.writeValueAsString(list);
	}*/
	
	//http://localhost:8080/EmployeePortal/getEmployeeList
	@RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)    
    public ModelAndView getEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        mav = new ModelAndView("employeeList");
    	List<EmployeeMod> list = employeeService.getEmployeeList();
        mav.addObject("lists", list);
        
        return mav;
    }
	
	//http://localhost:8080/EmployeePortal/countEmployees
	@RequestMapping(value="/countEmployees", method=RequestMethod.GET)
	@ResponseBody
	public String countEmployees() throws JsonProcessingException {
		return mapper.writeValueAsString(employeeService.countEmployees());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	//HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") LoginCredentials login
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") LoginCredentials login) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
    }
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)    
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") LoginCredentials login) {
        ModelAndView mav = null;
        
        //HttpSession session = request.getSession(false);
        
        ValidateUser user = employeeService.validateUser(login);
        EmployeeMod emp = user.getEmp();
        //response.setHeader("LoginSessionId", user.getUuid().toString());
        
        if(emp != null) {
        	response.addCookie(new Cookie("LoginSessionId", user.getUuid().toString()));
        	
        	mav = new ModelAndView("welcome");
        	mav.addObject("firstname", emp.getFirstName());
        	mav.addObject("lastname", emp.getLastName());
        } else {
        	mav = new ModelAndView("login");
        }
        
        return mav;
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout (HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") LoginCredentials login) {
		Cookie[] cookies = request.getCookies();
        String loginSessionId = "";
        for(Cookie c: cookies) {
        	if(c.getName().equals("LoginSessionId"))
        		loginSessionId = c.getValue();
        }
        
		employeeService.performLogout(loginSessionId);
		
		Cookie[] removeCookies = request.getCookies();
        for(Cookie c: removeCookies) {
        	c.setMaxAge(0);
        }
		//response.addCookie(new Cookie("LoginSessionId", ""));
	    return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)    
    public ModelAndView searchEmployee(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employee") EmployeeBasicInfo employeeMod) {
        ModelAndView mav = new ModelAndView("searchEmployee");
        return mav;
    }
	
	@RequestMapping(value = "/searchEmployeeProcess", method = RequestMethod.POST)//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})    
    public ModelAndView searchEmployeeProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employee") EmployeeBasicInfo employeeMod) {
        ModelAndView mav = new ModelAndView("searchEmployeeInfo");
        List<EmployeeMod> empList = employeeService.searchEmployee(employeeMod);
        mav.addObject("lists", empList);
        return mav;
    }
}
