package com.handler.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.data.bean.UserBean;
import com.gen.exception.ServiceException;
import com.gen.util.AppLogger;
import com.gen.util.LoadProperties;
import com.logic.service.UserService;
import com.logic.service.Implementation.UserServiceImpl;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
	private LoadProperties properties;
	
	private UserService userService;
	private UserBean userBean;

	public UserRegistrationServlet() {
		super();
	}
	
    public void init() {
    	logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info(properties.getPropertyForValue("servletEntry") + UserRegistrationServlet.class);
		userBean = new UserBean();
		userService = new UserServiceImpl();
		
		if (request.getParameter("cancelOperation").equals(properties.getPropertyForValue("goBack"))) {
			request.setAttribute("page", properties.getPropertyForValue("goBack"));
		} else {
			userBean.setFirstName(request.getParameter("userFirstName"));
			userBean.setLastName(request.getParameter("userLastName"));
			userBean.setAddress(request.getParameter("userAddress"));
			userBean.setMobile(request.getParameter("userMobile"));
			userBean.setEmail(request.getParameter("userEmail"));
			userBean.setAge(Integer.parseInt(request.getParameter("userAge")));
			userBean.setGender(request.getParameter("userGender"));
			userBean.setPassword(request.getParameter("userPassword"));
			
			try {
				userBean = userService.saveUserInfo(userBean);
			} catch (ServiceException serviceException) {
				logger.error((serviceException.toString() + "\n" + serviceException.getMessage()));
			}
			
			if (userBean.getUserId() != null) {
				request.getServletContext().setAttribute("userCreated", new Boolean(true));
			}
			request.setAttribute("page", UserRegistrationServlet.class);
		}
		request.getSession(false).invalidate();
		request.getRequestDispatcher(properties.getPropertyForValue("handelRequest")).forward(request, response);
		logger.info(properties.getPropertyForValue("servletExit") + UserRegistrationServlet.class);
	}

}
