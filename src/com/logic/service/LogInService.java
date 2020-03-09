package com.logic.service;

import com.data.bean.UserBean;
import com.gen.exception.ServiceException;

public interface LogInService {
	
	public UserBean readLogInInfo(UserBean userBean) throws ServiceException;
}
