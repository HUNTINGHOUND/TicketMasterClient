package db;

import db.mongodb.MongoDBConnection;
import db.mysql.MySQLConnection;

/**
 * Factory class for building database connections without exposing implementation
 * @author morgan
 *
 */
public class DBConnectionFactory {
	private static final String DEFAULT_DB = "mysql";
	
	/**
	 * Return database connection based on option given
	 * @param db either "mysql" or "mongodb" based on which database connection
	 * client wants
	 * @return a database connection
	 */
	public static DBConnection getConnection(String db) {
		switch(db ) {
			case "mysql":
				return new MySQLConnection();
			case "mongodb":
				return MongoDBConnection.getInstance();
			default:
				throw new IllegalArgumentException("Invalid db: " + db);
		}
	}
	
	/**
	 * 
	 * @return a mysql database connection
	 */
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
	}
}
