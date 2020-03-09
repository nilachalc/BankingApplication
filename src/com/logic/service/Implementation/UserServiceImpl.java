package com.logic.service.Implementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.data.bean.AccountBean;
import com.data.bean.UserBean;
import com.gen.exception.DBException;
import com.gen.exception.ServiceException;
import com.gen.util.AppLogger;
import com.gen.util.ApplicationConstants;
import com.gen.util.LoadProperties;
import com.logic.mapper.UserDataMapper;
import com.logic.service.AccountService;
import com.logic.service.UserService;
import com.repo.adapter.UserAdapter;
import com.repo.adapter.implementation.UserAdapterImpl;
import com.repo.dao.UserDao;

public class UserServiceImpl implements UserService {
	private Logger logger = null;
	private LoadProperties properties;
	
	private AccountService accountService;

	private UserDataMapper userDataMapper;
	private UserDao userDao;
	private UserAdapter userAdapter;
	
	public UserServiceImpl() {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}
	
	@Override
	public UserBean saveUserInfo(UserBean userBean) throws ServiceException {
		logger.info(properties.getPropertyForValue("serviceEntry") + UserServiceImpl.class);
		userDataMapper = new UserDataMapper();
		userAdapter = new UserAdapterImpl();
		accountService = new AccountServiceImpl();
		List<AccountBean> accountBeans = userBean.getAccountBeans();
		
		try {
			userDao = userDataMapper.mapBeanDataToDao(userBean);
			userBean.setUserId(userAdapter.save(userDao));
			
			if (accountBeans != null) {
				AccountBean accountBean = accountBeans.get(ApplicationConstants.LISTFIRSTINDEX);
				accountBean.setUserId(userBean.getUserId());
				
				accountBean = accountService.saveAccountInfo(accountBean);
				userBean.getAccountBeans().add(ApplicationConstants.LISTFIRSTINDEX, accountBean);
			}
			
		} catch (DBException dbException) {
			logger.error((dbException.toString() + "\n" + dbException.getMessage()));
			throw new ServiceException(dbException);
		}
		logger.info(properties.getPropertyForValue("serviceExit") + UserServiceImpl.class);
		return userBean;
	}
}
