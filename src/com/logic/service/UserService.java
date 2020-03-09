package com.logic.service;

import com.data.bean.UserBean;
import com.gen.exception.ServiceException;

public interface UserService {
	public UserBean saveUserInfo(UserBean userBean) throws ServiceException;
}
