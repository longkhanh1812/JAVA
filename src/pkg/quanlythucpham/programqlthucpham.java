package pkg.quanlythucpham;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Process.Update;
import Process.nhommon;
import Process.thucdon;
import pkg.main.programlogin;
import pkg.main.programmain;
import pkg.main.programmainmember;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class programqlthucpham  extends JFrame{
	public static int flag1;
	private JPanel contentPane;
	private Connection connect = null;
	private JTable table;
	private JTable table_1;
	   private DefaultTableModel tableModel = new DefaultTableModel();
	   private JTable table_2;
	   private JTextField txttimkiem;
	   private JTextField txtmamon;
	   private JTextField txttenmon;
	   private JTextField txtdongia;
	   private JTextField txtdvt;
	   private JTextField txtmaloai;
	   
	   
	
	
	   public void MyJTable() throws ClassNotFoundException, SQLException{
			String []colsName = {"Mã món", "Tên món" , "Đơn giá","DVT","Mã Loại"};
			tableModel.setColumnIdentifiers(colsName);
			table_1.setModel(tableModel);
	         
	       
	          
	        updateData(); 
	    }
		public void updateData() throws ClassNotFoundException, SQLException{
			String []colsName = {"Mã món", "Tên món" , "Đơn giá","DVT","Mã Loại"};
			tableModel.setColumnIdentifiers(colsName);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url= "jdbc:sqlserver://BVCN88LTV:1433;databaseName=QLCF_BTL;user=sa;password=123456;useUnicode=true;characterEncoding=UTF-8";
			Connection con= DriverManager.getConnection(url);
			String sql ="Select * from thucdon";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
	        try {
	            while(rs.next()){ 
	                String rows[] = new String[5];
	                rows[0] = rs.getString(1); 
	                rows[1] = rs.getString(2);
	                rows[2]=rs.getString(3);
	                rows[3]=rs.getString(4);
	                rows[4]=rs.getString(5);
	                tableModel.addRow(rows);
	                
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	    }
		
		
	
	public programqlthucpham() throws IOException {
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		this.setSize(1200,600);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(102, 51, 0), 2));
		panel_1.setBounds(10, 11, 1164, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnhome = new JButton("New button");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					dispose();
					programmainmember pgmb;
					programmain pgmain;
					programlogin pglogin;
					try {
						pglogin=new programlogin();
						pgmain = new programmain();
						pgmb= new programmainmember();
						if(pglogin.quyenhan==1)
						{
						pgmain.setVisible(true);
						pgmain.setLocationRelativeTo(null);
						}
						else
						{
							pgmb.setVisible(true);
							pgmb.setLocationRelativeTo(null);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
			}
		});
		btnhome.setBounds(10, 11, 49, 49);
		panel_1.add(btnhome);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(10, 93, 1164, 457);
		panel.add(panel_2);
		panel_2.setLayout(null);
		BufferedImage img= ImageIO.read(new File("E:\\images\\icon5.png"));
		ImageIcon icon = new ImageIcon(img.getScaledInstance(30,25,img.SCALE_SMOOTH));
		BufferedImage img2= ImageIO.read(new File("E:\\images\\iconhome.png"));
		ImageIcon icon2 = new ImageIcon(img2.getScaledInstance(49,49,img.SCALE_SMOOTH));
		BufferedImage img1= ImageIO.read(new File("E:\\images\\icon6.png"));
		ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(30,25,img.SCALE_SMOOTH));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 1144, 435);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		Update ud= new Update();
		table_1 = new JTable();
		
		
		
		
		
	
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(786, 11, 348, 413);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		thucdon td=new thucdon();
		JButton btnthem = new JButton("New button");
		String sql5="select mamon AS 'Mã món',tenmon AS 'Tên món',dongia AS 'Đơn giá',DVT AS ' DVT' ,maloai AS 'Mã loại' from thucdon order by mamon asc ";
		String sql4 = "select maloai AS 'Mã Loại' ,tenloai AS 'Tên Loại' from nhommon order by maloai asc";
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				td.insert(Integer.parseInt(txtmamon.getText().trim()), txttenmon.getText(), Integer.parseInt(txtdongia.getText()), txtdvt.getText(),Integer.parseInt(txtmaloai.getText()));
				ud.LoadData(sql5, table_1);
				txtmamon.setEnabled(false); 
				txttenmon.setEnabled(false);
				txtdongia.setEnabled(false);
				txtdvt.setEnabled(false);
				txtmaloai.setEnabled(false);
				txtmamon.setText("");
				txttenmon.setText("");
				txtdongia.setText("");
				txtdvt.setText("");
				txtmaloai.setText("");
			}
		});
		BufferedImage img3= ImageIO.read(new File("E:\\images\\iconthem.jpg"));
		ImageIcon icon3 = new ImageIcon(img3.getScaledInstance(130,40,img.SCALE_SMOOTH));
		btnthem.setIcon(icon3);
		btnthem.setBounds(10, 236, 80, 40);
		panel_6.add(btnthem);
		
		JLabel lbl1 = new JLabel("Mã món");
		lbl1.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl1.setBounds(10, 24, 60, 24);
		panel_6.add(lbl1);
		
		JLabel lbl2 = new JLabel("Tên món");
		lbl2.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl2.setBounds(10, 59, 60, 24);
		panel_6.add(lbl2);
		
		JLabel lbl3 = new JLabel("Đơn giá");
		lbl3.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl3.setBounds(10, 100, 60, 24);
		panel_6.add(lbl3);
		
		JLabel lbl4 = new JLabel("DVT");
		lbl4.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl4.setBounds(10, 135, 60, 24);
		panel_6.add(lbl4);
		JLabel lbl5 = new JLabel("Mã loại");
		lbl5.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl5.setBounds(10, 168, 60, 24);
		panel_6.add(lbl5);
		
		txtmamon = new JTextField();
		txtmamon.setEnabled(false);
		txtmamon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmamon.setBounds(90, 27, 227, 20);
		panel_6.add(txtmamon);
		txtmamon.setColumns(10);
		
		txttenmon = new JTextField();
		txttenmon.setEnabled(false);
		txttenmon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttenmon.setColumns(10);
		txttenmon.setBounds(90, 60, 227, 20);
		panel_6.add(txttenmon);
		
		txtdongia = new JTextField();
		txtdongia.setEnabled(false);
		txtdongia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdongia.setColumns(10);
		txtdongia.setBounds(90, 101, 227, 20);
		panel_6.add(txtdongia);
		
		txtdvt = new JTextField();
		txtdvt.setEnabled(false);
		txtdvt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdvt.setColumns(10);
		txtdvt.setBounds(90, 136, 227, 20);
		panel_6.add(txtdvt);
		
		JButton btnsua = new JButton("New button");
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				td.sua(Integer.parseInt(txtmamon.getText().trim()), txttenmon.getText(), Integer.parseInt(txtdongia.getText()), txtdvt.getText(),Integer.parseInt(txtmaloai.getText()));
				ud.LoadData(sql5, table_1);
				txtmamon.setEnabled(false); 
				txttenmon.setEnabled(false);
				txtdongia.setEnabled(false);
				txtdvt.setEnabled(false);
				txtmaloai.setEnabled(false);
				txtmamon.setText("");
				txttenmon.setText("");
				txtdongia.setText("");
				txtdvt.setText("");
				txtmaloai.setText("");
				
				
			}
		});
		BufferedImage img4= ImageIO.read(new File("E:\\images\\iconsua1.jpg"));
		ImageIcon icon4 = new ImageIcon(img4.getScaledInstance(100,40,img.SCALE_SMOOTH));
		btnsua.setIcon(icon4);
		btnsua.setBounds(10, 287, 80, 40);
		panel_6.add(btnsua);
		
		JButton btnxoa = new JButton("New button");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				td.delete(Integer.parseInt(txtmamon.getText().trim()));
				ud.LoadData(sql5, table_1);
				txtmamon.setEnabled(false); 
				txttenmon.setEnabled(false);
				txtdongia.setEnabled(false);
				txtdvt.setEnabled(false);
				txtmaloai.setEnabled(false);
				txtmamon.setText("");
				txttenmon.setText("");
				txtdongia.setText("");
				txtdvt.setText("");
				txtmaloai.setText("");
				
			}
		});
		BufferedImage img5= ImageIO.read(new File("E:\\images\\iconxoa1.jpg"));
		ImageIcon icon5 = new ImageIcon(img5.getScaledInstance(100,40,img.SCALE_SMOOTH));
		btnxoa.setIcon(icon5);
		btnxoa.setBounds(10, 344, 80, 40);
		panel_6.add(btnxoa);
		
		JButton btnok = new JButton("New button");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtmamon.setEnabled(true); 
				txttenmon.setEnabled(true);
				txtdongia.setEnabled(true);
				txtdvt.setEnabled(true);
				txtmaloai.setEnabled(true);
				txtmamon.setText("");
				txttenmon.setText("");
				txtdongia.setText("");
				txtdvt.setText("");
				txtmaloai.setText("");
			}
		});
		BufferedImage img7= ImageIO.read(new File("E:\\images\\icona.jpg"));
		ImageIcon icon7 = new ImageIcon(img7.getScaledInstance(100,144,img.SCALE_SMOOTH));
		btnok.setIcon(icon7);
		btnok.setBounds(135, 236, 80, 144);
		panel_6.add(btnok);
		
		
		
		txtmaloai = new JTextField();
		txtmaloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaloai.setEnabled(false);
		txtmaloai.setColumns(10);
		txtmaloai.setBounds(90, 167, 227, 20);
		panel_6.add(txtmaloai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 37, 766, 387);
		panel_4.add(scrollPane);
		
		
		
		btnhome.setIcon(icon2); // NHOMMON
		JLabel lbl6 = new JLabel("Mã loại");
		lbl6.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl6.setBounds(10, 24, 60, 24);
		panel_6.add(lbl6);
		
		JLabel lbl7 = new JLabel("Tên loại");
		lbl7.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl7.setBounds(10, 59, 60, 24);
		panel_6.add(lbl7); //NHOMMON
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		
		JTextField txtmaloai1 = new JTextField();
		txtmaloai1.setEnabled(false);
		txtmaloai1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaloai1.setBounds(90, 27, 227, 20);
		panel_6.add(txtmaloai1);
		txtmaloai1.setColumns(10);
		
		JTextField txttenloai = new JTextField();
		txttenloai.setEnabled(false);
		txttenloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttenloai.setColumns(10);
		txttenloai.setBounds(90, 60, 227, 20);
		panel_6.add(txttenloai);
		txttenloai.setVisible(false);
		txtmaloai1.setVisible(false);
		//THEM,SUA,XOA,CLEAR TEXT
		
		
		JButton btnthem1 = new JButton("New button");
		nhommon nm = new nhommon();
		btnthem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nm.insert(Integer.parseInt(txtmaloai1.getText()), txttenloai.getText());
				ud.LoadData(sql4, table_1);
				txtmaloai1.setEnabled(false); 
				txttenloai.setEnabled(false);
				
				txtmaloai1.setText("");
				txttenloai.setText("");
				
			}
		});
		
		btnthem1.setIcon(icon3);
		btnthem1.setBounds(10, 236, 80, 40);
		panel_6.add(btnthem1);
		JButton btnsua1 = new JButton("New button");
		btnsua1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nm.sua(Integer.parseInt(txtmaloai1.getText()), txttenloai.getText());
				ud.LoadData(sql4, table_1);
				txtmaloai1.setEnabled(false); 
				txttenloai.setEnabled(false);
				
				txtmaloai1.setText("");
				txttenloai.setText("");
				
				
			}
		});
		
		btnsua1.setIcon(icon4);
		btnsua1.setBounds(10, 287, 80, 40);
		panel_6.add(btnsua1);
		
		JButton btnxoa1 = new JButton("New button");
		btnxoa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nm.delete(Integer.parseInt(txtmaloai1.getText()));
				ud.LoadData(sql4, table_1);
				txtmaloai1.setEnabled(false); 
				txttenloai.setEnabled(false);
				
				txtmaloai1.setText("");
				txttenloai.setText("");
				
			}
		});
		
		btnxoa1.setIcon(icon5);
		btnxoa1.setBounds(10, 344, 80, 40);
		panel_6.add(btnxoa1);
		
		JButton btnok1 = new JButton("New button");
		btnok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaloai1.setText("");
				txttenloai.setText("");
				txtmaloai1.setEnabled(true);
				txttenloai.setEnabled(true);
			}
		});
		
		btnok1.setIcon(icon7);
		btnok1.setBounds(135, 236, 80, 144);
		panel_6.add(btnok1);
		
		btnthem1.setVisible(false);
		btnsua1.setVisible(false);
		btnxoa1.setVisible(false);
		btnok1.setVisible(false);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {
				int row= table_1.getSelectedRow();
				String IDrow = table_1.getModel().getValueAt(row, 0).toString();
				String sql = "Select * FROM thucdon WHERE mamon=" + IDrow + "";
				String sqll= "Select * FROM nhommon WHERE maloai=" + IDrow + "";
				if(flag1==1)
				{
					ResultSet rs =ud.showTextField(sql);
				if(rs.next())
				{
					
					txtmamon.setText(rs.getString("mamon"));
					txttenmon.setText(rs.getString("tenmon"));
					txtdongia.setText(rs.getString("dongia"));
					txtdvt.setText(rs.getString("DVT"));
					txtmaloai.setText(rs.getString("maloai"));
				}}
				else
				{
					ResultSet rs =ud.showTextField(sqll);
					if(rs.next())
					{
						
						txtmaloai1.setText(rs.getString("maloai"));
						txttenloai.setText(rs.getString("tenloai"));
						
					}
				}
				
					
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, 0);
				
			}
			}
		});
		txttimkiem = new JTextField();
		 JButton btntimkiem = new JButton("New button");
		 JLabel lbltimmon = new JLabel("Tìm món <3");
		JButton btnthucdon = new JButton("");
		btnthucdon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag1=1;
				lbl1.setVisible(true);
				lbl2.setVisible(true);
				lbl3.setVisible(true);
				lbl4.setVisible(true);
				lbl5.setVisible(true);
				txtmamon.setVisible(true);
				txttenmon.setVisible(true);
				txtdongia.setVisible(true);
				txtdvt.setVisible(true);
				txtmaloai.setVisible(true);
				btnthem.setVisible(true);
				btnsua.setVisible(true);
				btnxoa.setVisible(true);
				btnok.setVisible(true);
				lbltimmon.setVisible(true);
				txttimkiem.setVisible(true);
				btntimkiem.setVisible(true);
				lbl6.setVisible(false);
				lbl7.setVisible(false);
				txtmaloai1.setVisible(false);
				txttenloai.setVisible(false);
				btnthem1.setVisible(false);
				btnsua1.setVisible(false);
				btnxoa1.setVisible(false);
				btnok1.setVisible(false);
				ud.LoadData(sql5, table_1);
			}
		});
		BufferedImage img8= ImageIO.read(new File("E:\\images\\iconqltd1.png"));
		ImageIcon icon8 = new ImageIcon(img8.getScaledInstance(235,30,img.SCALE_SMOOTH));
		btnthucdon.setIcon(icon8);
		btnthucdon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthucdon.setBounds(125, 11, 220, 30);
		panel_1.add(btnthucdon);
		
		JLabel lblNewLabel_2 = new JLabel("Quản lý thực đơn");
		lblNewLabel_2.setFont(new Font("Arial", Font.ITALIC, 22));
		lblNewLabel_2.setBounds(135, 46, 188, 25);
		panel_1.add(lblNewLabel_2);
		
		JButton btnnhommon = new JButton("");
		btnnhommon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag1=2;
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
				lbl5.setVisible(false);
				txtmamon.setVisible(false);
				txttenmon.setVisible(false);
				txtdongia.setVisible(false);
				txtdvt.setVisible(false);
				txtmaloai.setVisible(false);
				btnthem.setVisible(false);
				btnsua.setVisible(false);
				btnxoa.setVisible(false);
				btnok.setVisible(false);
				txttimkiem.setVisible(false);
				lbltimmon.setVisible(false);
				btntimkiem.setVisible(false);
				lbl6.setVisible(true);
				lbl7.setVisible(true);
				txtmaloai1.setVisible(true);
				txttenloai.setVisible(true);
				btnthem1.setVisible(true);
				btnsua1.setVisible(true);
				btnxoa1.setVisible(true);
				btnok1.setVisible(true);
				ud.LoadData(sql4, table_1);
			}
		});
		BufferedImage img9= ImageIO.read(new File("E:\\images\\qlnhommon.png"));
		ImageIcon icon9 = new ImageIcon(img9.getScaledInstance(235,30,img.SCALE_SMOOTH));
		btnnhommon.setIcon(icon9);
		btnnhommon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnnhommon.setBounds(373, 11, 220, 30);
		panel_1.add(btnnhommon);
		
		JLabel lblQunLNhm = new JLabel("Quản lý nhóm món");
		lblQunLNhm.setFont(new Font("Arial", Font.ITALIC, 22));
		lblQunLNhm.setBounds(394, 46, 188, 25);
		panel_1.add(lblQunLNhm);
		try
				{
					 
					String []colsName = {"Mã món", "Tên món" ,"Đơn giá","DVT","Mã Loại"};
					tableModel.setColumnIdentifiers(colsName);
					table_1.setModel(tableModel);
					 table_1.setBounds(10, 11, 553, 391);
					 scrollPane.add(table_1);
					 table_1.setDefaultEditor(Object.class, null); 

					 scrollPane.setViewportView(table_1);
					 
					
					 lbltimmon.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
					 lbltimmon.setBounds(141, 11, 89, 14);
					 panel_4.add(lbltimmon);
					 
					 
					 txttimkiem.setBounds(240, 6, 225, 20);
					 panel_4.add(txttimkiem);
					 txttimkiem.setColumns(10);
					 
				
					 btntimkiem.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 		
					 		String sql3 = "SELECT * FROM dbo.thucdon WHERE tenmon LIKE '" + txttimkiem.getText() +"%'" ;
					 		ud.LoadData(sql3, table_1);
					 		
					 	}
					 });
					 BufferedImage img6= ImageIO.read(new File("E:\\images\\icontim.png"));
						ImageIcon icon6 = new ImageIcon(img6.getScaledInstance(110,40,img.SCALE_SMOOTH));
					 btntimkiem.setIcon(icon6);
					 btntimkiem.setBounds(472, 1, 67, 36);
					 panel_4.add(btntimkiem);
					
					MyJTable();
					
					
					
					
					
					
				}
		catch(Exception e)
				{
					System.out.println("LOI");
				}
		
	
	}
	

}
