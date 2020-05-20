package Process;
import net.proteanit.sql.DbUtils;
import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Data.Connect;

public class Update {

	
	
	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();
	
	public static ResultSet showTextField(String sql)
	{
		try {
				pst=conn.prepareStatement(sql);
				return pst.executeQuery();
				
		}
		catch(Exception e)
		{
			return null;
			
		}
	}
	public static void LoadData(String sql,JTable tb)
	{
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			tb.setModel(DbUtils.resultSetToTableModel(rs));
			
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e,"Thong bao loi",1);
		
	}
	}
	
	

}
