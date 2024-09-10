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

public class Department  extends JFrame implements ActionListener{
	        //visible Rooms
	JTable jtable;
	JButton back;
	
	public Department() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("staf.jpg"));
		Image i2=im1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(450, 39, 570, 350);
		add(img);
		
		
		jtable=new JTable();
		jtable.setBounds(0, 40, 480, 350);
		add(jtable);
		
		JLabel j1=new JLabel("DEPARTMENT");
		j1.setBounds(5, 10, 100, 20);
		add(j1);
		
		JLabel j2=new JLabel("BUDGET");
		j2.setBounds(250, 10, 100, 20);
		add(j2);
		
		back=new JButton("BACK");
		back.setBounds(410, 500, 120, 30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		try {
			
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from department");
			jtable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setBounds(300, 200, 1050, 600);
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
		new Department();
	}

	

}
