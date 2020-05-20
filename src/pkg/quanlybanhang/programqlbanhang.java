package pkg.quanlybanhang;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;

import Data.Connect;
import Process.Update;
import Process.ban;
import Process.banhang;
import pkg.main.programlogin;
import pkg.main.programmain;
import pkg.main.programmainmember;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
public class programqlbanhang extends JFrame {
	
	public static Connection conn = Connect.getConnect();

	private JPanel contentPane;
	private JTextField txttongtien;
	private DefaultTableModel tableModel = new DefaultTableModel();
	JComboBox cbbnhommon;
	JComboBox cbbtenmon;
	private JTable table;
	public int rowscount;
	public static int sum;
	JScrollPane scrollPane;
	public String trangthai;
	String tenmonmuonadd;
	Object soluongmuonadd;
	public static PreparedStatement pst=null;
	public static ResultSet rs = null;
	public  int indexo;
	public int mb;
	private JTextField txttrangthai;
	public int luu;
	public JButton btnban = null ;
	JButton btndatban ;
	public int mhd;
	public int mm;
	
	public void loadDataCB(JComboBox cbb)
	{
			String sql="SELECT * FROM nhommon";
			
			
		try
		{
			PreparedStatement pst=conn.prepareStatement(sql);
		 ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				cbb.addItem(rs.getString("tenloai"));
			}
			
		}catch(Exception e)
		{
			
		}
	}
	
	public programqlbanhang() throws SQLException, IOException {
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setResizable(false);
		Update ud = new Update();
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(0, 153, 51));
		btnNewButton.setBackground(SystemColor.desktop);
		getContentPane().add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1164, 70);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(panel);
		panel.setLayout(null);
		BufferedImage img1= ImageIO.read(new File("E:\\images\\iconhome.png"));
		ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(47,48,img1.SCALE_SMOOTH));
		JButton btnhome = new JButton("New button");
		btnhome.setIcon(icon1);
		btnhome.setBackground(new Color(204, 204, 204));
		
				
				btnhome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
							dispose();
							
							programmain pgmain;
							try {
								programlogin pglogin=new programlogin();
								programmainmember pgmember=new programmainmember();
								if(pglogin.quyenhan==1)
								{
								pgmain = new programmain();
								pgmain.setVisible(true);
								pgmain.setLocationRelativeTo(null);
								}
								else
								{
									pgmember.setVisible(true);
									pgmember.setLocationRelativeTo(null);
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
					}
				});
			
		btnhome.setBounds(10, 11, 47, 48);
		panel.add(btnhome);
		
		txttrangthai = new JTextField();
		txttrangthai.setEditable(false);
		txttrangthai.setFont(new Font("Arial", Font.BOLD, 14));
		txttrangthai.setBounds(578, 32, 169, 27);
		panel.add(txttrangthai);
		txttrangthai.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 92, 1164, 458);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panelban = new JPanel();
		panelban.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panelban.setBounds(0, 0, 560, 458);
		panelban.getAutoscrolls();
		panel_1.add(panelban);
		panelban.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
		BufferedImage img= ImageIO.read(new File("E:\\images\\banan.png"));
		ImageIcon icon = new ImageIcon(img.getScaledInstance(45,45,img.SCALE_SMOOTH));
		
		
		
		
		
		ban b= new ban();
		b.tableList();
		for(ban e : b.tableList())
		{
			btnban = new JButton();
			if((e.getMaban()+1)<10)
			{
				btnban.setText("Bàn " + Integer.toString(e.getMaban()+1) + "  ") ;
			}
			else
			{
				btnban.setText("Bàn " + Integer.toString(e.getMaban()+1)) ;
			}
			
			btnban.setIcon(icon);
			btnban.setFont(new Font("Arial", Font.BOLD, 15));
			 indexo= e.getMaban();
			String sql2="SELECT td.tenmon AS 'Tên món',td.dongia AS 'Đơn giá',cthd.soluong AS 'Số lượng','Thành tiền' =cthd.soluong*td.dongia FROM dbo.chitiethd AS cthd,dbo.hoadon AS hd,dbo.thucdon AS td WHERE cthd.mahoadon = hd.mahoadon AND cthd.mamon=td.mamon AND hd.maban="+indexo+" AND trangthai=1";
			
			btnban.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					ResultSet rs =ud.showTextField(sql2);	
					mb=e.getMaban();
					sum=0;
					ud.LoadData(sql2, table);
					
					rowscount=table.getRowCount();
					
					luu=e.getTrangthai();
					if(e.getTrangthai()==0)
					{
						txttrangthai.setText("Trống");
					}
					else
					{
						txttrangthai.setText("Đã có người đặt/ngồi");
					}
					 for(int i=0;i<rowscount;i++)
					 {
						 sum= sum+ Integer.parseInt(table.getValueAt(i, 3).toString());
					 }
					txttongtien.setText(String.valueOf(sum));
					
				}
				});
			
			switch(e.getTrangthai())
			{
			case 0 :
					
				    btnban.setBackground(Color.WHITE);
					break;
			case 1 :	
					
					btnban.setBackground(Color.GRAY);				
					break;
			}
			
			panelban.add(btnban);		
		}
		
		  
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_3.setBounds(570, 0, 594, 458);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		JComboBox cbbtenmon = new JComboBox();
		cbbtenmon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbtenmon.setBounds(10, 53, 171, 31);
		panel_3.add(cbbtenmon);
		JComboBox cbbnhommon = new JComboBox();
		cbbnhommon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				 JComboBox comboBox = (JComboBox) event.getSource();
				 Object selected = comboBox.getSelectedItem();
				 String sql1="SELECT td.tenmon FROM dbo.thucdon td , dbo.nhommon nm WHERE td.maloai=nm.maloai AND nm.tenloai = N'" +selected +"'"; 
				 try
					{
					 int itemCount = cbbtenmon.getItemCount();

					    for(int i=0;i<itemCount;i++){
					        cbbtenmon.removeItemAt(0);
					     }
					PreparedStatement pst=conn.prepareStatement(sql1);
					 ResultSet rs = pst.executeQuery();
					
					 
						while(rs.next())
						{
							cbbtenmon.addItem(rs.getString("tenmon"));
						}
						
					}catch(Exception e)
					{
						
					}
	                
				
			}
		});
		
		cbbnhommon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbnhommon.setBounds(10, 11, 171, 31);
		
		loadDataCB(cbbnhommon);
		panel_3.add(cbbnhommon);
		
		
		
		JSpinner spinnersoluong = new JSpinner();
		spinnersoluong.setFont(new Font("Arial", Font.PLAIN, 14));
		spinnersoluong.setBounds(203, 64, 105, 20);
		panel_3.add(spinnersoluong);
		
		JButton btnThmMn = new JButton("Thêm món");
		btnThmMn.setBackground(new Color(204, 204, 204));
		
		btnThmMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				banhang bh=new banhang();
				tenmonmuonadd=cbbtenmon.getSelectedItem().toString();
				soluongmuonadd= spinnersoluong.getValue();
				
				
				if(luu==1)
				{	
					String sql1 = "SELECT * FROM dbo.hoadon WHERE hoadon.maban ="+mb +"" ;	
					ResultSet rs1 =ud.showTextField(sql1);
					String sql= "SELECT mamon FROM thucdon  WHERE tenmon=N'"+tenmonmuonadd+"'";
					ResultSet rs=ud.showTextField(sql);
					try {
						while(rs.next())
						{
							mm= rs.getInt("mamon");			
						}
						while(rs1.next())
						{
							mhd=rs1.getInt("mahoadon");

						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					if((int)soluongmuonadd<=0)
					{
						JOptionPane.showMessageDialog(null, "Số lượng phải >0", "Thông báo",1);
					}
					else
					{
					b.insertcthoadon(mhd, mm, soluongmuonadd);
					JOptionPane.showMessageDialog(null, "Đã thêm", "Thong bao",1);
					String sql2="SELECT td.tenmon AS 'Tên món',td.dongia AS 'Đơn giá',cthd.soluong AS 'Số lượng','Thành tiền' =cthd.soluong*td.dongia FROM dbo.chitiethd AS cthd,dbo.hoadon AS hd,dbo.thucdon AS td WHERE cthd.mahoadon = hd.mahoadon AND cthd.mamon=td.mamon AND hd.maban="+mb+" AND trangthai=1";
					ud.LoadData(sql2, table);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Chưa có người đặt bàn", "Thông báo",1);
				}
			}
		});
		btnThmMn.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThmMn.setBounds(344, 11, 105, 73);
		panel_3.add(btnThmMn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(459, 11, 125, 436);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		JButton btninfile = new JButton("IN HÓA ĐƠN");
		btninfile.setBackground(new Color(204, 204, 204));
		JButton btnThanhTon = new JButton("Thanh toán");
		btnThanhTon.setBackground(new Color(204, 204, 204));
		btnThanhTon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(luu==1)
				{
				banhang.updatehoadon(mb,0);
				b.updateban(mb, 0);
				JOptionPane.showMessageDialog(null, "Đã thanh toán thành công", "Thông báo",1);
				String sql2="SELECT td.tenmon AS 'Tên món',td.dongia AS 'Đơn giá',cthd.soluong AS 'Số lượng','Thành tiền' =cthd.soluong*td.dongia FROM dbo.chitiethd AS cthd,dbo.hoadon AS hd,dbo.thucdon AS td WHERE cthd.mahoadon = hd.mahoadon AND cthd.mamon=td.mamon AND hd.maban="+mb+" AND trangthai=1";
				ud.LoadData(sql2, table);
				dispose();
				programmain pgmain;
				try {
					programlogin pglogin=new programlogin();
					programmainmember pgmember=new programmainmember();
					if(pglogin.quyenhan==1)
					{
					pgmain = new programmain();
					pgmain.setVisible(true);
					pgmain.setLocationRelativeTo(null);
					}
					else
					{
						pgmember.setVisible(true);
						pgmember.setLocationRelativeTo(null);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bàn này đã có ai đặt đâu ????", "Thông báo",1);
				}
				
				
			}
		});
		btnThanhTon.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThanhTon.setBounds(10, 160, 105, 73);
		panel_2.add(btnThanhTon);
		btninfile.setFont(new Font("Arial", Font.PLAIN, 12));
		btninfile.setBounds(10, 260, 105, 73);
		panel_2.add(btninfile);
		btninfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					FileOutputStream f = new FileOutputStream("E:\\hoadon.dat");
					ObjectOutputStream oOT = new ObjectOutputStream(f);
					oOT.writeChars("Xin chào quý khách");
					
					oOT.writeChars("\n");
					oOT.writeChars("\nBàn số :");
					oOT.writeInt(mb+1);
					oOT.writeChars("\n");
					for(int i=0;i<table.getRowCount();i++)
					{
						for(int j=0;j<table.getColumnCount();j++){
							
							oOT.writeObject((table.getValueAt(i, j)));
							 
						}
						oOT.writeChars("\n");
					}
					JOptionPane.showMessageDialog(null, "Bạn đã in thành công hóa đơn", "Thông báo",1);
					oOT.close();
					f.close();
					
				} catch (FileNotFoundException e) {
					 System.out.println("Có lỗi xảy ra!");
					e.printStackTrace();
				} catch (IOException e) {
					 System.out.println("Có lỗi xảy ra!");
					e.printStackTrace();
				}
					
			}
		});
		JLabel lblTngTin = new JLabel("Tổng Tiền");
		lblTngTin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTngTin.setBounds(30, 339, 73, 20);
		panel_2.add(lblTngTin);
		
		txttongtien = new JTextField();
		txttongtien.setBackground(new Color(102, 51, 51));
		txttongtien.setHorizontalAlignment(SwingConstants.CENTER);
		txttongtien.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		txttongtien.setEnabled(false);
		txttongtien.setBounds(10, 370, 105, 42);
		panel_2.add(txttongtien);
		txttongtien.setColumns(10);
		
		btndatban = new JButton("Đặt bàn");
		btndatban.setBackground(new Color(204, 204, 204));
		btndatban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				banhang bh=new banhang();
				tenmonmuonadd=cbbtenmon.getSelectedItem().toString();
				soluongmuonadd= spinnersoluong.getValue();
				
				
				if(luu==0)
				{	
					bh.inserthoadonmoi(mb, 1);
					b.suatrangthaiban(mb,1);
					JOptionPane.showMessageDialog(null, "Đặt bàn thành công", "Thông báo",1);
					dispose();
					programmain pgmain;
					try {
						programlogin pglogin=new programlogin();
						programmainmember pgmember=new programmainmember();
						if(pglogin.quyenhan==1)
						{
						pgmain = new programmain();
						pgmain.setVisible(true);
						pgmain.setLocationRelativeTo(null);
						}
						else
						{
							pgmember.setVisible(true);
							pgmember.setLocationRelativeTo(null);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bàn này đã có người đặt", "Thông báo",1);
				}
			}
		});
		btndatban.setFont(new Font("Arial", Font.PLAIN, 12));
		btndatban.setBounds(10, 0, 105, 73);
		panel_2.add(btndatban);
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSLng.setBounds(223, 33, 85, 20);
		panel_3.add(lblSLng);
		
		 scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 95, 439, 352);
		panel_3.add(scrollPane);
		
		table = new JTable();
		String []colsName = {"Tên món", "Đơn Giá","Giá","Thành tiền" };
		
		
		tableModel.setColumnIdentifiers(colsName);
		table.setModel(tableModel);
		
		scrollPane.setViewportView(table);
		
	}

}
