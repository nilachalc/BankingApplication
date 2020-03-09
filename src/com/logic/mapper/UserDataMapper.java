package com.logic.mapper;

import com.data.bean.UserBean;
import com.repo.dao.UserDao;

public class UserDataMapper {
	private UserDao userDao;
	
	public UserDao mapBeanDataToDao(UserBean userBean) {
		userDao = new UserDao();
		
		userDao.setFirstName(userBean.getFirstName());
		userDao.setLastName(userBean.getLastName());
		userDao.setAddress(userBean.getAddress());
		userDao.setMobile(userBean.getMobile());
		userDao.setEmail(userBean.getEmail());
		userDao.setAge(userBean.getAge());
		
		switch (userBean.getGender()) {
		case "male":
					userDao.setGender('M');
					break;
			
		case "female":
					userDao.setGender('F');
					break;

		default:
					userDao.setGender('O');
					break;
		}
		
		userDao.setPassword(userBean.getPassword());
		return userDao;
	}
}
