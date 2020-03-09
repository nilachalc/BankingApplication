package com.logic.mapper;

import com.data.bean.AccountBean;
import com.repo.dao.AccountDao;

public class AccountDataMapper {
private AccountDao accountDao;
	
	public AccountDao mapBeanDataToDao(AccountBean accountBean) {
		accountDao = new AccountDao();
		
		accountDao.setAccountNumber(accountBean.getAccountNumber());
		accountDao.setBranch(accountBean.getBranch());
		accountDao.setSalaryAccount(Boolean.parseBoolean(accountBean.getSalaryAccount()));
		accountDao.setAccountType(accountBean.getAccountType());
		accountDao.setInitialDeposit(Double.parseDouble(accountBean.getInitialDeposit())); 
		accountDao.setCurrentBalance(Double.parseDouble(accountBean.getCurrentBalance()));
		accountDao.setUserId(accountBean.getUserId());
		
		return accountDao;
	}
}
