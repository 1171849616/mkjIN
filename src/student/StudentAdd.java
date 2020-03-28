package student;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;

public class StudentAdd extends JPanel implements ActionListener{
  Connection con; //���ض����ݿ�����ӣ��Ự����
  Statement sql; //����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ���
  JButton b1,b2;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6;
  Box baseBox,bv1,bv2;
  StudentAdd(){
   try{										//���������
    Class.forName("com.mysql.jdbc.Driver");	//ͨ�� Class.forNameΪ���ݿ����ϵͳ����һ��JDBC��������
    }
   catch(ClassNotFoundException e){}		//�����������ʧ�� ����̨�׳��쳣
    try{									//������������ɹ��� �������������ض����ݿ�
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8","root","123456");
     sql=con.createStatement();      //��ȡcon��Ա������ȡStatement����
    }
    catch(SQLException ee){}
    
    //������岼�� Ϊ�߿򲼾�
   setLayout(new BorderLayout());
   JPanel p1=new JPanel();
   JPanel p2=new JPanel();
   tf1=new JTextField(16);
   tf2=new JTextField(16);
   tf3=new JTextField(16);
   tf4=new JTextField(16);
   tf5=new JTextField(16);
   tf6=new JTextField(16);
   b1=new JButton("¼��");  
   b2=new JButton("����");
 
   b1.addActionListener(this);
   b2.addActionListener(this);
   p1.add(b1);
   p1.add(b2);
   bv1=Box.createVerticalBox();
   bv1.add(new JLabel("ѧ��"));
   bv1.add(Box.createVerticalStrut(8));
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
   bv2=Box.createVerticalBox();
   bv2.add(tf1);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf2);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf3);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf4);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf5);
   bv2.add(Box.createVerticalStrut(8));
   bv2.add(tf6);
   bv2.add(Box.createVerticalStrut(8));
   baseBox=Box.createHorizontalBox();
   baseBox.add(bv1);
   baseBox.add(Box.createHorizontalStrut(10));
   baseBox.add(bv2);
   p2.add(baseBox);
   add(p1,"South");
   add(p2,"Center");
   setSize(350,300);
   setBackground(Color.pink);
  }
  public void actionPerformed(ActionEvent e){
   if(e.getSource()==b1){
    try{ insert();}
    catch(SQLException ee){}
    JOptionPane.showMessageDialog(this,"���������!","��ʾ�Ի���",JOptionPane.INFORMATION_MESSAGE);
   }
   else if(e.getSource()==b2){
       tf1.setText(" ");
       tf2.setText(" ");
       tf3.setText(" ");
       tf4.setText(" ");
       tf5.setText(" ");
       tf6.setText(" ");
   }
  }
  public void insert() throws SQLException{
   String s1="'"+tf1.getText().trim()+"'";
   String s2="'"+tf2.getText().trim()+"'";
   String s3="'"+tf3.getText().trim()+"'";
   String s4="'"+tf4.getText().trim()+"'";
   String s5="'"+tf5.getText().trim()+"'";
   String s6="'"+tf6.getText().trim()+"'";
   
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=utf8","root","123456");
   
    String temp="INSERT INTO student VALUES ("+s1+","+s2+","+s3+","+s4+","+s5+","+s6+")";
    sql.executeUpdate(temp);
   con.close();
  }
}


