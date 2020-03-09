package com.handler.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.data.bean.AccountBean;
import com.data.bean.UserBean;
import com.gen.exception.ServiceException;
import com.gen.util.AppLogger;
import com.gen.util.ApplicationConstants;
import com.gen.util.LoadProperties;
import com.logic.service.UserService;
import com.logic.service.Implementation.UserServiceImpl;

public class UserAndAccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
	private LoadProperties properties;
	
	private UserService userService;
	private UserBean userBean;
	
    public UserAndAccountCreationServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info(properties.getPropertyForValue("servletEntry") + UserAndAccountCreationServlet.class);
		userBean = new UserBean();
		AccountBean accountBean = new AccountBean();
		List<AccountBean> accountBeans = new ArrayList<AccountBean>();
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
			
			accountBean.setAccountType(request.getParameter("userAccountType"));
			accountBean.setBranch(request.getParameter("userBranch"));
			accountBean.setSalaryAccount(request.getParameter("userSalaryAccount"));
			accountBean.setInitialDeposit(request.getParameter("userInitialDeposit"));
			accountBean.setCurrentBalance(accountBean.getInitialDeposit());
			accountBeans.add(accountBean);

			userBean.setAccountBeans(accountBeans);
			
			try {
				userBean = userService.saveUserInfo(userBean);
			} catch (ServiceException serviceException) {
				logger.error((serviceException.toString() + "\n" + serviceException.getMessage()));
			}
			
			if (userBean.getUserId() != null && userBean.getAccountBeans().get(ApplicationConstants.LISTFIRSTINDEX).getAccountNumber() != null) {
				request.getServletContext().setAttribute("userAccountCreated", new Boolean(true));
			}
			request.setAttribute("page", UserAndAccountCreationServlet.class);
		}
		
		request.getRequestDispatcher(properties.getPropertyForValue("handelRequest")).forward(request, response);
		logger.info(properties.getPropertyForValue("servletExit") + UserAndAccountCreationServlet.class);
	}
}
