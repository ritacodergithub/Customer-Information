package customerOperations;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	public static Connection getConnect() {
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","rIt@6378#rb");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
