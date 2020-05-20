package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Data.Connect;

public class banhang {

	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static void inserthoadonmoi(int maban,int trangthai)
	{
		String sql = "INSERT INTO hoadon (maban ,trangthai) VALUES  ( ?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maban);
			pst.setInt(2, trangthai);
			pst.execute();
			
			
			
			
	}
	catch(Exception e)
	{
		

		
	}
	}
	
	public static void updatehoadon(int maban,int trangthai)
	{
		String sql = "UPDATE hoadon SET trangthai="+trangthai+"WHERE maban ="+maban;
		
		try {
			pst=conn.prepareStatement(sql);
			pst.execute();
			
			
			
			
	}
	catch(Exception e)
	{
		

		
	}
	}
	
	

}
