package com.in.main;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Pickup_Service extends JFrame implements ActionListener {
	// visible Rooms
	JTable jtable;
	JButton back, submit;
	JComboBox jcBedtype;
	Choice car;

	public Pickup_Service() {
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel text = new JLabel("PICKUP SERVICE");
		text.setFont(new Font("Tohama", Font.BOLD, 20));
		text.setBounds(400, 30, 200, 30);
		add(text);

		JLabel jlbed = new JLabel("TYPE OF CAR");
		jlbed.setFont(new Font("Tohama", Font.BOLD, 15));
		jlbed.setBounds(40, 100, 150, 20);
		add(jlbed);

		car=new Choice();
		car.setBounds(190, 100, 150, 25);
		car.setBackground(Color.WHITE);
		add(car);
		
		try {
			JdBcCoNnEcTiOn jd=new JdBcCoNnEcTiOn();
			ResultSet rs=jd.st.executeQuery("select * from driver");
			while(rs.next())
			{
				car.add(rs.getString("company"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
//		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
//		Image i2=im1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//		ImageIcon i3=new ImageIcon(i2);
//		JLabel img=new JLabel(i3);
//		img.setBounds(500, 0, 600, 600);
//		add(img);

		jtable = new JTable();
		jtable.setBounds(0, 200, 800, 300);
		add(jtable);

		JLabel j1 = new JLabel("NAME");
		j1.setBounds(5, 160, 100, 20);
		add(j1);

		JLabel j2 = new JLabel("AGE");
		j2.setBounds(140, 160, 100, 20);
		add(j2);

		JLabel j3 = new JLabel("GENDER");
		j3.setBounds(270, 160, 100, 20);
		add(j3);

		JLabel j4 = new JLabel("LOCATION");
		j4.setBounds(400, 160, 100, 20);
		add(j4);

		JLabel j5 = new JLabel("AVAILABILITY");
		j5.setBounds(530, 160, 100, 20);
		add(j5);
		
		JLabel j6 = new JLabel("COMPANY");
		j6.setBounds(670, 160, 100, 20);
		add(j6);

		submit = new JButton("SUBMIT");
		submit.setBounds(500, 500, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

		back = new JButton("BACK");
		back.setBounds(300, 500, 120, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		try {

			JdBcCoNnEcTiOn jd = new JdBcCoNnEcTiOn();
			ResultSet rs = jd.st.executeQuery("select * from driver");
			jtable.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		setBounds(300, 200, 1050, 600);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		if (ae.getSource() == submit) {
			try {
				String query1 = "select * from driver where company='" + car.getSelectedItem() + "'";

				JdBcCoNnEcTiOn jd = new JdBcCoNnEcTiOn();
				ResultSet rs;
				
					rs = jd.st.executeQuery(query1);
				
				jtable.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			setVisible(false);
			new Reception();

		}
	}

	public static void main(String[] args) {
		new Pickup_Service();
	}

}
