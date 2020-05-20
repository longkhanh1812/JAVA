package pkg.thongke;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Process.Update;
import pkg.main.programmain;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class programqlthongke extends JFrame{
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JPanel contentPane;
	private JTextField txtongtien;
	private JTable table;
	public static int sum;
	public programqlthongke() throws IOException {
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,600);
		this.getContentPane().setLayout(null);
		JTextField txttimkiemban = new JTextField();
		 txttimkiemban.setBounds(100, 6, 225, 30);
		 JTextField txttimkiemtenmon = new JTextField();
		 txttimkiemtenmon.setBounds(100, 40, 225, 30);
		 JButton btnban = new JButton("TK BÀN");
		 btnban.setBackground(new Color(204, 204, 204));
		 btnban.setFont(new Font("Arial", Font.PLAIN, 12));
		 btnban.setBounds(360, 6, 225, 30);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(102, 51, 0), 2));
		panel.setBounds(10, 11, 1164, 71);
		this.getContentPane().add(panel);
		Update ud= new Update();
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
	
		BufferedImage img1= ImageIO.read(new File("E:\\images\\iconhome.png"));
		ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(47,48,img1.SCALE_SMOOTH));
		button.setIcon(icon1);
		button.setBounds(10, 11, 49, 49);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(102, 51, 51), 2));
		panel_1.setBounds(10, 94, 1164, 456);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 865, 434);
		panel_1.add(scrollPane);
		
		table = new JTable();
		
		String []colsName = {"Mã CTHĐ","Bàn" ,"Tên món","Số lượng","Thành tiền" };
		tableModel.setColumnIdentifiers(colsName);
		
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(885, 11, 269, 434);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Tổng Tiền");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(100, 21, 105, 20);
		panel_2.add(label);
		
		txtongtien = new JTextField();
		txtongtien.setHorizontalAlignment(SwingConstants.CENTER);
		txtongtien.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		txtongtien.setEnabled(false);
		txtongtien.setColumns(10);
		txtongtien.setBackground(new Color(102, 51, 51));
		txtongtien.setBounds(61, 40, 159, 42);
		panel_2.add(txtongtien);
		contentPane = new JPanel();
		String sql = "SELECT cthd.machitiethd AS 'Mã CTHĐ',hd.maban+1 AS 'Bàn',td.tenmon AS 'Tên món',cthd.soluong AS 'Số lượng', 'Thành Tiền' =cthd.soluong*td.dongia FROM dbo.chitiethd AS cthd,dbo.hoadon AS hd,thucdon AS td WHERE cthd.mamon=td.mamon AND hd.mahoadon=cthd.mahoadon AND hd.trangthai=0" ;
		ud.LoadData(sql, table);
		int rowscount = table.getRowCount();
		for(int i=0;i<rowscount;i++)
		 {
			 sum= sum+ Integer.parseInt(table.getValueAt(i, 4).toString());
		 }
		txtongtien.setText(String.valueOf(sum));
		
	}

}
