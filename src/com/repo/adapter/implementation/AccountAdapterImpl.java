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
import com.repo.adapter.AccountAdapter;
import com.repo.dao.AccountDao;

public class AccountAdapterImpl  implements AccountAdapter{
	private Logger logger = null;
	private LoadProperties properties;
	
	private DataBaseConnection dataBaseConnection;
	private Integer newAccountId = -1;
	public AccountAdapterImpl() {
		logger = AppLogger.getLogger();
    	properties = new LoadProperties();
	}
	@Override
	public Integer save(AccountDao accountDao) throws DBException {

		logger.info(properties.getPropertyForValue("adapterEntry") + AccountAdapterImpl.class);
		try {
			dataBaseConnection = new DataBaseConnection();
			Connection con = dataBaseConnection.newConnection();
			
			String sqlQuery = properties.getPropertyForValue("getAccountSequence");
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.executeQuery();
			ResultSet accountSequenceResultSet = preparedStatement.getResultSet();
			if (accountSequenceResultSet.next()) {
				newAccountId = accountSequenceResultSet.getInt(1);
			}
			
			String sqlInsertQuery = properties.getPropertyForValue("accountInsert");
			preparedStatement = con.prepareStatement(sqlInsertQuery);
			
			preparedStatement.setInt(1, newAccountId);
			if (accountDao != null) {
				preparedStatement.setString(2, accountDao.getAccountType());
				preparedStatement.setString(3, accountDao.getBranch());
				preparedStatement.setBoolean(4, accountDao.getSalaryAccount());
				preparedStatement.setDouble(5, accountDao.getInitialDeposit());
				preparedStatement.setDouble(6, accountDao.getCurrentBalance());
				preparedStatement.setInt(7, accountDao.getUserId());
			}
			preparedStatement.executeUpdate();
			
			if (preparedStatement.getUpdateCount() == ApplicationConstants.RESULTSETEXECUTEUPDATEDEFAULTRETURN) {
				logger.info("Account Created. " + properties.getPropertyForValue("adapterExit") + AccountAdapterImpl.class);
				return newAccountId;
			}
		} catch(SQLException sqlException) {
			logger.error((sqlException.getMessage()));
			throw new DBException(sqlException);
		} finally {
			dataBaseConnection.closeConnection();
		}
		logger.info("Account creation failed. " + properties.getPropertyForValue("adapterExit") + AccountAdapterImpl.class);
		return newAccountId;
	}

}
