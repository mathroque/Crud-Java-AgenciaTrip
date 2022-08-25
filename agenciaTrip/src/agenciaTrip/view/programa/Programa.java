package agenciaTrip.view.programa;

import java.util.Scanner;

import agenciaTrip.controller.Controles;

public class Programa {

	public static void main(String[] args) {

		Controles controlador = new Controles();
		Scanner scan = new Scanner(System.in);
		int menu1;
		int menu2;

		System.out.println();
		System.out.println("-------------------- Bem-vindo(a) ao sistema CRUD da Trip Agência! --------------------");
		System.out.println();

		do {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Usuários \n2 - Viagens \n3 - Promoções \n0 - Finalizar programa");
			menu1 = scan.nextInt();
			switch (menu1) {
			// ------- SEGUNDO MENU (USUÁRIO) -------
			case 1: {

				System.out.println();
				System.out.println("Opções para tabela de usuários:");
				System.out.println(
						"1 - Cadastrar usuário \n2 - Consultar usuários cadastrados \n3 - Consultar usuário pelo ID \n4 - Atualizar cadastro de usuário pelo ID \n5 - Deletar usuário pelo ID \n0 - Voltar ao menu inicial");
				menu2 = scan.nextInt();

				switch (menu2) {
				case 1: {

					controlador.cadastrar();
					break;

				}
				case 2: {

					controlador.listarUsuarios();
					break;

				}
				case 3: {

					controlador.listarUsuarioPeloID();
					break;

				}
				case 4: {

					controlador.atualizarUsuarioPeloID();
					break;
				}
				case 5: {

					controlador.deletarUsuarioPeloID();
					break;
				}

				}
				break;
			}
			// ------- SEGUNDO MENU (VIAGEM) -------
			case 2: {

				System.out.println();
				System.out.println("Opções para tabela de viagens:");
				System.out.println(
						"1 - Cadastrar viagem \n2 - Consultar viagens cadastradas \n3 - Consultar viagem pelo ID \n4 - Atualizar dados de viagem \n5 - Deletar viagem pelo ID \n6 - Consultar viagem pelo nome de usuário \n0 - Voltar ao menu incial");
				menu2 = scan.nextInt();

				switch (menu2) {
				case 1: {

					controlador.cadastrarViagem();
					break;

				}
				case 2: {

					controlador.consultarViagens();
					break;

				}
				case 3: {

					controlador.consultarViagemPeloId();
					break;

				}
				case 4: {

					controlador.atualizarViagemPeloId();
					break;

				}
				case 5: {
					
					controlador.deletarViagemPeloId();
					break;
				}
				case 6: {
					
					controlador.consultarViagemPeloNomeUser();
					break;
				}

				}

				break;

			}
			case 3: {

				System.out.println();
				System.out.println("Opções para tabela de promocções:");
				System.out.println(
						"1 - Inserir promoção \n2 - Consultar promoções existentes \n3 - Consultar promoção pelo número ID \n4 - Atualizar promoção pelo número ID \n5 - Deletar promoção pelo número ID \n0 - Voltar ao menu inicial");
				menu2 = scan.nextInt();

				switch (menu2) {
				case 1: {

					controlador.inserirPromo();
					break;

				}
				case 2: {

					controlador.listarPromos();
					break;

				}
				case 3: {

					controlador.listarPromosPeloID();
					break;

				}
				case 4: {

					controlador.atualizarPromoPeloID();
					break;

				}
				case 5: {

					controlador.deletarPromoPeloID();
					break;
				}

				}

				break;
			}

			}

		} while (menu1 != 0);

		System.out.println();
		System.out.println("Programa finalizado.");
		scan.close();
	}
}
