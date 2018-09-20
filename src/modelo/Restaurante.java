package modelo;

import java.util.List;

public class Restaurante implements Votavel {

	private int votos = 0;

	private String nome = "";

	private boolean escolhido = false;

	public void votar() {
		this.votos += 1;
		System.out.println("Restaurante escolhido com sucesso!");
	}

	/* Itera sobre a lista de restaurantes para contar os votos de cada */
	public void apurar(List<Restaurante> restaurantes, boolean encerrado) {
		Restaurante restaurante = new Restaurante();

		for (int contador = 1; contador < restaurantes.size(); contador++) {

			restaurante = restaurantes.get(contador);
			int auxiliar = contador;

			while (auxiliar > 0 && restaurantes.get(auxiliar - 1).getVotos() < restaurante.getVotos()) {
				restaurantes.set(auxiliar, restaurantes.get(auxiliar - 1));
				auxiliar--;
			}

			restaurantes.set(auxiliar, restaurante);
		}

		if (encerrado) {

			int maxVotos = restaurantes.get(0).getVotos();

			for (int contador = 0; contador < restaurantes.size(); contador++) {

				if (restaurantes.get(contador).getVotos() == maxVotos) {
					restaurantes.get(contador).setEscolhido();
				}
			}

			System.out.println("Votação encerrada!");
		} else {

			System.out.println("Resultado da votação: \n");

			restaurantes.forEach(restauranteEscolhido -> {
				System.out.println(restauranteEscolhido.getNome() + " - "
						+ Integer.toString(restauranteEscolhido.getVotos()) + " votos.");
			});
		}
	}

	public Restaurante(String nome, int votos, boolean escolhido) {
		this.nome = nome;
		this.votos = votos;
		this.escolhido = escolhido;
	}

	public Restaurante() {
	}

	public String getNome() {
		return this.nome;
	}

	public int getVotos() {
		return this.votos;
	}

	public void setEscolhido() {
		this.escolhido = true;
	}

	public boolean getEscolhido() {
		return this.escolhido;
	}
}
