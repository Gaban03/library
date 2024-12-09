package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;

public class UserRepository {

	public static void UserInsert(String nome) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement("INSERT INTO user (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, nome);

			int registros = st.executeUpdate();

			if (registros > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Finalizado! Tabela usuario atualizada! ID = " + id);
				}
			} else {
				System.out.println("Nenhum registro na tabela de usuario alterado!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}
	
	public static ArrayList<String> UserSelect() {
		
		ArrayList<String> user = new ArrayList<String>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM user");
			
			while (rs.next()) {
				String dadosUser = rs.getString("ID_USER") + ", " + rs.getString("NAME");
				user.add(dadosUser);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao selecionar usuarios: " + e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return user;
	}
	
}
