package Process;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Data.Connect;

public class ban {

	private int maban;
	private String tenban;
	private int trangthai;
	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public static Connection conn = Connect.getConnect();

	
	public  ban(int maban,String tenban,int trangthai)
	{
		super();
		this.maban=maban;
		this.tenban=tenban;
		this.trangthai=trangthai;
	}
	
	public ban()
	{
		
	}
	public ArrayList<ban> tableList() throws SQLException
	{
		ArrayList<ban> bann= new ArrayList<ban>();
		 String sql ="select * from ban";
		 PreparedStatement pst= conn.prepareStatement(sql);
		 
		 rs=pst.executeQuery();
		 while(rs.next())
		 {
		 this.maban=rs.getInt("maban");
		 this.tenban=rs.getString("tenban");
		 this.trangthai=rs.getInt("trangthai");
		 ban b = new ban(this.maban,this.tenban,this.trangthai);
		 bann.add(b);
		 }
		
		return bann;
		
		
	}
	public int getMaban() {
		return maban;
	}

	public void setMaban(int maban) {
		this.maban = maban;
	}

	public String getTenban() {
		return tenban;
	}

	public void setTenban(String tenban) {
		this.tenban = tenban;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	 @Override
	    public String toString() {
	        return "Student@[maban=" + maban + ", tenban=" + tenban + ", trang thai ="+trangthai + "]";
	    }
	 
	 public static void suatrangthaiban(int maban,int trangthai)
		{
			String sql = "UPDATE ban SET trangthai= '"+trangthai +"' WHERE maban="+maban +"" ;
			
			try {
				pst=conn.prepareStatement(sql);
				
				pst.execute();
				
				
				
				
		}
		catch(Exception e)
		{
			

			
		}
		}
	 
	 
	 public static void insertcthoadon(int mahoadon,int mamon,Object soluongmuonadd)
		{
			String sql = "INSERT INTO chitiethd (mahoadon ,mamon,soluong) VALUES  ( ?,?,?)";
			
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, mahoadon);
				pst.setInt(2, mamon);
				pst.setObject(3, soluongmuonadd);
				pst.execute();
				
				
				
				
		}
		catch(Exception e)
		{
			

			
		}
		}
	 
	 public static void updateban(int maban,int trangthai)
		{
			String sql = "UPDATE ban SET trangthai="+trangthai+"WHERE maban ="+maban;
			
			try {
				pst=conn.prepareStatement(sql);
				pst.execute();
				
				
				
				
		}
		catch(Exception e)
		{
			

			
		}
		}
	
	
	
	
}

