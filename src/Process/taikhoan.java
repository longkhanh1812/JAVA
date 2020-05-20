package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Data.Connect;

public class taikhoan {

	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static void insert(int id,String username,String password,int lv)
	{
		String sql = "INSERT INTO taikhoan (id ,username,password, lv ) VALUES  ( ?,?,?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setInt(4, lv);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã thêm ID: "+id+ " thành công", "Thông báo",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Mã ID :"+id+ " không thể thêm", "Thông báo",1);

		
	}
	}
	
	public static void sua(int id,String username,String password,int lv)
	{
		String sql = "UPDATE taikhoan SET username= '"+username +"',password= '" +password+"',lv= "+lv +" WHERE id="+id +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã sửa ID : "+id+ " thành công", "Thông báo",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Mã ID :"+id+ " không thể sửa", "Thông báo",1);

		
	}
	}
	
	public static void delete(int id)
	{
		String sql = "DELETE FROM dbo.taikhoan WHERE id =" + id +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã xóa ID: "+id+ " thành công", "Thông báo",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Mã ID :"+id+ " không thể xóa", "Thông báo",1);

		
	}
	}

}
