package com.handler.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.data.bean.UserBean;
import com.gen.util.AppLogger;
import com.gen.util.LoadProperties;

public class RequestHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
	private LoadProperties properties;
       
    public RequestHandlerServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info(properties.getPropertyForValue("servletEntry") + RequestHandlerServlet.class);
		Object pageAttribute = request.getAttribute("page");
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			if (pageAttribute != null) {
				if (pageAttribute instanceof String) {
					if (((String)pageAttribute).equals(properties.getPropertyForValue("goBack"))) {
						response.sendRedirect("Jsps/LogInHome.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("createUserAndAccount"))) {
						response.sendRedirect("Jsps/UserAndAccountCreation.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("deleteAnUser"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("addAnAccount"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("deleteAnAccount"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("updateAccountBalance"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("makeATransaction"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("viewAccountBalanceAndStatement"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					} else if (((String)pageAttribute).equals(properties.getPropertyForValue("viewAnUser"))) {
						response.sendRedirect("Jsps/LogInFailed.jsp");
					}
				} else {
					if (((Class<LogInServlet>)pageAttribute).equals(LogInServlet.class)) {
						if (((UserBean) request.getAttribute("basicUserInfo")).getUserId() != null) {
							response.sendRedirect("Jsps/LogInHome.jsp");
						} else {
							response.sendRedirect("Jsps/LogInFailed.jsp");
						}
					} else if (((Class<LogInFailedServlet>)pageAttribute).equals(LogInFailedServlet.class)) {
						response.sendRedirect("LogIn.jsp");
					} else if (((Class<UserAndAccountCreationServlet>)pageAttribute).equals(UserAndAccountCreationServlet.class)) {
						response.sendRedirect("Jsps/LogInHome.jsp");
					} else if (((Class<LogInHomeServlet>)pageAttribute).equals(LogInHomeServlet.class)) {
						response.sendRedirect("Jsps/LogOut.jsp");
					}
				}
			} else {
				logger.error(properties.getPropertyForValue("navigationError"));
			}
		} else {
			if (pageAttribute instanceof String) {
				if (((String)pageAttribute).equals(properties.getPropertyForValue("goBack"))) {
					response.sendRedirect("LogIn.jsp");
				} else {
					response.sendRedirect("Jsps/SessionTimedOut.jsp");
				}
			} else {
				if (((Class<LogInServlet>)pageAttribute).equals(LogInServlet.class) && request.getAttribute("basicUserInfo") == null) {
					response.sendRedirect("Jsps/UserRegistration.jsp");
				} else if (((Class<LogOutServlet>)pageAttribute).equals(LogOutServlet.class)) {
					response.sendRedirect("LogIn.jsp");
				} else if (((Class<SessionTimedOutServlet>)pageAttribute).equals(SessionTimedOutServlet.class)) {
					response.sendRedirect("LogIn.jsp");
				} else if (((Class<UserRegistrationServlet>)pageAttribute).equals(UserRegistrationServlet.class)) {
					response.sendRedirect("LogIn.jsp");
				} else {
					response.sendRedirect("Jsps/SessionTimedOut.jsp");
				}
			}
		}
		
		logger.info(properties.getPropertyForValue("servletExit") + RequestHandlerServlet.class);
	}
}
