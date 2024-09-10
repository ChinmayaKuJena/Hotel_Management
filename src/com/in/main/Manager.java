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

public class Manager  extends JFrame implements ActionListener{
	        //visible Rooms
	JTable jtable;
	JButton back;
	
	public Manager() {
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
		
		JLabel j1=new JLabel("NAME");
		j1.setBounds(5, 10, 100, 20);
		add(j1);
		
		JLabel j2=new JLabel("AGE");
		j2.setBounds(150, 10, 100, 20);
		add(j2);
		
		JLabel j3=new JLabel("GENDER");
		j3.setBounds(290, 10, 100, 20);
		add(j3);
		
		JLabel j4=new JLabel("JOB");
		j4.setBounds(450, 10, 100, 20);
		add(j4);
		
		JLabel j5=new JLabel("PHONE");
		j5.setBounds(570, 10, 100, 20);
		add(j5);
		
		JLabel j6=new JLabel("SALARY");
		j6.setBounds(720, 10, 100, 20);
		add(j6);
		
		JLabel j7=new JLabel("EMAIL");
		j7.setBounds(880, 10, 100, 20);
		add(j7);
		
		back=new JButton("BACK");
		back.setBounds(420, 500, 120, 30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		try {
			
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from employee where job='manager'");
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
		new Manager ();
	}

	

}
