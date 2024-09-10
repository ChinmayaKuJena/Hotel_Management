package com.in.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Customer_info  extends JFrame implements ActionListener{
	        //visible Rooms
	JTable jtable;
	JButton back;
	
	public Customer_info() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
//		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
//		Image i2=im1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//		ImageIcon i3=new ImageIcon(i2);
//		JLabel img=new JLabel(i3);
//		img.setBounds(500, 0, 600, 600);
//		add(img);
		
		jtable=new JTable();
		jtable.setBounds(0, 40, 1000, 450);
		add(jtable);
		
		JLabel j1=new JLabel("ID");
		j1.setBounds(5, 10, 100, 20);
		add(j1);
		
		JLabel j2=new JLabel("NUMBER");
		j2.setBounds(130, 10, 100, 20);
		add(j2);
		
		JLabel j3=new JLabel("NAME");
		j3.setBounds(260, 10, 100, 20);
		add(j3);
		
		JLabel j4=new JLabel("GENDER");
		j4.setBounds(380, 10, 100, 20);
		add(j4);
		
		JLabel j5=new JLabel("COUNTRY");
		j5.setBounds(500, 10, 100, 20);
		add(j5);
		
		JLabel j6=new JLabel("ROOM NUMBER");
		j6.setBounds(630, 10, 100, 20);
		add(j6);
		
		JLabel j7=new JLabel("CHECK IN");
		j7.setBounds(760, 10, 100, 20);
		add(j7);
		
		JLabel j8=new JLabel("DEPOSIT");
		j8.setBounds(880, 10, 100, 20);
		add(j8);
		
		back=new JButton("BACK");
		back.setBounds(420, 500, 120, 30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		try {
			
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from customer");
			jtable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setBounds(300, 200, 1000, 600);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Reception();
		
	}
	
	public static void main(String[] args) {
		new Customer_info ();
	}

	

}
