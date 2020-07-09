package model;

/**
 * @author Eduardo Augusto
 *
 * Classe BanhoIdeal.
 */
public class BanhoIdeal {

	private int id;
	private int quantidadeCaesPequenos;
	private int quantidadeCaesGrandes;
	private Petshop petshop;
	private float precoTotalBanhos;
	private boolean diaUtil;

	public BanhoIdeal(int id, int quantidadeCaesPequenos, int quantidadeCaesGrandes, Petshop petshop, float precoTotalBanhos, boolean diaUtil) {
		this.id = id;
		this.quantidadeCaesPequenos = quantidadeCaesPequenos;
		this.quantidadeCaesGrandes = quantidadeCaesGrandes;
		this.petshop = petshop;
		this.precoTotalBanhos = precoTotalBanhos;
		this.diaUtil = diaUtil;
	}

	public int getId() {
		return id;
	}
	public int getQuantidadeCaesPequenos() {
		return quantidadeCaesPequenos;
	}
	public int getQuantidadeCaesGrandes() {
		return quantidadeCaesGrandes;
	}
	public Petshop getPetshop() {
		return petshop;
	}
	public float getPrecoTotalBanhos() {
		return precoTotalBanhos;
	}
	public boolean isDiaUtil() {
		return diaUtil;
	}

	@Override
	public String toString() {
		return "Banho [id=" + id + ", quantidadeCaesPequenos=" + quantidadeCaesPequenos + ", quantidadeCaesGrandes="
				+ quantidadeCaesGrandes + ", petshop=" + petshop + ", precoTotalBanhos=" + precoTotalBanhos
				+ ", diaUtil=" + diaUtil + "]";
	}
}