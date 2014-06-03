package com.interfaceModule.infoSelect;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.*;

public class SearchIDInfo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Container contentPane;
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField jTextField = new JTextField(4);
	JButton searchInfo = new JButton();
	String tablename = null;

	public SearchIDInfo(String str) {
		this.setTitle("按编号查询");
		this.setResizable(false);
		this.setIconImage(getImage("image/smile.png"));
		this.tablename = str;
		try {
			Init();

		} catch (Exception e) {
			e.printStackTrace();

		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 100) / 2,
				((int) screenSize.height - 300) / 2 + 45);
	}

	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入编号");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jLabel1);

		jTextField.setText(null);
		jTextField.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jTextField);

		searchInfo.setText("确定");
		searchInfo.setFont(new Font("Dialgo", 0, 12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	private Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader) this.getClass()
				.getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker mediatracker = new MediaTracker(this);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (InterruptedException e) {
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}
		return image;
	}

	/*
	 * 事件处理
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) {// 查询
			if (tablename == "Assets") {
				ResultInfo result = new ResultInfo();
				result.resultAssetsID(jTextField.getText());
				this.dispose();
			} else if (tablename == "Person") {
				ResultInfo result = new ResultInfo();
				result.resultPersonID(jTextField.getText());
				this.dispose();
			}
		}

	}

}
