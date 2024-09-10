package com.in.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class addEmployee extends JFrame implements ActionListener{
	
	JTextField  nametx, agetx,jtsalary,jtphone,jtemail;
	JRadioButton jmale,jfemal;
	JButton submit,cancel;
	JComboBox jcmb;
	
	public addEmployee() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		
		
		JLabel name=new JLabel("NAME");
		name.setBounds(90, 30, 120, 30);
		name.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(name);
		 nametx=new JTextField();
		nametx.setBounds(200, 30, 150, 30);
		add(nametx);
		
		JLabel age=new JLabel("AGE");
		age.setBounds(90, 80, 120, 30);
		age.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(age);
		 agetx=new JTextField();
		agetx.setBounds(200, 80, 150, 30);
		add(agetx);
		
		JLabel gender=new JLabel("GENDER");
		gender.setBounds(90, 130, 120, 30);
		gender.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(gender);
		 jmale=new JRadioButton("Male");
		jmale.setBounds(200, 130, 70, 30);
		add(jmale);
	    jfemal=new JRadioButton("Female");
		jfemal.setBounds(280, 130, 70, 30);
		add(jfemal);
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(jmale);
		bGroup.add(jfemal);
		
		JLabel jljob=new JLabel("JOB");
		jljob.setBounds(90, 180, 120, 30);
		jljob.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(jljob);
		
		String[] str= {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staf","Room Service","Chiefs","Waiter/Waiterss","Accounter","Manager"};
		 jcmb=new JComboBox(str); 
		jcmb.setBounds(200, 180, 150, 30);
		add(jcmb);
		
		JLabel jlsalary=new JLabel("SALARY");
		jlsalary.setBounds(90, 230, 120, 30);
		jlsalary.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(jlsalary);
		 jtsalary=new JTextField();
		jtsalary.setBounds(200, 230, 150, 30);
		add(jtsalary);
		
		JLabel jlphone=new JLabel("PHONE");
		jlphone.setBounds(90, 270, 120, 30);
		jlphone.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(jlphone);
		 jtphone=new JTextField();
		jtphone.setBounds(200, 270, 150, 30);
		add(jtphone);
		
		JLabel jlemail=new JLabel("EMAIL");
		jlemail.setBounds(90, 310, 120, 30);
		jlemail.setFont(new Font("Tohoma",Font.PLAIN,18));
		add(jlemail);
		jtemail=new JTextField();
		jtemail.setBounds(200, 310, 150, 30);
		add(jtemail);
		
//		JLabel jlpassword=new JLabel("PASSWORD");
//		jlpassword.setBounds(70, 350, 120, 30);
//		jlpassword.setFont(new Font("Tohoma",Font.PLAIN,18));
//		add(jlpassword);
//		JTextField jtpassword=new JTextField();
//		jtpassword.setBounds(200, 350, 150, 30);
//		add(jtpassword);
		
		 submit=new JButton("SUBMIT");
		submit.setBounds(90, 400, 90, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		 cancel=new JButton("CANCEL");
		 cancel.setBounds(200, 400, 90, 25);
		 cancel.setBackground(Color.BLACK);
		 cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
		Image i2=im.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel jlimage=new JLabel(i3);
		jlimage.setBounds(380, 60, 450, 370);
		add(jlimage);
	
		setBounds(350, 200, 850, 540);
		setUndecorated(true);
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==submit) {
		String name=nametx.getText();
		String age=agetx.getText();
		String salary=jtsalary.getText();
		String phone=jtphone.getText();
		String email=jtemail.getText();
		
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Name should note be empty");
			return;
		}
		else if(age.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Age should note be empty");
			return;
		}
		else if(salary.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Salary should note be empty");
			return;
		}
		else if(phone.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Phone should note be empty");
			return;
		}
		else if(email.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Age should note be empty");
			return;
		}
		
		String gender=null;
		if(jmale.isSelected())
		{
			gender="male";
		}
		else if (jfemal.isSelected()) {
			gender="femal";
		}
		String job = (String)jcmb.getSelectedItem();
		
		try {
			JdBcCoNnEcTiOn jdbc=new JdBcCoNnEcTiOn();
			
			String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+phone+"','"+salary+"','"+email+"')";
			jdbc.st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee add sucessfully");
			setVisible(false);
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}else {
		
		setVisible(false);
		new Dashboard();
		
	}
			
}
	
	public static void main(String[] args) {
		new addEmployee();
	}
	

}
