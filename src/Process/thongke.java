package Process;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

import Data.Connect;
public class thongke {
	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static void selectlenbang()
	{
		String sql = "SELECT cthd.machitiethd AS 'Mã CTHĐ',hd.maban+1 AS 'Bàn',td.tenmon AS 'Tên món',cthd.soluong AS 'Số lượng', 'Thành Tiền' =cthd.soluong*td.dongia FROM dbo.chitiethd AS cthd,dbo.hoadon AS hd,thucdon AS td WHERE cthd.mamon=td.mamon AND hd.mahoadon=cthd.mahoadon AND hd.trangthai=0" ;
		
		
		try {
			pst=conn.prepareStatement(sql);		
			pst.execute();
			
			
			
			
			
	}
	catch(Exception e)
	{
		

		
	}
	}

}
