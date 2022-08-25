package agenciaTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agenciaTrip.model.Usuario;
import agenciaTrip.model.factory.ConnectionFactory;

public class UsuarioDAO {

	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuario (nome_user, email_user, senha_user, dataCadastro_user) VALUES (?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setDate(4, usuario.getDataCadastro());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";
		List<Usuario> users = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario user = new Usuario();

				// Setar dados do objeto user para em seguida adicioná-lo ao ArrayList.
				user.setId(rset.getInt("id_user"));
				user.setNome(rset.getString("nome_user"));
				user.setEmail(rset.getString("email_user"));
				user.setDataCadastro(rset.getDate("dataCadastro_user"));

				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
				if (rset != null)
					rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public void update(Usuario usuario) {

		String sql = "UPDATE usuario SET nome_user = ?, email_user = ?, senha_user = ? " + "WHERE id_user = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setInt(4, usuario.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteByID(int id) {

		String sql = "DELETE FROM usuario WHERE id_user = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
