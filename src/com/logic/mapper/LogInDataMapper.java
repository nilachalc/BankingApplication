package com.logic.mapper;

import com.data.bean.UserBean;
import com.repo.dao.UserDao;

public class LogInDataMapper {
	private UserDao userDao;
	private UserBean userBean;
	
	public UserDao mapBeanDataToDao(UserBean userBean) {
		userDao = new UserDao();
		
		userDao.setFirstName(userBean.getFirstName());
		userDao.setPassword(userBean.getPassword());
		
		return userDao;
	}
	
	public UserBean mapDaoDataToBean(UserDao userDao) {
		userBean = new UserBean();
		
		userBean.setUserId(userDao.getUserId());
		userBean.setFirstName(userDao.getFirstName());
		
		return userBean;
	}
}