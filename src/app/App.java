package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Restaurante;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int opcao = 0;
		boolean votacaoEncerrada = false;

		Restaurante primeiro = new Restaurante("Amado", 0, false);
		Restaurante segundo = new Restaurante("Paraiso tropical", 0, false);
		Restaurante terceiro = new Restaurante("Soro", 0, false);
		Restaurante quarto = new Restaurante("Tijuana", 0, false);
		Restaurante quinto = new Restaurante("Cocobambu", 0, false);
		Restaurante sexto = new Restaurante("Rua 15", 0, false);
		Restaurante setimo = new Restaurante("Marlin pescador", 0, false);

		List<Restaurante> restaurantes = new ArrayList<Restaurante>();

		restaurantes.add(primeiro);
		restaurantes.add(segundo);
		restaurantes.add(terceiro);
		restaurantes.add(quarto);
		restaurantes.add(quinto);
		restaurantes.add(sexto);
		restaurantes.add(setimo);

		Scanner scanner = new Scanner(System.in);

		while (opcao != 5) {

			System.out.println(
					"O que deseja fazer? \n \n1 - Votar\n2 - Resultado parcial\n3 - Encerrar votação\n4 - Nova votação\n5 - Sair");

			opcao = scanner.nextInt();

			switch (opcao) {

			case 1:
				if (votacaoEncerrada) {
					System.out.println("Votação de hoje finalizada. Tente amanhã \n");
				} else {

					int voto = 0;
					ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

					System.out.println("Selecione um restaurante da nossa rede:");
					for (Restaurante restaurante : restaurantes) {

						if (!restaurante.getEscolhido()) {
							listaRestaurantes.add(restaurante);
						} else {
							System.out.println("Não é possivel mais votar.");
						}
					}

					restaurantes = (List<Restaurante>) listaRestaurantes.clone();

					for (int contador = 0; contador <= restaurantes.size() - 1; contador++) {

						System.out.println(Integer.toString(++contador) + " - "
								+ restaurantes.get(--contador).getNome());
					}

					voto = scanner.nextInt();

					if (voto > 5 || voto < 1) {
						System.out.println("Digite uma opção de restaurante válida.");
						continue;
					}
					restaurantes.get(--voto).votar();
				}

				break;

			case 2:
				Restaurante parcial = new Restaurante();
				parcial.apurar(restaurantes, false);

				break;

			case 3:
				Restaurante encerrado = new Restaurante();
				encerrado.apurar(restaurantes, true);
				votacaoEncerrada = true;

				break;

			case 4:
				votacaoEncerrada = false;

			case 5:
				System.out.println("Até mais! \n");
				break;

			default:

				System.out.println("Digite uma opção válida.");
			}
		}
	}
}
