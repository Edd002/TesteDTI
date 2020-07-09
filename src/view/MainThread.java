package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import controller.Negocio;
import model.BanhoIdeal;

/**
 * @author Eduardo Augusto
 *
 * Classe MainThread.
 */
public class MainThread {

	public static void main(String[] args) {
		receberEntrada();
	}

	/**
	 * @author Eduardo Augusto
	 * @return void
	 * @param
	 * Método para receber a entrada do usuário.
	 */
	private static void receberEntrada() {
		Scanner scanner = new Scanner(System.in);
		String entrada;
		String erro = "";

		LocalDate data = null;
		int quantidadeCaesPequenos = 0;
		int quantidadeCaesGrandes = 0;

		while(true) {
			System.out.println("Informe a entrada"
					+ "(<data> <quantidade de cães pequenos> <quantidade cães grandes>)"
					+ "\nExemplo: 03/08/2018 3 5: ");
			entrada = scanner.nextLine();
			String[] entradaSplitted = entrada.split(" ");

			if (entradaSplitted.length != 3) {
				erro = "O formato informado não está de acordo com o solicitado.\n";
			} else {
				try {
					data = LocalDate.parse(entradaSplitted[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				} catch (DateTimeParseException dateTimeParseException) {
					erro += "A entrada para a data não está no formato indicado ou a data está incorreta.\n";
				} catch (Exception exception) {
					erro += "A entrada para a data não está no formato indicado ou a data está incorreta.\n";
				}

				try {
					quantidadeCaesPequenos = Integer.parseInt(entradaSplitted[1]);
					if (quantidadeCaesPequenos < 0)
						throw new IllegalArgumentException();
				} catch (NumberFormatException numberFormatException) {
					erro += "A entrada para o número de cães pequenos deve ser um número inteiro.\n";
				} catch (IllegalArgumentException illegalArgumentException) {
					erro += "A entrada para o número de cães pequenos não pode ser um número negativo.\n";
				}

				try {
					quantidadeCaesGrandes = Integer.parseInt(entradaSplitted[2]);
					if (quantidadeCaesGrandes < 0)
						throw new IllegalArgumentException();
				} catch (NumberFormatException numberFormatException) {
					erro += "A entrada para o número de cães grandes deve ser um número inteiro.\n";
				} catch (IllegalArgumentException illegalArgumentException) {
					erro += "A entrada para o número de cães grandes não pode ser um número negativo.\n";
				}
			}

			if (!erro.equals("")) {
				System.out.println(erro);
				erro = "";
			} else {
				break;
			}
		}

		gerarSaida(data, quantidadeCaesPequenos, quantidadeCaesGrandes);
		scanner.close();
	}

	/**
	 * @author Eduardo Augusto
	 * @return void
	 * @param
	 * Método para informar a saída para o usuário.
	 */
	private static void gerarSaida(LocalDate data, int quantidadeCaesPequenos, int quantidadeCaesGrandes) {
		BanhoIdeal banhoIdeal = Negocio.decidirBanhoIdeal(Negocio.ehDiaUtil(data), quantidadeCaesPequenos, quantidadeCaesGrandes);
		System.out.printf("\nMelhor canil: " + banhoIdeal.getPetshop().getNome() + "\nPreço total: R$%.2f", banhoIdeal.getPrecoTotalBanhos());
	}
}