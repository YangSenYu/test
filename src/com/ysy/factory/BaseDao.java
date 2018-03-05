package com.ysy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:PC-20180110CUQS:1521/orcl";
	private static String user="TEST_TABLE";
	private static String pwd="admin";
	//��ȡ����
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			System.out.println("��ȡ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//ִ����ɾ�Ĳ���
	public static int update(String sql,Object[] obj){
		Connection conn=null;
		PreparedStatement pst=null;
		int rs=0;
		try {
			conn=getConnection();
			pst=conn.prepareStatement(sql);
			setParamter(pst, obj);
			rs=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	//��ѯ
	public static List<Map<String,Object>> query(String sql,Object[] obj){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Map<String, Object>> rslist=new ArrayList<Map<String,Object>>();
		try {
			conn=getConnection();
			pst=conn.prepareStatement(sql);
			setParamter(pst, obj);
			rs=pst.executeQuery();
			ResultSetMetaData md=rs.getMetaData();
			int columnNums=md.getColumnCount();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String, Object>();
				for(int i=1;i<=columnNums;i++){
					Object columnValue=rs.getObject(i);
					String columnName=md.getColumnName(i);
					map.put(columnName, columnValue);
				}
				rslist.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(conn,pst,rs);
		}
		return rslist;
	}
	//���ò���
	public static void setParamter(PreparedStatement pst,Object[] obj){
		if(null!=obj){
			for(int i=0;i<obj.length;i++){
				try {
					pst.setObject(i+1, obj[i]);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	//�ر�����
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		try {
			if(null!=rs){
				rs.close();
			}
			if(null!=st){
				st.close();
			}
			if(null!=conn){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeAll(Connection conn,PreparedStatement pst,ResultSet rs){
		try {
			if(null!=rs){
				rs.close();
			}
			if(null!=pst){
				pst.close();
			}
			if(null!=conn){
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
