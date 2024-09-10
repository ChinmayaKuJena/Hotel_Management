package com.in.main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Check_Out_info extends JFrame implements ActionListener{
	
	Choice ccustomer;
	JLabel jlroomnum,Jlcheckin,Jlcheckout;
	JButton JbcheckOut,Jbback;
	
	Check_Out_info() {
		// TODO Auto-generated constructor stub
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text=new JLabel("CHECK OUT");
		text.setBounds(100, 20, 150, 30);
		text.setFont(new Font("Tohoma",Font.PLAIN,20));
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel jlid=new JLabel("CUSTOMER ID");
		jlid.setBounds(30, 80, 100, 30);
		//jlid.setFont(new Font("Tohoma",Font.PLAIN,20));
		//jlid.setForeground(Color.BLUE);
		add(jlid);
		
		ccustomer=new Choice();
		ccustomer.setBounds(140, 85, 150, 25);
		add(ccustomer);
	
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("tick.png"));
		Image im2=im1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(310, 85, 20, 20);
		add(image);
		
		JLabel jlroom=new JLabel("ROOM NUMBER");
		jlroom.setBounds(30, 120, 100, 30);
		add(jlroom);
		
		 jlroomnum=new JLabel();
		jlroomnum.setBounds(200, 120, 100, 30);
		add(jlroomnum);
		
		JLabel jlcheckin=new JLabel("CHECK IN");
		jlcheckin.setBounds(30, 160, 100, 30);
		add(jlcheckin);
		
		Jlcheckin=new JLabel();
		Jlcheckin.setBounds(150, 160, 200, 30);
		add(Jlcheckin);
		
		
		JLabel jlcheckout=new JLabel("CHECK OUT");
		jlcheckout.setBounds(30, 200, 100, 30);
		add(jlcheckout);
		
		Date date=new Date();
		Jlcheckout=new JLabel(""+date);
		Jlcheckout.setBounds(150, 200, 200, 30);
		add(Jlcheckout);
		
		JbcheckOut=new JButton("Check Out");
		JbcheckOut.setBounds(30, 280, 100, 30);
		JbcheckOut.addActionListener(this);
		JbcheckOut.setBackground(Color.BLACK);
		JbcheckOut.setForeground(Color.WHITE);
		add(JbcheckOut);
		
		Jbback=new JButton("Back");
		Jbback.setBounds(150, 280, 100, 30);
		Jbback.setBackground(Color.black);
		Jbback.setForeground(Color.WHITE);
		Jbback.addActionListener(this);
		add(Jbback);
		
		
		try {
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from customer");
					
			while(rs.next())
			{
				ccustomer.add(rs.getString("cnumber"));
				jlroomnum.setText(rs.getString("room"));
				Jlcheckin.setText(rs.getString("checkintime"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("six.jpg"));
		Image img2=img1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image4=new JLabel(img3);
		image4.setBounds(350, 60, 400, 250);
		add(image4);
	
		
		//setSize(600, 600);
		setBounds(300, 200, 800, 400);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==JbcheckOut) {
			String query="delete from customer where cnumber='"+ccustomer.getSelectedItem()+"'";
			String query2="update room set available='Available' where roomnumber='"+jlroomnum.getText()+"'";
			
			try {
				JdBcCoNnEcTiOn jd1=new JdBcCoNnEcTiOn();
				jd1.st.executeUpdate(query);
				jd1.st.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"CHECK OUT DONE");
				setVisible(false);
				new Reception();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Reception();
		}
		
	}
	
	public static void main(String[] args) {
		new Check_Out_info();
	}



}
