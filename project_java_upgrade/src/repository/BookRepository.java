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
	
	
	
	
	public static boolean realizarEmprestimo(String idUsuario, String isbn) {
	    Connection conn = null;
	    PreparedStatement pstSelectUser = null;
	    PreparedStatement pstSelectBook = null;
	    PreparedStatement pstInsertLoan = null;
	    PreparedStatement pstUpdateBook = null;
	    ResultSet rsUser = null;
	    ResultSet rsBook = null;

	    try {
	        conn = DB.getConnection();

	        // Verificar se o usuário existe
	        pstSelectUser = conn.prepareStatement("SELECT * FROM user WHERE ID_USER = ?");
	        pstSelectUser.setString(1, idUsuario);
	        rsUser = pstSelectUser.executeQuery();

	        if (!rsUser.next()) {
	            System.out.println("Usuário não encontrado.");
	            return false;
	        }

	        // Verificar se o livro existe e está disponível
	        pstSelectBook = conn.prepareStatement("SELECT * FROM book WHERE ISBN = ? AND AVAILABLE > 0");
	        pstSelectBook.setString(1, isbn);
	        rsBook = pstSelectBook.executeQuery();

	        if (!rsBook.next()) {
	            System.out.println("Livro não disponível ou não encontrado.");
	            return false;
	        }

	        // Registrar o empréstimo
	        pstInsertLoan = conn.prepareStatement(
	            "INSERT INTO borrow_books (ID_USER, ISBN, DATA_BORROW) VALUES (?, ?, NOW())"
	        );
	        pstInsertLoan.setString(1, idUsuario);
	        pstInsertLoan.setString(2, isbn);
	        pstInsertLoan.executeUpdate();

	        // Atualizar disponibilidade do livro
	        pstUpdateBook = conn.prepareStatement("UPDATE book SET AVAILABLE = AVAILABLE - 1 WHERE ISBN = ?");
	        pstUpdateBook.setString(1, isbn);
	        pstUpdateBook.executeUpdate();

	        System.out.println("Empréstimo realizado com sucesso!");
	        return true;
	    } catch (SQLException e) {
	        System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
	        return false;
	    } finally {
	        DB.closeResultSet(rsUser);
	        DB.closeResultSet(rsBook);
	        DB.closeStatement(pstSelectUser);
	        DB.closeStatement(pstSelectBook);
	        DB.closeStatement(pstInsertLoan);
	        DB.closeStatement(pstUpdateBook);
	    }
	}
	
	public static String buscarLivroPorISBN(String isbn) {
	    Connection conn = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    String detalhesLivro = null;

	    try {
	        conn = DB.getConnection();

	        st = conn.prepareStatement("SELECT * FROM book WHERE ISBN = ?");
	        st.setString(1, isbn);

	        rs = st.executeQuery();

	        if (rs.next()) {
	            detalhesLivro = rs.getString("TITLE") + ", " + rs.getString("AUTOR") + ", Disponibilidade: " + rs.getInt("AVAILABLE");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        DB.closeResultSet(rs);
	        DB.closeStatement(st);
	    }
	    return detalhesLivro;
	}


}
