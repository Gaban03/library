package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import db.DB;

public class BookRepository {
	
	
	public static  void inserirLivro(String titulo, String autor, String isbn) {
		Connection conn= null;
		
		PreparedStatement st = null;
		
		try{
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement("INSERT INTO book (TITLE, AUTOR, ISBN) VALUES (?, ?, ?)");
			
			st.setString(1, titulo);
			st.setString(2, autor);
			st.setString(3, isbn);
			
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
	}
	
	
	public static void selectLivro() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM book");
			
			while (rs.next()) {
				System.out.println(rs.getString("ISBN") + ", " + rs.getString("TITLE") + ", " + rs.getString("AUTOR") + ", " + rs.getInt("AVAILABLE"));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
