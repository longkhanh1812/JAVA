package pkg.quanlytaikhoan;
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
import Process.taikhoan;
import Process.thucdon;
import pkg.main.programlogin;
import pkg.main.programmain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class programqltaikhoan extends JFrame {

	private JPanel contentPane;
	private Connection connect = null;
	private JTable table;
	private JTable table_1;
	   private DefaultTableModel tableModel = new DefaultTableModel();
	   private JTable table_2;
	   private JTextField txttimkiem;
	   private JTextField txtmaid;
	   private JTextField txtusername;
	   private JTextField txtpassword;
	   private JTextField txtlv;
	   
	   public void MyJTable() throws ClassNotFoundException, SQLException{
			String []colsName = {"ID", "Username" , "Password","LV"};
			tableModel.setColumnIdentifiers(colsName);
			table_1.setModel(tableModel);
	         
	       
	          
	        updateData(); 
	    }
		public void updateData() throws ClassNotFoundException, SQLException{
			String []colsName = {"ID", "Username" , "Password","LV"};
			tableModel.setColumnIdentifiers(colsName);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url= "jdbc:sqlserver://BVCN88LTV:1433;databaseName=QLCF_BTL;user=sa;password=123456";
			Connection con= DriverManager.getConnection(url);
			String sql ="Select * from taikhoan";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
	        try {
	            while(rs.next()){ 
	                String rows[] = new String[4];
	                rows[0] = rs.getString(1); 
	                rows[1] = rs.getString(2);
	                rows[2]=rs.getString(3);
	                rows[3]=rs.getString(4);
	                tableModel.addRow(rows);
	                
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	    }
		
		
	public programqltaikhoan() throws IOException {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(209, 11, 482, 49);
		panel_1.add(lblNewLabel_2);
		JButton btnhome = new JButton("New button");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					dispose();
				
					programmain pgmain;
					try {
						pgmain = new programmain();
						pgmain.setVisible(true);
						pgmain.setLocationRelativeTo(null);
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
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {
				int row= table_1.getSelectedRow();
				String IDrow = table_1.getModel().getValueAt(row, 0).toString();
				String sql = "Select * FROM taikhoan WHERE id=" + IDrow + "";
				ResultSet rs =ud.showTextField(sql);
				if(rs.next())
				{
					
					txtmaid.setText(rs.getString("id"));
					txtusername.setText(rs.getString("username"));
					txtpassword.setText(rs.getString("password"));
					txtlv.setText(rs.getString("lv"));

				}
				
					
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, 0);
				
			}
			}
		});
		
		
		
		
	
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(786, 11, 348, 413);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		taikhoan td=new taikhoan();
		JButton btnthem = new JButton("New button");
		String sql5="select * from taikhoan order by id asc ";
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				td.insert(Integer.parseInt(txtmaid.getText().trim()), txtusername.getText(), txtpassword.getText(), Integer.parseInt(txtlv.getText()));
				ud.LoadData(sql5, table_1);
				txtmaid.setEnabled(false); 
				txtusername.setEnabled(false);
				txtpassword.setEnabled(false);
				txtlv.setEnabled(false);
				txtmaid.setText("");
				txtusername.setText("");
				txtpassword.setText("");
				txtlv.setText("");
			}
		});
		BufferedImage img3= ImageIO.read(new File("E:\\images\\iconthem.jpg"));
		ImageIcon icon3 = new ImageIcon(img3.getScaledInstance(130,40,img.SCALE_SMOOTH));
		btnthem.setIcon(icon3);
		btnthem.setBounds(10, 236, 80, 40);
		panel_6.add(btnthem);
		
		JLabel lblNewLabel_1 = new JLabel("Mã ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 24, 60, 24);
		panel_6.add(lblNewLabel_1);
		
		JLabel lblTnMn = new JLabel("Username");
		lblTnMn.setFont(new Font("Arial", Font.ITALIC, 14));
		lblTnMn.setBounds(10, 79, 80, 24);
		panel_6.add(lblTnMn);
		
		JLabel lblnGi = new JLabel("Password");
		lblnGi.setFont(new Font("Arial", Font.ITALIC, 14));
		lblnGi.setBounds(10, 131, 80, 24);
		panel_6.add(lblnGi);
		
		JLabel lblDvt = new JLabel("LV");
		lblDvt.setFont(new Font("Arial", Font.ITALIC, 14));
		lblDvt.setBounds(10, 184, 60, 24);
		panel_6.add(lblDvt);
		
		txtmaid = new JTextField();
		txtmaid.setEnabled(false);
		txtmaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaid.setBounds(90, 27, 227, 20);
		panel_6.add(txtmaid);
		txtmaid.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setEnabled(false);
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtusername.setColumns(10);
		txtusername.setBounds(90, 82, 227, 20);
		panel_6.add(txtusername);
		
		txtpassword = new JTextField();
		txtpassword.setEnabled(false);
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpassword.setColumns(10);
		txtpassword.setBounds(90, 134, 227, 20);
		panel_6.add(txtpassword);
		
		txtlv = new JTextField();
		txtlv.setEnabled(false);
		txtlv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtlv.setColumns(10);
		txtlv.setBounds(90, 187, 227, 20);
		panel_6.add(txtlv);
		
		JButton btnsua = new JButton("New button");
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				td.sua(Integer.parseInt(txtmaid.getText().trim()), txtusername.getText(), txtpassword.getText(), Integer.parseInt(txtlv.getText()));
				ud.LoadData(sql5, table_1);
				txtmaid.setEnabled(false); 
				txtusername.setEnabled(false);
				txtpassword.setEnabled(false);
				txtlv.setEnabled(false);
				txtmaid.setText("");
				txtusername.setText("");
				txtpassword.setText("");
				txtlv.setText("");
				
				
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
				td.delete(Integer.parseInt(txtmaid.getText().trim()));
				ud.LoadData(sql5, table_1);
				txtmaid.setEnabled(false); 
				txtusername.setEnabled(false);
				txtpassword.setEnabled(false);
				txtlv.setEnabled(false);
				txtmaid.setText("");
				txtusername.setText("");
				txtpassword.setText("");
				txtlv.setText("");
				
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
				
				txtmaid.setEnabled(true); 
				txtusername.setEnabled(true);
				txtpassword.setEnabled(true);
				txtlv.setEnabled(true);
				txtmaid.setText("");
				txtusername.setText("");
				txtpassword.setText("");
				txtlv.setText("");
			}
		});
		BufferedImage img7= ImageIO.read(new File("E:\\images\\icona.jpg"));
		ImageIcon icon7 = new ImageIcon(img7.getScaledInstance(100,144,img.SCALE_SMOOTH));
		btnok.setIcon(icon7);
		btnok.setBounds(135, 236, 80, 144);
		panel_6.add(btnok);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 37, 766, 387);
		panel_4.add(scrollPane);
		
		
		
		btnhome.setIcon(icon2);
		try
				{
					 
					String []colsName = {"ID", "Username" ,"Password","LV"};
					tableModel.setColumnIdentifiers(colsName);
					table_1.setModel(tableModel);
					 table_1.setBounds(10, 11, 553, 391);
					 scrollPane.add(table_1);
					 table_1.setDefaultEditor(Object.class, null); 

					 scrollPane.setViewportView(table_1);
					 
					 JLabel lblNewLabel = new JLabel("Tìm tên tài khoản<3");
					 lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
					 lblNewLabel.setBounds(85, 11, 145, 14);
					 panel_4.add(lblNewLabel);
					 
					 txttimkiem = new JTextField();
					 txttimkiem.setBounds(240, 6, 225, 20);
					 panel_4.add(txttimkiem);
					 txttimkiem.setColumns(10);
					 
					 JButton btntimkiem = new JButton("New button");
					 btntimkiem.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 		
					 		String sql3 = "SELECT * FROM dbo.taikhoan WHERE username LIKE '" + txttimkiem.getText() +"%'" ;
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
