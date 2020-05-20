package pkg.main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import pkg.quanlybanhang.programqlbanhang;
import pkg.quanlytaikhoan.programqltaikhoan;
import pkg.quanlythucpham.programqlthucpham;
import pkg.thongke.programqlthongke;

import javax.swing.border.EtchedBorder;

public class programmain extends JFrame {
	private JPanel contentPane;
	
	public programmain() throws IOException {
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\images\\010.png"));
		this.setTitle("Qu\u1EA3n L\u00FD");
		this.setAutoRequestFocus(false);
		this.setResizable(false);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(138, 43, 226));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		panel.setBounds(0, 0, 794, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAFE-1999");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(568, 46, 226, 66);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(new Color(204, 153, 51));
		lblNewLabel_1.setIcon(new ImageIcon("E:\\images\\cafe2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 794, 202);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		panel_1.setBounds(0, 202, 794, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setForeground(new Color(189, 183, 107));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 248, 220), new Color(255, 248, 220), new Color(255, 248, 220), new Color(255, 248, 220)));
		panel_2.setBounds(86, 49, 583, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnqltp = new JButton("");
		BufferedImage img= ImageIO.read(new File("E:\\images\\iconcafe.jpg"));
		ImageIcon icon = new ImageIcon(img.getScaledInstance(150,60,img.SCALE_SMOOTH));
		btnqltp.setIcon(icon);
		btnqltp.setBounds(10, 11, 124, 47);
		panel_2.add(btnqltp);
		btnqltp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				programqlthucpham pgqltp;
				try {
					pgqltp = new programqlthucpham();
					pgqltp.setVisible(true);
					pgqltp.setLocationRelativeTo(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		JButton btnqlnv = new JButton("");
		BufferedImage img1= ImageIO.read(new File("E:\\images\\iconqlnhanvien.png"));
		ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(116,47,img.SCALE_SMOOTH));
		btnqlnv.setIcon(icon1);
		btnqlnv.setBounds(154, 11, 116, 47);
		btnqlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					programqltaikhoan qltk= new programqltaikhoan();
					qltk.setVisible(true);
					qltk.setLocationRelativeTo(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel_2.add(btnqlnv);
		
		
		JButton btnbanhang = new JButton("");
		BufferedImage img2= ImageIO.read(new File("E:\\images\\iconbanhang.png"));
		ImageIcon icon2 = new ImageIcon(img2.getScaledInstance(79,47,img.SCALE_SMOOTH));
		btnbanhang.setIcon(icon2);
		btnbanhang.setBounds(290, 11, 79, 47);
		btnbanhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					programqlbanhang qlbh= new programqlbanhang();
					qlbh.setVisible(true);
					qlbh.setLocationRelativeTo(null);
				} catch (IOException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		panel_2.add(btnbanhang);
		
		JButton btnthongke = new JButton("");
		BufferedImage img3= ImageIO.read(new File("E:\\images\\iconthonge.jpg"));
		ImageIcon icon3 = new ImageIcon(img3.getScaledInstance(79,47,img.SCALE_SMOOTH));
		btnthongke.setIcon(icon3);
		btnthongke.setBounds(388, 11, 79, 47);
		panel_2.add(btnthongke);
		btnthongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					programqlthongke qltk= new programqlthongke();
					qltk.setVisible(true);
					qltk.setLocationRelativeTo(null);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Qu\u1EA3n l\u00FD th\u1EF1c ph\u1EA9m");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 58, 124, 22);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblQunLNhn = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblQunLNhn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQunLNhn.setBounds(154, 58, 116, 22);
		panel_2.add(lblQunLNhn);
		
		JLabel lblBnHng = new JLabel("B\u00E1n h\u00E0ng");
		lblBnHng.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBnHng.setBounds(300, 58, 63, 22);
		panel_2.add(lblBnHng);
		
		JLabel lblThngK = new JLabel("Th\u1ED1ng k\u00EA");
		lblThngK.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThngK.setBounds(398, 58, 63, 22);
		panel_2.add(lblThngK);
		
		JButton btnthongtin = new JButton("");
		BufferedImage img4= ImageIO.read(new File("E:\\images\\iconthongtin.jpg"));
		ImageIcon icon4 = new ImageIcon(img4.getScaledInstance(79,47,img.SCALE_SMOOTH));
		btnthongtin.setIcon(icon4);
		btnthongtin.setBounds(485, 11, 79, 47);
		panel_2.add(btnthongtin);
		btnthongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Nguyễn Huy Long-CT2C , Nguyễn Văn Hiển-CT2C , Nguyễn Thị Huế-CT2C", "Thông tin",1);
				
				
			}
		});
		
		JLabel lblThngTin = new JLabel("Th\u00F4ng tin");
		lblThngTin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThngTin.setBounds(495, 58, 63, 22);
		panel_2.add(lblThngTin);
		
		JButton btndangxuat = new JButton("");
		btndangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					programlogin pglogin= new programlogin();
					pglogin.setVisible(true);
					pglogin.setLocationRelativeTo(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		BufferedImage img5= ImageIO.read(new File("E:\\images\\icondx.jpg"));
		ImageIcon icon5 = new ImageIcon(img5.getScaledInstance(116,47,img.SCALE_SMOOTH));
		btndangxuat.setIcon(icon5);
		btndangxuat.setBounds(154, 91, 116, 47);
		panel_2.add(btndangxuat);
		
		JLabel lblngXut = new JLabel("\u0110\u0103ng xu\u1EA5t");
		lblngXut.setFont(new Font("Arial", Font.PLAIN, 14));
		lblngXut.setBounds(175, 141, 79, 22);
		panel_2.add(lblngXut);
		
		JButton btnthoat = new JButton("");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		BufferedImage img6= ImageIO.read(new File("E:\\images\\iconthoat.png"));
		ImageIcon icon6 = new ImageIcon(img6.getScaledInstance(79,47,img.SCALE_SMOOTH));
		btnthoat.setIcon(icon6);
		btnthoat.setBounds(290, 91, 79, 47);
		panel_2.add(btnthoat);
		
		JLabel lblThot = new JLabel("Tho\u00E1t");
		lblThot.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThot.setBounds(316, 141, 37, 22);
		panel_2.add(lblThot);
		
		JLabel lblQtvlkhanh = new JLabel("QTV:lkhanh99");
		lblQtvlkhanh.setBounds(573, 28, 96, 22);
		panel_1.add(lblQtvlkhanh);
		lblQtvlkhanh.setForeground(new Color(255, 0, 0));
		lblQtvlkhanh.setFont(new Font("Arial", Font.PLAIN, 14));
	
		
	}

}
