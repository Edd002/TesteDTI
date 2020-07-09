package controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.BanhoIdeal;
import model.Petshop;

/**
 * @author Eduardo Augusto
 *
 * Classe Negocio.
 */
public class Negocio {

	private static final Petshop PETSHOP_MEU_CANINO_FELIZ = new Petshop(1, "Meu Canino Feliz", 20.0f, 20.0f * 1.2f, 40.0f, 40.f * 1.2f, 2.0f);
	private static final Petshop PETSHOP_VAI_REX = new Petshop(2, "Vai Rex", 15.0f, 20.0f, 50.0f, 55.0f, 1.7f);
	private static final Petshop PETSHOP_CHOWCHAWGAS = new Petshop(3, "ChowChawgas", 30.0f, 30.0f, 45.0f, 45.0f, 0.8f);

	/**
	 * @author Eduardo Augusto
	 * @return BanhoIdeal
	 * @param boolean, int, int
	 * Método para dicidir qual petshop proporciona o menor preço.
	 * Parâmetro: dia útil, quantidade de caes pequenos e quantidade de cães grandes.
	 */
	public static BanhoIdeal decidirBanhoIdeal(boolean diaUtil, int quantidadeCaesPequenos, int quantidadeCaesGrandes) {
		HashMap<Petshop, Float> hashMapPrecosTotais = new HashMap<Petshop, Float>();

		// Definir um hash definindo o objeto petshop como key e o preço total como value, cálculado de acordo com o dia da semana (dia útil ou fim de semana)
		if (diaUtil) {
			hashMapPrecosTotais.put(PETSHOP_MEU_CANINO_FELIZ, (PETSHOP_MEU_CANINO_FELIZ.getPrecoBanhoCaoPequenoDiaUtil() * quantidadeCaesPequenos) + (PETSHOP_MEU_CANINO_FELIZ.getPrecoBanhoCaoGrandeDiaUtil() * quantidadeCaesGrandes));
			hashMapPrecosTotais.put(PETSHOP_VAI_REX, (PETSHOP_VAI_REX.getPrecoBanhoCaoPequenoDiaUtil() * quantidadeCaesPequenos) + (PETSHOP_VAI_REX.getPrecoBanhoCaoGrandeDiaUtil() * quantidadeCaesGrandes));
			hashMapPrecosTotais.put(PETSHOP_CHOWCHAWGAS, (PETSHOP_CHOWCHAWGAS.getPrecoBanhoCaoPequenoDiaUtil() * quantidadeCaesPequenos) + (PETSHOP_CHOWCHAWGAS.getPrecoBanhoCaoGrandeDiaUtil() * quantidadeCaesGrandes));
		} else {
			hashMapPrecosTotais.put(PETSHOP_MEU_CANINO_FELIZ, (PETSHOP_MEU_CANINO_FELIZ.getPrecoBanhoCaoPequenoFimSemana() * quantidadeCaesPequenos) + (PETSHOP_MEU_CANINO_FELIZ.getPrecoBanhoCaoGrandeFimSemana() * quantidadeCaesGrandes));
			hashMapPrecosTotais.put(PETSHOP_VAI_REX, (PETSHOP_VAI_REX.getPrecoBanhoCaoPequenoFimSemana() * quantidadeCaesPequenos) + (PETSHOP_VAI_REX.getPrecoBanhoCaoGrandeFimSemana() * quantidadeCaesGrandes));
			hashMapPrecosTotais.put(PETSHOP_CHOWCHAWGAS, (PETSHOP_CHOWCHAWGAS.getPrecoBanhoCaoPequenoFimSemana() * quantidadeCaesPequenos) + (PETSHOP_CHOWCHAWGAS.getPrecoBanhoCaoGrandeFimSemana() * quantidadeCaesGrandes));
		}

		Float menorPreco = hashMapPrecosTotais.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
		Petshop petshopIdeal = hashMapPrecosTotais.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();

		// Verificar se existe algum outro preço igual ao menor preço estipulado para verificar pela distâcia
		if (Collections.frequency(hashMapPrecosTotais.values(), menorPreco) > 1) {

			Set<Object> set = new HashSet<>();
			List<Object> list = new ArrayList<>();

			for (Entry<Petshop, Float> mapVal : hashMapPrecosTotais.entrySet())
				if(!set.add(mapVal.getValue()))
					list.add(mapVal.getValue());
				else
					set.add(mapVal.getValue());

			// Se a distância for menor e o preço for igual definir um novo petshop ideal
			for (Entry<Petshop, Float> mapVal : hashMapPrecosTotais.entrySet())
				if (list.contains(mapVal.getValue()))
					if (mapVal.getKey().getDistanciaCanil() < petshopIdeal.getDistanciaCanil() && mapVal.getValue().equals(menorPreco))
						petshopIdeal = mapVal.getKey();
		}

		// Retornar BanhoIdeal
		return new BanhoIdeal(0, quantidadeCaesPequenos, quantidadeCaesGrandes, petshopIdeal, menorPreco, diaUtil);
	}

	/**
	 * @author Eduardo Augusto
	 * @return boolean
	 * @param LocalDate
	 * Método para verificar se o dia é ou não sábado ou domingo (fim de semana).
	 * Parâmetro: data informada.
	 */
	public static boolean ehDiaUtil(LocalDate localDate) {
		return !localDate.getDayOfWeek().equals(DayOfWeek.of(6)) && !localDate.getDayOfWeek().equals(DayOfWeek.of(7));
	}
}