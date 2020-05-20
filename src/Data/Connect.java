package Data;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connect {

	
	public static Connection getConnect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url= "jdbc:sqlserver://BVCN88LTV:1433;databaseName=QLCF_BTL;user=sa;password=123456;useUnicode=true;characterEncoding=UTF-8";
			Connection conn= DriverManager.getConnection(url);
			return conn;
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "LOI");
		return null;
		
	}
		
	}
}
