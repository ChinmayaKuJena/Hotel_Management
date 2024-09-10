package com.in.main;

import java.awt.Checkbox;
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

public class Search_Room extends JFrame implements ActionListener {
	// visible Rooms
	JTable jtable;
	JButton back, submit;
	JComboBox jcBedtype;
	JCheckBox check1;

	public Search_Room() {
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel text = new JLabel("SEARCH FOR ROOM");
		text.setFont(new Font("Tohama", Font.BOLD, 20));
		text.setBounds(400, 30, 200, 30);
		add(text);

		JLabel jlbed = new JLabel("Bed Type");
		jlbed.setBounds(50, 100, 200, 20);
		add(jlbed);

		jcBedtype = new JComboBox(new String[]{"SINGEL","DOUBEL"});
		jcBedtype.setBounds(150, 100, 150, 25);
		jcBedtype.setBackground(Color.WHITE);
		add(jcBedtype);

		check1 = new JCheckBox("Only Display Available");
		check1.setBounds(650, 100, 200, 35);
		check1.setBackground(Color.WHITE);
		//check1.addActionListener(this);
		add(check1);

//		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
//		Image i2=im1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//		ImageIcon i3=new ImageIcon(i2);
//		JLabel img=new JLabel(i3);
//		img.setBounds(500, 0, 600, 600);
//		add(img);

		jtable = new JTable();
		jtable.setBounds(0, 200, 1000, 300);
		add(jtable);

		JLabel j1 = new JLabel("Room Number");
		j1.setBounds(5, 160, 100, 20);
		add(j1);

		JLabel j2 = new JLabel("Available");
		j2.setBounds(200, 160, 100, 20);
		add(j2);

		JLabel j3 = new JLabel("Price");
		j3.setBounds(400, 160, 100, 20);
		add(j3);

		JLabel j4 = new JLabel("Clean Status");
		j4.setBounds(600, 160, 100, 20);
		add(j4);

		JLabel j5 = new JLabel("Bed Type");
		j5.setBounds(800, 160, 100, 20);
		add(j5);

		submit = new JButton("SUBMIT");
		submit.setBounds(500, 500, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(300, 500, 120, 30);
		back.addActionListener(this);
		add(back);

		try {

			JdBcCoNnEcTiOn jd = new JdBcCoNnEcTiOn();
			ResultSet rs = jd.st.executeQuery("select * from room");
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
				String query1 = "select * from room where bedtype='" + jcBedtype.getSelectedItem() + "'";
				String query2 = "select * from room where available='Available' AND bedtype='"
						+ jcBedtype.getSelectedItem() + "'";
				JdBcCoNnEcTiOn jd = new JdBcCoNnEcTiOn();
				ResultSet rs;
				if (check1.isSelected()) {
					
					rs = jd.st.executeQuery(query2);
				} else {
					
					rs = jd.st.executeQuery(query1);
				}
				
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
		new Search_Room();
	}

}
