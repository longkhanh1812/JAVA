package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Data.Connect;

public class thucdon {

	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static void insert(int mamon,String tenmon,int dongia,String dvt,int maloai)
	{
		String sql = "INSERT INTO thucdon (mamon ,tenmon,dongia, DVT,maloai ) VALUES  ( ?,?,?,?,?)";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mamon);
			pst.setString(2, tenmon);
			pst.setInt(3, dongia);
			pst.setString(4, dvt);
			pst.setInt(5, maloai);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã thêm thành công", "Thong bao",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Không thêm được", "Thong bao",1);

		
	}
	}
	
	public static void sua(int mamon,String tenmon,int dongia,String dvt,int maloai)
	{
		String sql = "UPDATE thucdon SET tenmon= '"+tenmon +"',dongia=" +dongia+",DVT= '"+dvt +"',maloai =" +maloai+" WHERE mamon="+mamon +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã sửa thành công", "Thong bao",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Không sửa được", "Thong bao",1);

		
	}
	}
	
	public static void delete(int mamon)
	{
		String sql = "DELETE FROM dbo.thucdon WHERE mamon =" + mamon +"" ;
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Thong bao",1);
			
			
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Không thể xóa", "Thong bao",1);

		
	}
	}

}
