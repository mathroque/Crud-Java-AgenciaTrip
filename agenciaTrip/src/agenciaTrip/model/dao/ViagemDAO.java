package agenciaTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import agenciaTrip.model.Viagem;
import agenciaTrip.model.factory.ConnectionFactory;

public class ViagemDAO {

	public void save(Viagem viagem) {
		
		String sql = null;
		if (viagem.getId_promo() > 0) {
			sql = "INSERT INTO viagem_cadastro (origem_viagem, destino_viagem, ida_viagem, volta_viagem, fk_id_user, fk_id_promocao) VALUES (?, ?, ?, ?, ?, ?)";
		} else
			sql = "INSERT INTO viagem_cadastro (origem_viagem, destino_viagem, ida_viagem, volta_viagem, fk_id_user) VALUES (?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, viagem.getOrigem());
			pstm.setString(2, viagem.getDestino());
			pstm.setDate(3, viagem.getIda());
			pstm.setDate(4, viagem.getVolta());
			pstm.setInt(5, viagem.getId_user());
			if (viagem.getId_promo() > 0)
				pstm.setInt(6, viagem.getId_promo());
				
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

	public List<Viagem> getViagens() {

		String sql = "SELECT * FROM viagem_cadastro";
		List<Viagem> viagens = new ArrayList<Viagem>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();

				// Setar dados do objeto user para em seguida adicioná-lo ao ArrayList.
				viagem.setId(rset.getInt("id_viagem"));
				viagem.setOrigem(rset.getString("origem_viagem"));
				viagem.setDestino(rset.getString("destino_viagem"));
				viagem.setIda(rset.getDate("ida_viagem"));
				viagem.setVolta(rset.getDate("volta_viagem"));
				viagem.setId_user(rset.getInt("fk_id_user"));
				viagem.setId_promo(rset.getInt("fk_id_promocao"));

				viagens.add(viagem);
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
		return viagens;
	}

	public void update(Viagem viagem) {

		String sql = "UPDATE viagem_cadastro SET origem_viagem = ?, destino_viagem = ?, ida_viagem = ?, volta_viagem = ?, fk_id_user = ?, fk_id_promocao = ? " + "WHERE id_viagem = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, viagem.getOrigem());
			pstm.setString(2, viagem.getDestino());
			pstm.setDate(3, viagem.getIda());
			pstm.setDate(4, viagem.getVolta());
			pstm.setInt(5, viagem.getId_user());
			pstm.setInt(6, viagem.getId_promo());
			pstm.setInt(7, viagem.getId());

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

		String sql = "DELETE FROM viagem_cadastro WHERE id_viagem = ?";
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
