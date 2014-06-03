package com.dataOperate;

import java.sql.*;

import javax.swing.JOptionPane;

public class Database {
	private Statement stmt = null;
	ResultSet rs = null;
	private Connection conn = null;
	String sql;
	String driver = "com.mysql.jdbc.Driver";
	String strurl = "jdbc:mysql://127.0.0.1:3306/equipment";
	String user = "root";
	 String password = "liuxiaoyi123";

//	String password = "sys406";

	public Database() {

	}

	/**
	 * �򿪳����ݿ�����
	 */
	public void OpenConn() throws Exception {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(strurl, user, password);
		} catch (Exception e) {
			System.err.println("OpenConn:" + e.getMessage());
		}
	}

	/**
	 * ִ��sql��䣬���ؽ����rs
	 */
	public ResultSet executeQuery(String sql) {
		stmt = null;
		rs = null;
//		System.out.println(sql);
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
//			System.err.println("executeQuery:" + e.getMessage());
//			JOptionPane.showMessageDialog(null,"��Ŷ�����������","����",JOptionPane.ERROR_MESSAGE);
		}
		return rs;

	}

	/**
	 * ִ��SQL���
	 */
	public void executeUpdate(String sql) {
		stmt = null;
		rs = null;
//		System.out.println(sql);
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			conn.setAutoCommit(false);
			conn.commit();
		} catch (SQLException e) {
//			System.err.println("executeUpdate:" + e.getMessage());
//			JOptionPane.showMessageDialog(null, "��Ŷ������ʧ����","����",JOptionPane.ERROR_MESSAGE);
		}

	}

	public void closeStmt() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.err.println("closeStmt:" + e.getMessage());
		}
	}

	/**
	 * �ر���������
	 */
	public void closeConn() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("aq.closeConn:" + e.getMessage());
		}
	}

	public static String toGBK(String str) {
		try {
			if (str == null) {
				str = "";
			} else
				str = new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;

	}

}