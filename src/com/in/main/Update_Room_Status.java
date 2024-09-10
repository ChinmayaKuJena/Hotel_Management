package com.in.main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update_Room_Status extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField JtroomNumber,Jtstatus,Jtavailable;
	
	JButton check,update,back;
	
	
	public Update_Room_Status() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text=new JLabel("UPDATE ROOM STATUS");
		text.setFont(new Font("Tohama",Font.PLAIN,20));
		text.setBounds(30, 20, 250, 30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel jlid=new JLabel("CUSTOMER ID");
		jlid.setFont(new Font("Tohama",Font.PLAIN,18));
		jlid.setBounds(50, 80, 150, 30);
		add(jlid);
		
		ccustomer=new Choice();
		ccustomer.setBounds(230, 85, 150, 25);
		add(ccustomer);
		
		try {
			
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from customer");
			
			while(rs.next())
			{
			ccustomer.add(rs.getString("cnumber"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		JLabel jlrnum=new JLabel("ROOM NUMBER");
		jlrnum.setFont(new Font("Tohama",Font.PLAIN,18));
		jlrnum.setBounds(50, 120, 150, 30);
		add(jlrnum);
		JtroomNumber=new JTextField();
		JtroomNumber.setBounds(230, 120, 150, 30);
		add(JtroomNumber);
		
		JLabel jlavailable=new JLabel("AVAILABILITY");
		jlavailable.setFont(new Font("Tohama",Font.PLAIN,18));
		jlavailable.setBounds(50, 160, 150, 30);
		add(jlavailable);
		Jtavailable=new JTextField();
		Jtavailable.setBounds(230, 160, 150, 30);
		add(Jtavailable);
		
		JLabel jlstatus=new JLabel("CLEAN STATUS");
		jlstatus.setFont(new Font("Tohama",Font.PLAIN,18));
		jlstatus.setBounds(50, 200, 150, 30);
		add(jlstatus);
		Jtstatus=new JTextField();
		Jtstatus.setBounds(230, 200, 150, 30);
		add(Jtstatus);
		
		check=new JButton("check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		check.setBounds(30, 300, 100, 25);
		add(check);
		
		update=new JButton("update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setBounds(160, 300, 100, 25);
		add(update);
		
		back=new JButton("back");
		back.setBackground(Color.black);
		back.addActionListener(this);
		back.setForeground(Color.white);
		back.setBounds(280, 300, 100, 25);
		add(back);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
		Image i2=im1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel im2=new JLabel(i3);
		im2.setBounds(420, 50, 500, 300);
		add(im2);
		
		
		
		setBounds(300, 200, 980, 500);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// TODO Auto-generated method stub
		if(ae.getSource()==check)
		{
			String id=ccustomer.getSelectedItem();
			String query="select * from customer where cnumber='"+id+"'";
			
			try {
				JdBcCoNnEcTiOn jd1=new JdBcCoNnEcTiOn();
				ResultSet rs1=jd1.st.executeQuery(query);
				String r="";
				while(rs1.next())
				{
					r=rs1.getString("room");
					JtroomNumber.setText(r);
					//Jtname.setText(rs1.getString("cname"));
					//Jtamount.setText(rs1.getString("deposit"));
				}
				
				ResultSet rs2=jd1.st.executeQuery("select * from room where roomnumber='"+r+"'");
				
				while(rs2.next())
				{
					Jtavailable.setText(rs2.getString("available"));
					Jtstatus.setText(rs2.getString("roomstatus"));
				
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		else if (ae.getSource()==update) {
			
			String number=ccustomer.getSelectedItem();
			String available=Jtavailable.getText();
			String room=JtroomNumber.getText();
			String status=Jtstatus.getText();
			
			try {
				JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			jd.st.executeUpdate("update room set available='"+available+"',roomstatus='"+status+"'  where roomnumber='"+room+"'");
				JOptionPane.showMessageDialog(null, "Update Success fully");
				
				setVisible(false);
				new Reception();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		else {
			setVisible(false);
			new Reception();
		}
		
		
	}
	
	public static void main(String[] args) {
		new Update_Room_Status();
	}

	

}
