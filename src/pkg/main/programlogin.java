package pkg.main;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class programlogin extends JFrame {

	public static int quyenhan;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	programmain pgmain = new programmain();
	programmainmember pgmember = new programmainmember();
	public programlogin() throws IOException
	{
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\images\\meo.jpg"));
		this.setTitle("CAFE-1999");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 317);
		contentPane = 	new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblngNhpH = new JLabel("\u0110\u0102NG NH\u1EACP H\u1EC6 TH\u1ED0NG");
		lblngNhpH.setFont(new Font("Verdana", Font.BOLD, 18));
		lblngNhpH.setBounds(94, 11, 243, 25);
		panel.add(lblngNhpH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 69, 414, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		BufferedImage img= ImageIO.read(new File("E:\\\\images\\\\icon2.png"));
		ImageIcon icon = new ImageIcon(img.getScaledInstance(30,30,img.SCALE_SMOOTH));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(10, 11, 34, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblTnngNhp = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblTnngNhp.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTnngNhp.setBounds(41, 21, 119, 25);
		panel_1.add(lblTnngNhp);
		
		username = new JTextField();
		username.setFont(new Font("Verdana", Font.PLAIN, 14));
		username.setBounds(170, 20, 193, 25);
		panel_1.add(username);
		username.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 203, 414, 58);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
	
		JButton btnNewButton = new JButton("\u0110\u0102NG NH\u1EACP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url= "jdbc:sqlserver://BVCN88LTV:1433;databaseName=QLCF_BTL;user=sa;password=123456";
					Connection con= DriverManager.getConnection(url);
					String sql ="Select * from taikhoan where username=? and password=?";
					PreparedStatement pst= con.prepareStatement(sql);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
					ResultSet rs= pst.executeQuery();
					
					if(rs.next()==true)
					{
						if(rs.getInt("lv")==1)
						{
						quyenhan=1;
						dispose();
						pgmain.setVisible(true);
						
						}
						else
						{
							quyenhan=0;
							dispose();
							pgmember.setVisible(true);
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(pgmain, "Bạn đã nhập sai tài khoản hoặc mật khẩu,Vui lòng nhập lại!");
						username.setText("");
						password.setText("");
					}
					
				}
				catch(Exception e)
				{
					System.out.println("LOI");
				}
					
				
				
			}
		});
		btnNewButton.setBounds(10, 11, 140, 31);
		panel_3.add(btnNewButton);
		
		JButton btnThot = new JButton("THO\u00C1T");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				System.exit(0);
				
			}
		});
		btnThot.setBounds(228, 11, 140, 31);
		panel_3.add(btnThot);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 135, 414, 57);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("New label");
		BufferedImage img1= ImageIO.read(new File("E:\\\\images\\\\ps.png"));
		ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(30,30,img1.SCALE_SMOOTH));
		label.setIcon(icon1);
		label.setBounds(10, 18, 34, 35);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("M\u1EADt kh\u1EA9u");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		label_1.setBounds(41, 21, 119, 25);
		panel_2.add(label_1);
		
		password = new JPasswordField();
		password.setBounds(170, 23, 193, 25);
		panel_2.add(password);
		
	}

}
