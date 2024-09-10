package com.in.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
	
	JButton newCustmor,rooms,department,allEmployee,Manager,Custmorinfo,search,checkin,checkout,updateRoomStatus,picUpservice,logout,checkout2;
	public Reception() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		 newCustmor=new JButton("NEW CUSTOMER"); 
		newCustmor.setBounds(10, 30, 200, 30);
		newCustmor.setBackground(Color.black);
		newCustmor.setForeground(Color.white);
		newCustmor.addActionListener(this);
		add(newCustmor);
//		
//		 rooms=new JButton(" DEPARTMENT ADD ROOMS");
//		rooms.setBounds(10, 70, 200, 30);
//		rooms.setBackground(Color.black);
//		rooms.setForeground(Color.white);
//		rooms.addActionListener(this);
//		add(rooms);
		
		 department=new JButton("DEPARTMENT");
		department.setBounds(10, 75, 200, 30);
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.addActionListener(this);
		add(department);
		
		
		 allEmployee=new JButton("ALL EMPLOYEE");
		allEmployee.setBounds(10, 120, 200, 30);
		allEmployee.setBackground(Color.black);
		allEmployee.setForeground(Color.white);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		 Custmorinfo=new JButton("ALL CUSTOMER INFO");
		Custmorinfo.setBounds(10, 165, 200, 30);
		Custmorinfo.setBackground(Color.black);
		Custmorinfo.setForeground(Color.white);
		Custmorinfo.addActionListener(this);

		add(Custmorinfo);
		
		Manager=new JButton("MANAGER");
		Manager.setBounds(10, 210, 200, 30);
		Manager.setBackground(Color.black);
		Manager.setForeground(Color.white);
		Manager.addActionListener(this);
		add(Manager);
		
		 search=new JButton("SEARCH ROOM");
		search.setBounds(10, 250, 200, 30);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);
		
		 updateRoomStatus=new JButton("UPDATE ROOM STATUS");
		updateRoomStatus.setBounds(10, 290, 200, 30);
		updateRoomStatus.setBackground(Color.black);
		updateRoomStatus.setForeground(Color.white);
		updateRoomStatus.addActionListener(this);
		add(updateRoomStatus);
		
	    picUpservice=new JButton("PICKUP SERVICES");
		picUpservice.setBounds(10, 330, 200, 30);
		picUpservice.setBackground(Color.black);
		picUpservice.addActionListener(this);
		picUpservice.setForeground(Color.white);
		add(picUpservice);
		
		 checkin=new JButton("CHECKIN & UPDATE");
		 checkin.setBounds(10, 370, 200, 30);
		 checkin.setBackground(Color.black);
		 checkin.setForeground(Color.white);
		 checkin.addActionListener(this);
		add(checkin);
		
		 checkout2=new JButton("CHECKOUT & UPDATE");
			checkout2.setBounds(10, 410, 200, 30);
			checkout2.setBackground(Color.black);
			checkout2.setForeground(Color.white);
			checkout2.addActionListener(this);
			add(checkout2);
		

		 logout=new JButton("LOGOUT");
		logout.setBounds(60, 460, 100, 25);
		logout.addActionListener(this);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		add(logout);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("rec.jpg"));
		Image im1=im.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
		ImageIcon im2=new ImageIcon(im1);
		JLabel im3=new JLabel(im2);
		im3.setBounds(250, 20, 800, 500);
		add(im3);
		
		
		setBounds(350, 200, 1100, 570);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==newCustmor)
		{
			setVisible(false);
			new AddCustomer();
		}
		else if (e.getSource()==rooms) {
			setVisible(false);
			new addRoom();
		}
		else if (e.getSource()==department) {
			setVisible(false);
			new Department();
		}
		else if (e.getSource()==allEmployee) {
			setVisible(false);
			new Employee_info();
		}
		else if (e.getSource()==Manager) {
			setVisible(false);
			new Manager();
		}
		else if (e.getSource()==Custmorinfo) {
			setVisible(false);
			new Customer_info();
		}
		else if (e.getSource()==search) {
			setVisible(false);
			new Search_Room();
		}
		else if (e.getSource()==checkout) {
			setVisible(false);
			new Check_in_Info();
		}
		else if (e.getSource()==updateRoomStatus) {
			setVisible(false);
			new Update_Room_Status();
		}
		else if (e.getSource()==picUpservice) {
			setVisible(false);
			new Pickup_Service();
		}
		else if (e.getSource()==checkin) {
			
			setVisible(false);
			new Check_in_Info();
			
		}
        else if (e.getSource()==checkout2) {
			
			setVisible(false);
			new Check_Out_info();
			
		}
		
		else if (e.getSource()==logout) {
			setVisible(false);
			System.exit(0);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Reception();
		
	}



}
