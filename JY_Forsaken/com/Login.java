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
 * @date 20014年05月14日
 */

public class Login extends JFrame {
 public Login() {
  super("管理系统登陆");
  this.setBounds(280, 280, 300, 200);
  setLayout(new BorderLayout());
  // 设置登陆界面的宽度和高度
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
  // 到此为止,登陆的界面基本结束!下面的是为里面的按钮设置具体的事件监听器
  cancel.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });// 设置登陆时的取消按钮,按这个按钮就退出所有的程序
  ok.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ((user.getText()).equals("admin")
      && String.valueOf((password.getPassword())).equals(
        "admin")) {
     result = true;
     // hidFun();
     //JOptionPane.showMessageDialog(null, "你好:你登陆成功,进入系统!");
     Login.this.setVisible(false);
 	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   new EquipmentMS();
	} catch (Exception ex) {
		ex.printStackTrace();
	} 
     
    } else {
     // cue.setText("你输入的密码错误!");
     JOptionPane.showMessageDialog(null, "你好:你输入的密码错误,请重新输入!");
    }
   }
  }
  );// 设置ok键的事件监听器,并验证用户名和密码,密码输入错误时提示"您输入的密码错误!"
 }
 public boolean isLogin() {
  return result;
 }
 /**
  * 设置本界面隐藏..
  * 
  */
 private void hidFun() {
  this.setVisible(false);
 }
 private JLabel userL = new JLabel("用户名");
 private JLabel passwordL = new JLabel("密码");
 private JLabel cue = new JLabel();
 private JTextField user = new JTextField("admin");
 private JPasswordField password = new JPasswordField();
 private JButton ok = new JButton("确定");
 private JButton cancel = new JButton("退出");
 private boolean result = false;
 /**
  * 主函数.....
  * 
  * @param agrs
  */
 public static void main(String[] args) {
  Login oop = new Login();
  oop.setVisible(true);
  oop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}

