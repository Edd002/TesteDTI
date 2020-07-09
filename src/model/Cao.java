package model;

/**
 * @author Eduardo Augusto
 *
 * Classe abstrata Cao.
 */
public abstract class Cao {

	private int id;
	private String raca;

	public Cao() {
	}

	public Cao(int id, String raca) {
		this.id = id;
		this.raca = raca;
	}

	public int getId() {
		return id;
	}
	public String getRaca() {
		return raca;
	}

	@Override
	public String toString() {
		return "Cao [id=" + id + ", raca=" + raca + "]";
	}
}