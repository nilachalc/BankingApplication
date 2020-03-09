package com.logic.service.Implementation;

import org.apache.log4j.Logger;

import com.data.bean.AccountBean;
import com.gen.exception.DBException;
import com.gen.exception.ServiceException;
import com.gen.util.AppLogger;
import com.gen.util.LoadProperties;
import com.logic.mapper.AccountDataMapper;
import com.logic.service.AccountService;
import com.repo.adapter.AccountAdapter;
import com.repo.adapter.implementation.AccountAdapterImpl;
import com.repo.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	private Logger logger = null;
	private LoadProperties properties;
	
	private AccountDataMapper accountDataMapper;
	private AccountDao accountDao;
	private AccountAdapter accountAdapter;
	
	public AccountServiceImpl() {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}


	@Override
	public AccountBean saveAccountInfo(AccountBean accountBean) throws ServiceException {
		logger.info(properties.getPropertyForValue("serviceEntry") + AccountServiceImpl.class);
		accountDataMapper = new AccountDataMapper();
		accountAdapter = new AccountAdapterImpl();
		
		try {
			accountDao = accountDataMapper.mapBeanDataToDao(accountBean);
			accountBean.setAccountNumber(accountAdapter.save(accountDao));
		} catch (DBException dbException) {
			logger.error((dbException.toString() + "\n" + dbException.getMessage()));
			throw new ServiceException(dbException);
		}
		
		logger.info(properties.getPropertyForValue("serviceExit") + AccountServiceImpl.class);
		return accountBean;
	}
}
