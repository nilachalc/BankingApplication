package com.repo.adapter;

import com.gen.exception.DBException;
import com.repo.dao.AccountDao;

public interface AccountAdapter {
	public Integer save(AccountDao accountDao) throws DBException;
}
