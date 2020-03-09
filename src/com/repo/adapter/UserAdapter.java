package com.repo.adapter;

import com.gen.exception.DBException;
import com.repo.dao.UserDao;

public interface UserAdapter {
	public Integer save(UserDao userDao) throws DBException;
}
