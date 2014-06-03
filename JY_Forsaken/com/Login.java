package com;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mainInterface.EquipmentMS;
/**
 * @author Forsaken
 * @date 20014��05��14��
 */

public class Login extends JFrame {
 public Login() {
  super("����ϵͳ��½");
  this.setBounds(280, 280, 300, 200);
  setLayout(new BorderLayout());
  // ���õ�½����Ŀ�Ⱥ͸߶�
  JPanel p1 = new JPanel();
  p1.setLayout(new GridLayout(2, 2));
  p1.add(userL);
  p1.add(user);
  p1.add(passwordL);
  p1.add(password);
  p1.setSize(150, 100);
  JPanel p2 = new JPanel();
  p2.add(ok);
  p2.add(cancel);
  add("North", p1);
  add("Center", p2);
  add("South", cue);
  // ����Ϊֹ,��½�Ľ����������!�������Ϊ����İ�ť���þ�����¼�������
  cancel.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });// ���õ�½ʱ��ȡ����ť,�������ť���˳����еĳ���
  ok.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ((user.getText()).equals("admin")
      && String.valueOf((password.getPassword())).equals(
        "admin")) {
     result = true;
     // hidFun();
     //JOptionPane.showMessageDialog(null, "���:���½�ɹ�,����ϵͳ!");
     Login.this.setVisible(false);
 	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   new EquipmentMS();
	} catch (Exception ex) {
		ex.printStackTrace();
	} 
     
    } else {
     // cue.setText("��������������!");
     JOptionPane.showMessageDialog(null, "���:��������������,����������!");
    }
   }
  }
  );// ����ok�����¼�������,����֤�û���������,�����������ʱ��ʾ"��������������!"
 }
 public boolean isLogin() {
  return result;
 }
 /**
  * ���ñ���������..
  * 
  */
 private void hidFun() {
  this.setVisible(false);
 }
 private JLabel userL = new JLabel("�û���");
 private JLabel passwordL = new JLabel("����");
 private JLabel cue = new JLabel();
 private JTextField user = new JTextField("admin");
 private JPasswordField password = new JPasswordField();
 private JButton ok = new JButton("ȷ��");
 private JButton cancel = new JButton("�˳�");
 private boolean result = false;
 /**
  * ������.....
  * 
  * @param agrs
  */
 public static void main(String[] args) {
  Login oop = new Login();
  oop.setVisible(true);
  oop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}

