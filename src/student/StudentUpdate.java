package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//����
public class StudentUpdate extends JPanel implements ActionListener {
	Connection con;
	Statement sql;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton b1, b2,b3;
	Box baseBox, bv1, bv2;
	int flag = 0;

	StudentUpdate() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8", "root",
					"213339");
			sql = con.createStatement();
		} catch (SQLException ee) {
		}
		setLayout(new BorderLayout());
		b1 = new JButton("����");
		b2 = new JButton("����");
		b2.setBackground(Color.RED);
		b3 = new JButton("����");
		b3.setBackground(Color.green);
		b1.addActionListener(this);
		
		b3.setBackground(Color.BLUE);
		b2.addActionListener(this);
		b3.addActionListener(this);

		t1 = new JTextField(8);
		t2 = new JTextField(16);
		t3 = new JTextField(16);
		t4 = new JTextField(16);
		t5 = new JTextField(16);
		t6 = new JTextField(16);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4= new JPanel();

		p1.add(new JLabel("������Ҫ�޸ĵ�ѧ��ѧ�ţ�"));
		p1.add(t1);
		p1.add(b1);
		p3.add(b2);
	    p3.add(b3);
		bv1 = Box.createVerticalBox();
		bv1.add(new JLabel("����"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("�Ա�"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("������ַ"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("�绰"));
		bv1.add(Box.createVerticalStrut(8));
		bv1.add(new JLabel("Ŀǰ���ڵ���"));
		bv1.add(Box.createVerticalStrut(8));
		bv2 = Box.createVerticalBox();
		bv2.add(t2);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t3);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t4);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t5);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(t6);
		bv2.add(Box.createVerticalStrut(8));

		baseBox = Box.createHorizontalBox();
		baseBox.add(bv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(bv2);

		p2.add(baseBox);
		add(p1, "North");
		add(p2, "Center");
		//add(b2, "South");
		//p4.add(baseBox);
	    add(p3,"South");
		setSize(350, 300);
		setBackground(Color.white);
       }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1||e.getSource() ==b3) {
			try {
				sure();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b2) {
			try {
				update();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void update() throws SQLException {
		String num, name, gender, address, phone, major;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8", "root",
					"213339");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = "'" + t1.getText().trim() + "'";
		name = "'" + t2.getText().trim() + "'";
		gender = "'" + t3.getText().trim() + "'";
		address = "'" + t4.getText().trim() + "'";
		phone = "'" + t5.getText().trim() + "'";
		major = "'" + t6.getText().trim() + "'";
		String s1 = "UPDATE student SET ID=" + num + " WHERE id = " + num;
		sql.executeUpdate(s1);

		String s2 = "UPDATE student SET NAME=" + name + " WHERE id = " + num;
		sql.executeUpdate(s2);

		String s3 = "UPDATE student SET GENDER=" + gender + " WHERE id = " + num;
		sql.executeUpdate(s3);

		String s4 = "UPDATE student SET ADDRESS=" + address + " WHERE id = " + num;
		sql.executeUpdate(s4);

		String s5 = "UPDATE student SET PHONE=" + phone + " WHERE id = " + num;
		sql.executeUpdate(s5);

		String s6 = "UPDATE student SET MAJOR=" + major + " WHERE id = " + num;
		sql.executeUpdate(s6);
		JOptionPane.showMessageDialog(this, "���³ɹ�!", "��ʾ�Ի���", JOptionPane.INFORMATION_MESSAGE);
		con.close();

	}

	public void sure() throws SQLException {
		String num, name, gender, address, phone, major;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8", "root",
				"123456");
		num = t1.getText().trim();
		ResultSet rs = sql.executeQuery("SELECT* FROM student WHERE id = '" + num + "'");

		if (rs.next()) {
			name = rs.getString("name");
			gender = rs.getString("gender");
			address = rs.getString("address");
			phone = rs.getString("phone");
			major = rs.getString("major");
			t2.setText(name);
			t3.setText(gender);
			t4.setText(address);
			t5.setText(phone);
			t6.setText(major);
			flag = 1;
		} else {
			JOptionPane.showMessageDialog(this, "û�и�ѧ��!", "��ʾ�Ի���", JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		if (flag == 0) {
			t1.setText("û�и�ѧ��");
		}
	}

}
