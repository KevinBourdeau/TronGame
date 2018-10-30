package model.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.mysql.cj.api.xdevapi.SqlResult;

/**
 * <h1>Database class</h1>
 * 
 * @author kevinbourdeau
 * @version 1.0
 */

public class Database extends AbstractDAO {

	private final static String sqlGetMapByID = "{call insert_data(?,?)}";
	private final static String sqlGetPodium = "{call podium()}";

	public void save(String player, int time) {
		final CallableStatement callStatement = prepareCall(sqlGetMapByID);

		try {
			callStatement.setString(1, player);
			callStatement.setInt(2, time);
			callStatement.execute();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String[] getPodium() {
		final CallableStatement callStatement = prepareCall(sqlGetPodium);
		String[] table = {"NULL", "NULL", "NULL"};
		
		try {
			callStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			callStatement.execute();
			table[0] = callStatement.getString(1);
			//table[1] = callStatement.getString(2);
			//table[2] = callStatement.getString(3);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return table;
	}

}
