package com.in.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addRoom extends JFrame implements ActionListener {
	JTextField jtroom, jtprice;
	JButton addbotton,cancelbotton;
	JComboBox AvailablecomboBox,cleancomboBox,typecomboBox;
	
	public addRoom() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel head=new JLabel("ADD ROOMS");
		head.setFont(new Font("Tahoma",Font.BOLD,18));
		head.setBounds(150, 20, 200, 20);
		add(head);
		
		JLabel JlroomNo = new JLabel("ROOM NUMBER");
		JlroomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JlroomNo.setBounds(60, 80, 200, 30);
		add(JlroomNo);
		 jtroom = new JTextField();
		jtroom.setBounds(200, 80, 150, 30);
		add(jtroom);
		
		JLabel Jlavailable = new JLabel("AVAILABLE");
		Jlavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlavailable.setBounds(60, 130, 200, 30);
		add(Jlavailable);
		String[] Availableoption= {"AVAILABLE","OCCUPIED"};
		 AvailablecomboBox=new JComboBox(Availableoption);
		AvailablecomboBox.setBounds(200, 130, 150, 30);
		add(AvailablecomboBox);
		
		JLabel Jlclean = new JLabel("CLEANING STATUS");
		Jlclean.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlclean.setBounds(30, 180, 200, 30);
		add(Jlclean);
		String[] cleanoption= {"CLEAN","DIRTY"};
		 cleancomboBox=new JComboBox(cleanoption);
		cleancomboBox.setBounds(200, 180, 150, 30);
		add(cleancomboBox);
		
		JLabel Jlroomprice = new JLabel("ROOM PRICE");
		Jlroomprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jlroomprice.setBounds(50, 220, 200, 30);
		add(Jlroomprice);
		 jtprice = new JTextField();
		 jtprice.setBounds(200, 220, 150, 30);
		add(jtprice);
		
		JLabel JlbedType = new JLabel("BED TYPE");
		JlbedType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JlbedType.setBounds(60, 260, 200, 30);
		add(JlbedType);
		String[] typeoption= {"SINGEL","DOUBLE"};
		 typecomboBox=new JComboBox(typeoption);
		typecomboBox.setBounds(200, 260, 150, 30);
		add(typecomboBox);
		
		 addbotton=new JButton("Add Room");
		addbotton.setBounds(180, 330, 100, 30);
		addbotton.setBackground(Color.BLACK);
		addbotton.setForeground(Color.WHITE);
		addbotton.addActionListener(this);
		add(addbotton);
		
		 cancelbotton=new JButton("Cancel");
		cancelbotton.setBounds(320, 330, 100, 30);
		cancelbotton.setBackground(Color.black);
		cancelbotton.setForeground(Color.WHITE);
		cancelbotton.addActionListener(this);
		add(cancelbotton);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
		JLabel img2=new JLabel(im);
		img2.setBounds(400, 30, 500, 270);
		add(img2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(330, 200, 940, 470);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addbotton)
		{
			String roomnumber=jtroom.getText();
			String roomprice=jtprice.getText();
			String available=(String)AvailablecomboBox.getSelectedItem();
			String roomstatus=(String)cleancomboBox.getSelectedItem();
			String bedtype=(String)typecomboBox.getSelectedItem();
			
			

			if(roomnumber.equals(""))
			{
				JOptionPane.showMessageDialog(null, "RoomNumber should note be empty");
				return;
			}
			if(roomprice.equals(""))
			{
				JOptionPane.showMessageDialog(null, "RoomPrice should note be empty");
				return;
			}
		

			try {
				JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
				String str="insert into room values('"+roomnumber+"','"+available+"','"+roomprice+"','"+roomstatus+"','"+bedtype+"')";
				jd.st.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "NEW Room Added SucessFully");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			
		}
		else if (ae.getSource()==cancelbotton){
			setVisible(false);
			new Dashboard();
		}
	}
	
	public static void main(String[] args) {
		new addRoom();
	}

}
