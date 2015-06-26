package com.data.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.msg.util.DB;


public class DataGenerator {
	public static void main( String[] args) {
//		saveBatchUser();
//		Time[] ts = Time.values();
//		System.out.println(ts[0].ordinal() + "  " + ts[0].name() + " "+ts[0].date);
		saveBatchStatus();
	}
	
	public  static void saveBatchUser() {
		int row = 0;
		Connection conn = DB.getConn();
		try {
			String sql = "insert into user values(null,?,?,?,? , default ,default)";
			PreparedStatement ps = conn.prepareStatement(sql);
			Random random = new Random();
			for (int i = 0; i < 20; i++) {
				ps.setString(1, "admin" + i);
				ps.setString(2, "admin" + i + "@qq.com");
				ps.setString(3, "admin" + i);
				ps.setString(4, "head.jpg");
				ps.addBatch();
			}
			int[] rows = ps.executeBatch();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	id                   int not null auto_increment,
//	   user_id              int,
//	   create_time          datetime default CURRENT_TIMESTAMP,
//	   views                int default 0,
//	   content              varchar(500) not null,
//	   praises              int,
//	   friend_id
	public static void saveBatchStatus() {
		int row = 0;
		Connection conn = DB.getConn();
		Time[] times = Time.values();
		try {
			String sql = "insert into status values(null,?,?,?,? , ? ,null)";
			PreparedStatement ps = conn.prepareStatement(sql);
			Random random = new Random();
			for (int i = 1; i <= 50; i++) {
				int userId = random.nextInt(27);
				int dt = random.nextInt(8);
				if(userId < 10 || dt < 1) continue;
				ps.setInt(1, userId);
				ps.setTimestamp(2, times[dt].date);
				ps.setInt(3, random.nextInt(10));
				
				ps.setString(4,"�������ܺ�  " + i);
				ps.setInt(5, random.nextInt(10));
				
				ps.addBatch();
			}
			int[] rows = ps.executeBatch();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static enum Time {
		DATE1("2016-6-26 13:14:10"),
		DATE2("2016-6-26 12:55:50"),
		DATE3("2016-6-26 14:34:20"),
		DATE4("2016-6-26 15:44:50"),
		DATE5("2016-6-26 16:38:35"),
		DATE6("2016-5-26 17:18:14"),
		DATE7("2016-6-25 18:52:22"),
		DATE9("2016-6-24 09:45:12"),
		DATE8("2016-6-23 10:52:22");
		
		private Timestamp date;
		
		Time(String date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = null;
			try {
				d = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(d);
			this.date = new Timestamp(d.getTime());
		}
	}
	
}