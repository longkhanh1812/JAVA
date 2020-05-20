package Process;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Data.Connect;

public class nhommon {

	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static void insert(int maloai,String tenloai)
	{
		String sql = "INSERT INTO nhommon (maloai ,tenloai) VALUES  ( ?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maloai);
			pst.setString(2, tenloai);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã thêm :"+maloai+ " thành công", "Thông báo",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Mã Loại :"+maloai+ " Không thêm được", "Thông báo",1);

		
	}
	}
	
	public static void sua(int maloai,String tenloai)
	{
		String sql = "UPDATE nhommon SET tenloai= '"+tenloai +"' WHERE maloai="+maloai +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "ma loai "+maloai+ "da sua thanh cong", "Thong bao",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Ma Loai"+maloai+ " da khong the sua", "Thong bao",1);

		
	}
	}
	
	public static void delete(int maloai)
	{
		String sql = "DELETE FROM dbo.nhommon WHERE maloai =" + maloai +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "ma loai "+maloai+ "da xoa thanh cong", "Thong bao",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Ma loai"+maloai+ " da khong the xoa", "Thong bao",1);

		
	}
	}

}
