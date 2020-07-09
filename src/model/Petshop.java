package model;

/**
 * @author Eduardo Augusto
 *
 * Classe Petshop.
 */
public class Petshop {

	private int id;
	private String nome;
	private float precoBanhoCaoPequenoDiaUtil;
	private float precoBanhoCaoPequenoFimSemana;
	private float precoBanhoCaoGrandeDiaUtil;
	private float precoBanhoCaoGrandeFimSemana;
	private float distanciaCanil;

	public Petshop() {
	}

	public Petshop(int id, String nome, float precoBanhoCaoPequenoDiaUtil, float precoBanhoCaoPequenoFimSemana, float precoBanhoCaoGrandeDiaUtil, float precoBanhoCaoGrandeFimSemana, float distanciaCanil) {
		this.id = id;
		this.nome = nome;
		this.precoBanhoCaoPequenoDiaUtil = precoBanhoCaoPequenoDiaUtil;
		this.precoBanhoCaoPequenoFimSemana = precoBanhoCaoPequenoFimSemana;
		this.precoBanhoCaoGrandeDiaUtil = precoBanhoCaoGrandeDiaUtil;
		this.precoBanhoCaoGrandeFimSemana = precoBanhoCaoGrandeFimSemana;
		this.distanciaCanil = distanciaCanil;
	}

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public float getPrecoBanhoCaoPequenoDiaUtil() {
		return precoBanhoCaoPequenoDiaUtil;
	}
	public float getPrecoBanhoCaoPequenoFimSemana() {
		return precoBanhoCaoPequenoFimSemana;
	}
	public float getPrecoBanhoCaoGrandeDiaUtil() {
		return precoBanhoCaoGrandeDiaUtil;
	}
	public float getPrecoBanhoCaoGrandeFimSemana() {
		return precoBanhoCaoGrandeFimSemana;
	}
	public float getDistanciaCanil() {
		return distanciaCanil;
	}

	@Override
	public String toString() {
		return "Petshop [id=" + id + ", nome=" + nome + ", precoBanhoCaoPequenoDiaUtil=" + precoBanhoCaoPequenoDiaUtil
				+ ", precoBanhoCaoPequenoFimSemana=" + precoBanhoCaoPequenoFimSemana + ", precoBanhoCaoGrandeDiaUtil="
				+ precoBanhoCaoGrandeDiaUtil + ", precoBanhoCaoGrandeFimSemana=" + precoBanhoCaoGrandeFimSemana
				+ ", distanciaCanil=" + distanciaCanil + "]";
	}
}