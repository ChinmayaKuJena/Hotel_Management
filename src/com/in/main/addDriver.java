package com.in.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addDriver extends JFrame implements ActionListener {
	JTextField jtname, jtcompany,jtage,jtlocation;
	JButton addbotton,cancelbotton;
	JComboBox AvailablecomboBox,gendercomboBox;
	
	public addDriver() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel head=new JLabel("ADD DRIVER");
		head.setFont(new Font("Tahoma",Font.BOLD,18));
		head.setBounds(150, 20, 200, 20);
		add(head);
		
		JLabel jlname = new JLabel("DRIVER NAME");
		jlname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlname.setBounds(60, 80, 200, 30);
		add(jlname);
		 jtname = new JTextField();
		 jtname.setBounds(200, 80, 150, 30);
		add(jtname);
		
		JLabel jlage = new JLabel("DRIVER AGE");
		jlage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlage.setBounds(60, 120, 200, 30);
		add(jlage);
		 jtage = new JTextField();
		 jtage.setBounds(200, 120, 150, 30);
		add(jtage);
		
		JLabel JlbedType = new JLabel("GENDER");
		JlbedType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JlbedType.setBounds(60, 200, 200, 30);
		add(JlbedType);
		String[] typeoption= {"MALE","FEMALE"};
		 gendercomboBox=new JComboBox(typeoption);
		 gendercomboBox.setBounds(200, 200, 150, 30);
		add(gendercomboBox);
		
		
		
		JLabel Jlcompany = new JLabel("CAR COMPANY");
		Jlcompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlcompany.setBounds(50, 280, 200, 30);
		add(Jlcompany);
		jtcompany = new JTextField();
		jtcompany.setBounds(200, 280, 150, 30);
		add(jtcompany);
		
		
		JLabel Jllocation = new JLabel("LOCATION");
		Jllocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jllocation.setBounds(50, 240, 200, 30);
		add(Jllocation);
		jtlocation = new JTextField();
		jtlocation.setBounds(200, 240, 150, 30);
		add(jtlocation);
		
		JLabel Jlavailable = new JLabel("AVAILABLE");
		Jlavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlavailable.setBounds(60, 160, 200, 30);
		add(Jlavailable);
		String[] Availableoption= {"Available","Occupied"};
		 AvailablecomboBox=new JComboBox(Availableoption);
		AvailablecomboBox.setBounds(200, 160, 150, 30);
		add(AvailablecomboBox);
	
		 addbotton=new JButton("Add Car");
		addbotton.setBounds(150, 350, 100, 30);
		addbotton.setBackground(Color.BLACK);
		addbotton.setForeground(Color.white);
		addbotton.addActionListener(this);
		add(addbotton);
		
		 cancelbotton=new JButton("Cancel");
		cancelbotton.setBounds(280, 350, 100, 30);
		cancelbotton.setBackground(Color.BLACK);
		cancelbotton.setForeground(Color.white);
		cancelbotton.addActionListener(this);
		add(cancelbotton);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
		Image i1=im.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i1);
		JLabel img2=new JLabel(i3);
		img2.setBounds(400, 30, 500, 300);
		add(img2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 200, 940, 470);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cancelbotton)
		{
			//setVisible(false);
			new Dashboard();
		}
		if(ae.getSource()==addbotton)
		{
			String dname=jtname.getText();
			String dage=jtage.getText();
			String gender=(String)gendercomboBox.getSelectedItem();
			String company=jtcompany.getText();
			String location=jtlocation.getText();
			String available=(String)AvailablecomboBox.getSelectedItem();
			
			
			if(dname.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name should note be empty");
				return;
			}
			if(dage.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Age should note be empty");
				return;
			}
			if(company.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Company should note be empty");
				return;
			}
			if(location.equals(""))
			{
				JOptionPane.showMessageDialog(null, "location should note be empty");
				return;
			}
			if(available.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Available should note be empty");
				return;
			}
			
			

			try {
				JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
				String str="insert into driver values('"+dname+"','"+dage+"','"+gender+"','"+location+"','"+available+"','"+company+"')";
				jd.st.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "CAR Added SucessFully");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new addDriver();
	}

}
