package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {

	private String content;
	private int year, month, day, judgment, money;

	public void insert(String content, int year, int month, int day, int judgment, int money) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/library?useSSL=false",
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
