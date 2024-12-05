package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;

import db.DB;

public class BookRepository {
	
	
	public static  void inserrirLivro(String titulo, String autor, String isbn) {
		PreparedStatement st = null;
		Connection conn= null;
		
		try{
			
			Connection conn = DB.getConnection();
			
			st = conn.prepareStatement(				
					"INSERT INTO book "
					+ "(titulo, autor, isbn) "
					+ "VALUES"
					+ "(?, ?, ?)");
					
					
					st.setString(1, titulo);
					st.setString(2, autor);
					st.setString(2, isbn);
		}
		catch(ParseException e) {
				e.printStackTrace();
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
	}
}
