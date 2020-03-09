package com.repo.adapter;

import com.gen.exception.DBException;
import com.repo.dao.UserDao;

public interface LogInAdapter {

	public void read(UserDao logInDao) throws DBException;
	
}
