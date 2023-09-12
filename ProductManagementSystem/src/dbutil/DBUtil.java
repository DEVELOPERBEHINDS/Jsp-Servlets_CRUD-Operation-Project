package dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection()
	{
		Connection conn = null;
		try   
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","1234");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	} 
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
