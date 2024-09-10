package com.in.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class main extends JFrame implements ActionListener{
	
	public main() {
		// TODO Auto-generated constructor stub
		
		setSize(1366, 600);
		setLocation(100, 100);
		
		//image icons
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("hotel.jpg"));
		Image i1 = im.getImage().getScaledInstance(1350, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i1);
		//jl.setBounds(100, 50, 10, 100);
		JLabel image1 = new JLabel(i3);
		add(image1);
		
		//text icon
		JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(300, 30, 1000, 90);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.BOLD,50));
		image1.add(text);
		
		//text bottom
		JButton next=new JButton("NEXT");
		next.setBounds(1150, 490, 100, 40);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBackground(Color.BLACK);
		next.addActionListener(this);
		next.setFont(new Font("serif",Font.PLAIN,20));
		image1.add(next);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		//text visible off/on
		while(true)
		{
			text.setForeground(Color.BLUE);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			text.setForeground(Color.RED);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			text.setForeground(Color.YELLOW);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			text.setForeground(Color.MAGENTA);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new login();
	}
	
	public static void main(String[] args) {
		new main();
	}

	
	

}
