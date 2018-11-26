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
	//系统时区错误，读取到全零date的处理，中文字符编码
	private static final String DBURL = "jdbc:mysql://localhost:3306/yj1?serverTimezone=GMT&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "xxwdbb58";
	
	public static void main(String[] args) throws Exception{
		String keyWord = "李";
		String sname = "Mir'Li";
		String bd = "2008-23-12";
		String gender = "男";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse(bd);
		
		//第一步：加载数据库驱动程序，此时不需要实例化，因为容器会自己负责管理
		Class.forName(DBDRIVER);
		//第二步：连接数据库
		Connection con = DriverManager.getConnection(DBURL,USER,PASSWORD);
		//检测是否连接上
		System.out.println(con);
		//第三步：操作数据库,不用statement
//		Statement sta = con.createStatement();
		//写sql语句,在编写sql语句时，如果太长需要换行，那么前后一定加上空格
		
		/*插入*/
//		String sql ="insert into class (sname,gender,salary,birthday,login) values "
//				+ " (?,?,1390.22,?,'12:21:23')";
//		//实际开发都用preparedstatement，不用statement
//		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setString(1, sname);
//		stmt.setString(2, gender);
//		stmt.setDate(3, new java.sql.Date(birthday.getTime()));
//		int i = stmt.executeUpdate(sql);
//		System.out.println("影响" + i + "行");
		
		/*查询*/
//		String sql = "select sname,gender,birthday from class where sname like ?";
//		PreparedStatement stmt = con.prepareStatement(sql);
//		//模糊查询，如果直接把%李%放到sql语句中写写会报错
//		stmt.setString(1, "%" + keyWord + "%");
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			/**在使用getxxx()取出列数据的时候，强烈建议按照给定的顺序取
//			*每一列的数据只能够按照顺序取一次
//			*/
//			String msname = rs.getString("sname");
//			String mgender = rs.getString("gender");
//		 	Date mbirthday = rs.getDate("birthday");
//			//也可以用序号查询，与查询语句的顺序一致
////			String sname = rs.getString(1);
////			String gender = rs.getString(2);
////			Date birthday = rs.getDate(3);
//			System.out.println(msname + "，" + mgender + "，" + mbirthday + "，");
//		}
		
		/*批处理,事务处理（注意：只有使用innodb引擎事务处理才会生效）*/
		Statement stm = con.createStatement();
		con.setAutoCommit(false);
		try {
			stm.addBatch("insert into class (sname) values ('测试1')");
			stm.addBatch("insert into class (sname) values ('测试2')");
			stm.addBatch("insert into class (sname) values ('测试3')");
			int[] i = stm.executeBatch();
			System.out.println(i);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
		}
		//第四步：关闭数据库
		con.close();
	}


}

