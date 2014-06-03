package com.interfaceModule.person;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.dataOperate.PersonBean;

/**
 * @author LGM_C4 ������Ա��Ų�ѯ���Թ��������޸Ļ�ɾ��
 * 
 */
public class ModifyPersonSearch extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	Container contentPane;
	String[] s;
	// ��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectID;
	JButton searchInfo = new JButton();

	public ModifyPersonSearch(JFrame frame) {
		super(frame, true);
		this.setTitle("��Ա��Ų�ѯ");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();

		}

		// ��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				(int) (screenSize.height - 300) / 2 + 45);
	}

	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("���������ѡ����Ա��ţ�");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jLabel1);

		PersonBean getId = new PersonBean();
		s = getId.getAllId();

		selectID = new JComboBox(s);

		selectID.setEditable(true);
		selectID.setFont(new Font("Dialog", 0, 12));
		contentPane.add(selectID);

		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog", 0, 12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * ����ѡ����
	 */
	public String getID() {
		return (String) this.selectID.getSelectedItem();
	}

	/*
	 * �¼�����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectID) {// �˳�
			this.dispose();
		} else if (obj == searchInfo) {// �޸�
			this.dispose();
		}

	}

}