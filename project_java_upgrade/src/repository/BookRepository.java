package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			DB.closeStatement(st);
		}
	}
	
	
	public static ArrayList<String> selectLivro() {
		
		ArrayList<String> book = new ArrayList<String>();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM book");
			
			while (rs.next()) {
				String dadosBook = rs.getString("ISBN") + ", " + rs.getString("TITLE") + ", " + rs.getString("AUTOR") + ", " + rs.getInt("AVAILABLE");
				book.add(dadosBook);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return book;
	}
}
