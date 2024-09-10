package com.in.main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {
	
	JComboBox comboid;
	JTextField jtnumber,jtname,jtcountry,jtDeposit;
	JRadioButton rmale,rfemal;
	Choice croom;
	JLabel checkin;
	JButton addButtom,cancelButtom;
	ButtonGroup bGroup;
	
	AddCustomer()
	{
		setLayout(null);
		
		JLabel text=new JLabel("CUSTOMER FORM");
		text.setBounds(100, 20, 300, 30);
		text.setFont(new Font("Raleway",Font.PLAIN,20));
		add(text);
		
		JLabel jlId=new JLabel("ID");
		jlId.setBounds(80, 75, 300, 30);
		jlId.setFont(new Font("Raleway",Font.PLAIN,18));
		add(jlId);
		
		String[] option= {"Adhar Card","Passport","Driving License","Pan Card","Voat id Card"};
		comboid=new JComboBox(option);
		comboid.setBounds(200, 80, 150, 25);
		comboid.setBackground(Color.white);
		add(comboid);
		
		JLabel jlnumber=new JLabel("NUMBER");
		jlnumber.setBounds(80, 115, 300, 30);
		jlnumber.setFont(new Font("Raleway",Font.PLAIN,18));
		add(jlnumber);
		jtnumber=new JTextField();
		jtnumber.setBounds(200, 120, 150, 25);
		add(jtnumber);
		
		JLabel jlname=new JLabel("NAME");
		jlname.setBounds(80, 155, 300, 30);
		jlname.setFont(new Font("Raleway",Font.PLAIN,18));
		add(jlname);
		jtname=new JTextField();
		jtname.setBounds(200, 155, 150, 25);
		add(jtname);
		
		JLabel gender=new JLabel("GENDER");
		gender.setBounds(80, 190, 120, 30);
		gender.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(gender);
		rmale=new JRadioButton("Male");
		rmale.setBounds(200, 190, 70, 30);
		add(rmale);
		rfemal=new JRadioButton("Femal");
		rfemal.setBounds(280, 190, 70, 30);
		add(rfemal);
		 bGroup=new ButtonGroup();
		bGroup.add(rmale);
		bGroup.add(rfemal);
		
		JLabel jlcountry=new JLabel("COUNTRY");
		jlcountry.setBounds(80, 225, 300, 30);
		jlcountry.setFont(new Font("Raleway",Font.PLAIN,18));
		add(jlcountry);
		jtcountry=new JTextField();
		jtcountry.setBounds(200, 225, 150, 25);
		add(jtcountry);
		
		JLabel jlroomno=new JLabel("ROOM NUMBER");
		jlroomno.setBounds(40, 260, 150, 30);
		jlroomno.setFont(new Font("Raleway",Font.PLAIN,18));
		add(jlroomno);
		
		croom=new Choice();
		
		try {
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			String query="select * from room where available='Available'";
			ResultSet rs = jd.st.executeQuery(query);
			
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		croom.setBounds(200, 260, 150, 30);
		croom.setBackground(Color.WHITE);
		add(croom);
		
		JLabel checkintime =new JLabel("CHECK IN TIME"); 
		 checkintime.setBounds(40, 290, 150, 30);
		 checkintime.setFont(new Font("Raleway",Font.PLAIN,18));
		 add(checkintime);
		 
		 Date date=new Date();
		 checkin=new JLabel(date +"");
		 checkin.setBounds(200, 290, 150, 30);
		 checkin.setFont(new Font("Raleway",Font.PLAIN,16));
		 add(checkin);
		
		 JLabel jlDeposit=new JLabel("DEPOSIT"); 
		 jlDeposit.setBounds(70, 330, 150, 30);
		 jlDeposit.setFont(new Font("Raleway",Font.PLAIN,18));
		 add(jlDeposit);
		 
		 jtDeposit=new JTextField();
		 jtDeposit.setBounds(200, 330, 150, 25);
		 add(jtDeposit);
		 
		  addButtom=new JButton("ADD");
		  addButtom.setBounds(70, 390, 100, 30);
		  addButtom.addActionListener(this);
		  addButtom.setBackground(Color.BLACK);
		  addButtom.setForeground(Color.WHITE);
		  add(addButtom);
		  
		  cancelButtom=new JButton("BACK");
		  cancelButtom.setBounds(200, 390, 100, 30);
		  cancelButtom.addActionListener(this);
		  cancelButtom.setBackground(Color.BLACK);
		  cancelButtom.setForeground(Color.WHITE);
		  add(cancelButtom);
		  
		  ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("fifth.png")); 
		  Image i2=im.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		  ImageIcon i3=new ImageIcon(i2);
		  JLabel im2=new JLabel(i3); 
		  im2.setBounds(450, 50, 300, 400);
		  add(im2);
		  
	
		setVisible(true);
		setBounds(350, 200, 850, 500);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addButtom)
		{
			String id=(String)comboid.getSelectedItem(); 
			String cnumber=jtnumber.getText();
			String cname=jtname.getText();
			
			String gender=null;
			if(rmale.isSelected())
			{
				gender="Male";
			}
			else {
				gender="Femal";
			}
			String country=jtcountry.getText();
			String room=croom.getSelectedItem();
			String checkintime=checkin.getText();
			String deposit=jtDeposit.getText();
			
			if(cnumber.equals("")) {
				JOptionPane.showMessageDialog(null, "Number should not be empty");
				return;
			}
			if(cname.equals("")) {
				JOptionPane.showMessageDialog(null, "Name should not be empty");
				return;
			}
			if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender should not be empty");
				return;
			}
			if(country.equals("")) {
				JOptionPane.showMessageDialog(null, "Country should not be empty");
				return;
			}
			if(room.equals("")) {
				JOptionPane.showMessageDialog(null, "Room should not be empty");
				return;
			}
			if(deposit.equals("")) {
				JOptionPane.showMessageDialog(null, "Deposit should not be empty");
				return;
			}

			
			try {
				
				String query="insert into customer values('"+id+"','"+cnumber+"','"+cname+"','"+gender+"','"+country+"','"+room+"','"+checkintime+"','"+deposit+"')";
				//update
				String query2="update room set available='accupied' where roomnumber='"+room+"'";
				
				JdBcCoNnEcTiOn jd1=new JdBcCoNnEcTiOn();
				jd1.st.executeUpdate(query);
				jd1.st.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer Add SuccessFully");
				setVisible(false);
				new Reception();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if (ae.getSource()==cancelButtom) {
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		
		new AddCustomer();
	}
	
}
