package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class UserRepository {

	public static void UserInsert(String nome) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement("INSERT INTO user (nome) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

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
			DB.closeConnection();
		}
	}

}
