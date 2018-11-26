package com.yanjin.practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//ϵͳʱ�����󣬶�ȡ��ȫ��date�Ĵ��������ַ�����
	private static final String DBURL = "jdbc:mysql://localhost:3306/yj1?serverTimezone=GMT&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "xxwdbb58";
	
	public static void main(String[] args) throws Exception{
		String keyWord = "��";
		String sname = "Mir'Li";
		String bd = "2008-23-12";
		String gender = "��";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse(bd);
		
		//��һ�����������ݿ��������򣬴�ʱ����Ҫʵ��������Ϊ�������Լ��������
		Class.forName(DBDRIVER);
		//�ڶ������������ݿ�
		Connection con = DriverManager.getConnection(DBURL,USER,PASSWORD);
		//����Ƿ�������
		System.out.println(con);
		//���������������ݿ�,����statement
//		Statement sta = con.createStatement();
		//дsql���,�ڱ�дsql���ʱ�����̫����Ҫ���У���ôǰ��һ�����Ͽո�
		
		/*����*/
//		String sql ="insert into class (sname,gender,salary,birthday,login) values "
//				+ " (?,?,1390.22,?,'12:21:23')";
//		//ʵ�ʿ�������preparedstatement������statement
//		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setString(1, sname);
//		stmt.setString(2, gender);
//		stmt.setDate(3, new java.sql.Date(birthday.getTime()));
//		int i = stmt.executeUpdate(sql);
//		System.out.println("Ӱ��" + i + "��");
		
		/*��ѯ*/
//		String sql = "select sname,gender,birthday from class where sname like ?";
//		PreparedStatement stmt = con.prepareStatement(sql);
//		//ģ����ѯ�����ֱ�Ӱ�%��%�ŵ�sql�����дд�ᱨ��
//		stmt.setString(1, "%" + keyWord + "%");
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			/**��ʹ��getxxx()ȡ�������ݵ�ʱ��ǿ�ҽ��鰴�ո�����˳��ȡ
//			*ÿһ�е�����ֻ�ܹ�����˳��ȡһ��
//			*/
//			String msname = rs.getString("sname");
//			String mgender = rs.getString("gender");
//		 	Date mbirthday = rs.getDate("birthday");
//			//Ҳ��������Ų�ѯ�����ѯ����˳��һ��
////			String sname = rs.getString(1);
////			String gender = rs.getString(2);
////			Date birthday = rs.getDate(3);
//			System.out.println(msname + "��" + mgender + "��" + mbirthday + "��");
//		}
		
		/*������,������ע�⣺ֻ��ʹ��innodb����������Ż���Ч��*/
		Statement stm = con.createStatement();
		con.setAutoCommit(false);
		try {
			stm.addBatch("insert into class (sname) values ('����1')");
			stm.addBatch("insert into class (sname) values ('����2')");
			stm.addBatch("insert into class (sname) values ('����3')");
			int[] i = stm.executeBatch();
			System.out.println(i);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
		}
		//���Ĳ����ر����ݿ�
		con.close();
	}


}

