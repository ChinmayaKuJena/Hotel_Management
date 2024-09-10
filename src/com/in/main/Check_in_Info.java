package com.in.main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Check_in_Info extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField JtroomNumber,Jtamount,Jtname,Jtpending;
	
	JButton check,update,back;
	
	
	public Check_in_Info() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text=new JLabel("UPDATE STATUS");
		text.setFont(new Font("Tohama",Font.PLAIN,20));
		text.setBounds(130, 30, 200, 30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel jlid=new JLabel("CUSTOMER ID");
		jlid.setFont(new Font("Tohama",Font.PLAIN,18));
		jlid.setBounds(80, 80, 140, 30);
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
		jlrnum.setBounds(80, 120, 150, 30);
		add(jlrnum);
		JtroomNumber=new JTextField();
		JtroomNumber.setBounds(230, 120, 150, 30);
		add(JtroomNumber);
		
		JLabel jlname=new JLabel("NAME");
		jlname.setFont(new Font("Tohama",Font.PLAIN,18));
		jlname.setBounds(120, 160, 150, 30);
		add(jlname);
		Jtname=new JTextField();
		Jtname.setBounds(230, 160, 150, 30);
		add(Jtname);
		
		JLabel jlamount=new JLabel("PAID AMOUNT");
		jlamount.setFont(new Font("Tohama",Font.PLAIN,18));
		jlamount.setBounds(65, 200, 150, 30);
		add(jlamount);
		Jtamount=new JTextField();
		Jtamount.setBounds(230, 200, 150, 30);
		add(Jtamount);
		
		JLabel jlpending=new JLabel("PENDING AMOUNT");
		jlpending.setFont(new Font("Tohama",Font.PLAIN,18));
		jlpending.setBounds(55, 240, 200, 30);
		add(jlpending);
		Jtpending=new JTextField();
		Jtpending.setBounds(230, 240, 150, 30);
		add(Jtpending);
		
		check=new JButton("check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		check.setBounds(140, 330, 100, 25);
		add(check);
		
		update=new JButton("update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setBounds(270, 330, 100, 25);
		add(update);
		
		back=new JButton("back");
		back.setBackground(Color.black);
		back.addActionListener(this);
		back.setForeground(Color.white);
		back.setBounds(400, 330, 100, 25);
		add(back);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
		JLabel im2=new JLabel(im1);
		im2.setBounds(420, 50, 450, 250);
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
					Jtname.setText(rs1.getString("cname"));
					Jtamount.setText(rs1.getString("deposit"));
				}
				
				ResultSet rs2=jd1.st.executeQuery("select * from room where roomnumber='"+r+"'");
				
				while(rs2.next())
				{
					String price=rs2.getString("roomprice");
					
					
					int amountPaid=Integer.parseInt(price)-Integer.parseInt(Jtamount.getText());
					Jtpending.setText(""+amountPaid);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		else if (ae.getSource()==update) {
			
			String number=ccustomer.getSelectedItem();
			String name=Jtname.getText();
			String room=JtroomNumber.getText();
			String deposit=Jtamount.getText();
			
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name should not be empty");
				return;
			}
			if(room.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Room should not be empty");
				return;
			}
			if(deposit.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Deposit should not be empty");
				return;
			}
			
			try {
				JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
				jd.st.executeUpdate("update customer set room='"+room+"',cname='"+name+"',deposit='"+deposit+"' where cnumber='"+number+"'");
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
		new Check_in_Info();
	}

	

}
