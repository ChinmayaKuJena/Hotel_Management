package com.in.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {
	
	JButton cancel;
	
	Dashboard()
	{
		setBounds(0, 0, 1550, 1000);
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img2.jpg"));
		Image i2=i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		
		JLabel text=new JLabel("THE TAJ GROUP OF HOTEL");
		text.setBounds(70, 40, 1000, 50);
		text.setFont(new Font("Tohoma",Font.PLAIN,46));
		text.setForeground(Color.white);
		image.add(text);
		
		//menubar
		JMenuBar menubr=new JMenuBar();
		menubr.setBounds(0, 0, 1550, 40);
		image.add(menubr);
		
		JMenu hotel=new JMenu("Hotel Management");
		hotel.setForeground(Color.BLUE);
		menubr.add(hotel);
		
		JMenuItem reception=new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		
		JMenu admin=new JMenu("Hotel Admin");
		admin.setForeground(Color.BLUE);
		menubr.add(admin);
		
		JMenuItem addemp=new JMenuItem("ADD EMPLOYEE");
		addemp.addActionListener(this);
		admin.add(addemp);
		
		JMenuItem addroom=new JMenuItem("ADD ROOM");
		addroom.addActionListener(this);
		admin.add(addroom);
		
		JMenuItem addriver=new JMenuItem("ADD DRIVER");
		addriver.addActionListener(this);
		admin.add(addriver);
		
		 cancel=new JButton("CANCEL");
		 cancel.setBounds(1400, 730, 90, 25);
		 cancel.setBackground(Color.BLACK);
		 cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("ADD EMPLOYEE"))
		{
			new addEmployee();
		}
		else if (ae.getActionCommand().equals("ADD ROOM")) {
			new addRoom();
		}
		else if (ae.getActionCommand().equals("ADD DRIVER")) {
			new addDriver();
		}
		else if (ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		
		if(ae.getSource()==cancel)
		{
			setVisible(false);
			System.exit(0);
		}

	}
	
	public static void main(String[] args) {
		new Dashboard();
		
	}

}
