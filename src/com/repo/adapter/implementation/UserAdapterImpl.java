package com.repo.adapter.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gen.exception.DBException;
import com.gen.util.AppLogger;
import com.gen.util.ApplicationConstants;
import com.gen.util.DataBaseConnection;
import com.gen.util.LoadProperties;
import com.repo.adapter.UserAdapter;
import com.repo.dao.UserDao;

public class UserAdapterImpl implements UserAdapter{
	private Logger logger = null;
	private LoadProperties properties;
	
	private DataBaseConnection dataBaseConnection;
	private Integer newUserId = -1;
	public UserAdapterImpl() {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}
	@Override
	public Integer save(UserDao userDao) throws DBException {

		logger.info(properties.getPropertyForValue("adapterEntry") + UserAdapterImpl.class);
		try {
			dataBaseConnection = new DataBaseConnection();
			Connection con = dataBaseConnection.newConnection();
			
			String sqlQuery = properties.getPropertyForValue("getUserSequence");
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.executeQuery();
			ResultSet userSequenceResultSet = preparedStatement.getResultSet();
			if (userSequenceResultSet.next()) {
				newUserId = userSequenceResultSet.getInt(1);
			}
			
			String sqlInsertQuery = properties.getPropertyForValue("userInsert");
			preparedStatement = con.prepareStatement(sqlInsertQuery);
			
			preparedStatement.setInt(1, newUserId);
			if (userDao != null) {
				preparedStatement.setString(2, userDao.getFirstName());
				preparedStatement.setString(3, userDao.getLastName());
				preparedStatement.setString(4, userDao.getAddress());
				preparedStatement.setString(5, userDao.getMobile());
				preparedStatement.setString(6, userDao.getEmail());
				preparedStatement.setInt(7, userDao.getAge());
				preparedStatement.setString(8, userDao.getGender().toString());
				preparedStatement.setString(9, userDao.getPassword());
			}
			preparedStatement.executeUpdate();
			
			if (preparedStatement.getUpdateCount() == ApplicationConstants.RESULTSETEXECUTEUPDATEDEFAULTRETURN) {
				logger.info("User Created. " + properties.getPropertyForValue("adapterExit") + UserAdapterImpl.class);
				return newUserId;
			}
		} catch(SQLException sqlException) {
			logger.error((sqlException.getMessage()));
			throw new DBException(sqlException);
		} finally {
			dataBaseConnection.closeConnection();
		}
		logger.info("User creation failed. " + properties.getPropertyForValue("adapterExit") + UserAdapterImpl.class);
		return newUserId;
	}
}
