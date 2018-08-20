package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Dto;

public class Dao {

	private String content;
	private int year;
	private int month;
	private int day;
	private int judgment;
	private int money;
	public static ArrayList<Dto> searchAll(){
		ArrayList<Dto> list = new ArrayList<Dto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/shushi?useSSL=false",
					"root",
					"12345");

			String sql = "SELECT * FROM shushi";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();


			while(rs.next() == true ){
				int id = rs.getInt("id");
				String content = rs.getString("content");
				int year = rs.getInt("yesr");
				int month = rs.getInt("month");
				int day = rs.getInt("day");
				int judgment = rs.getInt("judgment");
				int money = rs.getInt("money");
				list.add(new Dto(content, id, year, month, day, judgment, money));
			}
		}
		catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}


		return list;
	}

	public void insert(String content, int year, int month, int day, int judgment, int money) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/shushi?useSSL=false",
					"root",
					"12345");

			String sql = "INSERT INTO shushi VALUE(null,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			this.content = content;
			this.year = year;
			this.month = month;
			this.day = day;
			this.judgment = judgment;
			this.money = money;
			pstmt.setString(1, this.content);
			pstmt.setInt(2, this.year);
			pstmt.setInt(3, this.month);
			pstmt.setInt(4, this.day);
			pstmt.setInt(5, this.judgment);
			pstmt.setInt(6, this.money);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();

		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (Exception e){
			System.out.println("データを入力してください。");
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public void search() {

	}
}
