package agenciaTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import agenciaTrip.model.Promocao;
import agenciaTrip.model.factory.ConnectionFactory;

public class PromocaoDAO {
	
	public void save(Promocao promocao) {
		
		String sql = "INSERT INTO promocao (validade_promocao, percent_promocao) VALUES (?, ?)";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setDate(1, promocao.getValidade());
			pstm.setDouble(2, promocao.getPercent());

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
	
	public List<Promocao> getPromocoes() {

		String sql = "SELECT * FROM promocao";
		List<Promocao> promos = new ArrayList<Promocao>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Promocao promo = new Promocao();

				// Setar dados do objeto user para em seguida adicioná-lo ao ArrayList.
				promo.setId(rset.getInt("id_promocao"));
				promo.setValidade(rset.getDate("validade_promocao"));
				promo.setPercent(rset.getDouble("percent_promocao"));

				promos.add(promo);
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
		return promos;
	}
	
	public void update(Promocao promocao) {

		String sql = "UPDATE promocao SET validade_promocao = ?, percent_promocao = ? " + "WHERE id_promocao = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setDate(1, promocao.getValidade());
			pstm.setDouble(2, promocao.getPercent());
			pstm.setInt(3, promocao.getId());

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

		String sql = "DELETE FROM promocao WHERE id_promocao = ?";
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







