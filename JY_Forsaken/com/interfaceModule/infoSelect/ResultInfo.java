package com.interfaceModule.infoSelect;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.*;

import com.dataOperate.AssetsBean;
import com.dataOperate.AssetsTrjnBean;
import com.dataOperate.PersonBean;

public class ResultInfo extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1;
	JTable jTable;

	String sNum;
	String[][] colValue;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;
	String tableID;

	/**
	 * 返回Assets表所有的记录
	 */
	public void resultAssetsAll() {
		this.setTitle("信息查询结果");
		// 设置程序图标
		this.setIconImage(getImage("image/smile.png"));
		// 设置运行时临时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "设备编号", "设备名称", "分配信息", "型号", "价格", "购买日期", "状态",
				"备注" };
		AssetsBean bean = new AssetsBean();
		try {

			colValue = bean.searchAll();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "木有符合条件的记录啊");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回Assets表特定ID记录
	 */
	public void resultAssetsID(String ID) {
		this.tableID = ID;
		this.setTitle("信息查询结果");
		this.setIconImage(getImage("image/android.png"));
		// 设置运行位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);
		String[] colName = { "设备编号", "设备名称", "分配信息", "型号", "价格", "购买日期", "状态",
				"备注" };
		AssetsBean bean = new AssetsBean();
		try {
			colValue = bean.searchAll(tableID);
			if (colValue == null) {
				this.dispose();
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");

			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 返回Person表的所有记录
	 */
	public void resultPersonAll() {
		this.setTitle("信息查询结果");
		// 设置框架大小
		this.setSize(new Dimension(1500, 450));
		this.setIconImage(getImage("image/android.png"));
		// 设置运行位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "人员编号", "姓名", "性别", "部门", "职位", "其他" };
		PersonBean bean = new PersonBean();
		try {
			colValue = bean.searchAll();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "木有符合条件的呐~");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回Person表特定ID记录
	 */
	public void resultPersonID(String ID) {
		this.tableID = ID;

		this.setTitle("信息查询结果");
		this.setIconImage(getImage("image/android.png"));
		// 设置运行时临时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "人员编号", "姓名", "性别", "职位", "其他" };
		PersonBean bean = new PersonBean();
		try {
			colValue = bean.searchAll(tableID);
			if (colValue == null) {
				this.dispose();
				JOptionPane.showMessageDialog(null, "木有这个记录呐~");

			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 返回设备借用的所有记录
	 */
	public void resultUseAll() {
		this.setTitle("信息查询结果");
		// 设置框架大小
		this.setSize(new Dimension(1000, 450));
		this.setIconImage(getImage("image/android.png"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "编号", "设备名称", "操作时间", "领用人", "用途", "备注" };

		AssetsTrjnBean bean = new AssetsTrjnBean();

		try {
			colValue = bean.searchAllForUse();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "木有这个记录呐");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.setVisible(true);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * 返回设备归还的所有记录
	 */
	public void resultBackAll() {
		this.setTitle("信息查询结果");
		// 设置框架大小
		this.setSize(new Dimension(1000, 450));
		this.setIconImage(getImage("image/android.png"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "编号", "设备名称", "操作时间", "领用人", "用途", "备注" };

		AssetsTrjnBean bean = new AssetsTrjnBean();
		try {

			colValue = bean.searchAllForBack();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "木有这条记录呐~");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 返回设备报废的所有记录
	 */
	public void resultInvalidAll() {

		this.setTitle("信息查询结果");
		// 设置框架大小
		this.setSize(new Dimension(1500, 450));
		this.setIconImage(getImage("image/android.png"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "编号", "设备名称", "操作时间", "领用人", "用途", "备注" };
		AssetsTrjnBean bean = new AssetsTrjnBean();
		try {
			colValue = bean.searchAllForInvalid();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "木有这记录呐~");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

}
