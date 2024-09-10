package com.in.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class login extends JFrame implements ActionListener {
	
	JTextField usn, psw;
	JButton cancel,login;
	
	public login() {
		// TODO Auto-generated constructor stub
		 setLayout(null);
		 
		JLabel user=new JLabel("USER NAME");
		user.setBounds(40, 20, 100, 30);
		add(user);
		usn=new JTextField();
		usn.setBounds(150, 23, 150, 30);
		add(usn);
		
		JLabel password=new JLabel("PASSWORD");
		password.setBounds(40, 70, 100, 30);
		add(password);
		psw=new JTextField();
		psw.setBounds(150, 70, 150, 30);
		add(psw);
		
		//cancel bottom
		 cancel=new JButton("CANCEL");
		cancel.setBounds(230, 160, 90, 20);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
	    cancel.addActionListener(this);
     	add(cancel);
     	
		//login bottom
		 login=new JButton("LOGIN");
	    login.setBounds(110, 160, 90, 20);
	    login.setBackground(Color.BLACK);
	    login.setForeground(Color.WHITE);
	    login.addActionListener(this);
		add(login);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("log.jpg"));
		Image i2=im.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel imag=new JLabel(i3);
		imag.setBounds(350, 10, 200, 200);
		add(imag);
		
		
		setBounds(500, 200, 600, 300);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			String user = usn.getText();
			String pass= psw.getText();
			
			try {
				JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
				
				String query="select * from login where username='"+user+"' and password='"+pass+"'";
				ResultSet rs=jd.st.executeQuery(query);
				
				if(rs.next())
				{
					setVisible(false);
					new Dashboard();
				}else {
					JOptionPane.showMessageDialog(null, "Invalid user & password");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ae.getSource()==cancel) {
			setVisible(false);
			
			
		}
	}
	public static void main(String[] args) {
		new login();
	}

}
