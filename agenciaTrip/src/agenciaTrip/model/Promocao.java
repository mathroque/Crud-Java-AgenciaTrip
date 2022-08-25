package agenciaTrip.model;

import java.sql.Date;

public class Promocao {

	private int id;
	private Date validade;
	private double percent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

}
