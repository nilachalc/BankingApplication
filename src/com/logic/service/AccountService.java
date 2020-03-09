package com.logic.service;

import com.data.bean.AccountBean;
import com.gen.exception.ServiceException;

public interface AccountService {
	public AccountBean saveAccountInfo(AccountBean accountBean) throws ServiceException;
}
