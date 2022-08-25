package agenciaTrip.controller;

import java.sql.Date;
import java.util.Scanner;
import agenciaTrip.model.Promocao;
import agenciaTrip.model.Usuario;
import agenciaTrip.model.Viagem;
import agenciaTrip.model.dao.PromocaoDAO;
import agenciaTrip.model.dao.UsuarioDAO;
import agenciaTrip.model.dao.ViagemDAO;

public class Controles {

	Scanner scan = new Scanner(System.in);
	UsuarioDAO userDAO = new UsuarioDAO();
	Usuario user = new Usuario();
	String senha;

	// --------------- MÉTODOS DE USUÁRIO --------------- //

	public void cadastrar() {

		System.out.println();
		System.out.println("Digite o nome do usuário: ");
		user.setNome(scan.nextLine());
		System.out.println("Digite o endereço de e-mail do usuário: ");
		user.setEmail(scan.nextLine());
		System.out.println("Senha do usuário: ");
		senha = scan.nextLine();
		while (senha.length() < 6 || senha.length() > 8) {
			System.out.println("A senha deve conter entre 6 e 8 caracteres. Digite novamente: ");
			senha = scan.nextLine();
		}
		user.setSenha(senha);
		user.setDataCadastro(new Date(System.currentTimeMillis()));

		userDAO.save(user);

		System.out.println();
		System.out.println("Cadastro realizado com sucesso!");
		System.out.println();

	}

	public void listarUsuarios() {

		for (Usuario u : userDAO.getUsuarios()) {
			System.out.println(" ------ Usuário de ID número " + u.getId() + " ------ ");
			System.out.println();
			System.out.println("Nome: " + u.getNome());
			System.out.println("E-mail: " + u.getEmail());
			System.out.println("Data de cadastro: " + u.getDataCadastro());
			System.out.println();
			System.out.println();
		}

	}

	public void listarUsuarioPeloID() {

		System.out.println();
		System.out.println("Digite o número ID: ");
		int id = scan.nextInt();
		boolean test = false;
		for (Usuario u : userDAO.getUsuarios()) {
			if (id == u.getId()) {
				System.out.println(" ------ Usuário de ID número " + u.getId() + " ------ ");
				System.out.println();
				System.out.println("Nome: " + u.getNome());
				System.out.println("E-mail: " + u.getEmail());
				System.out.println("Data de cadastro: " + u.getDataCadastro());
				System.out.println();
				System.out.println();
				test = true;
			}
		}
		if (test == false) {
			System.out.println();
			System.out.println("Usuário não encontrado.");
			System.out.println();
		}
	}

	public void atualizarUsuarioPeloID() {

		int id;
		System.out.println();
		System.out.println("// Atualização de cadastro \\");
		System.out.println();
		System.out.println("Digite o número ID: ");
		id = scan.nextInt();
		scan.nextLine();
		user.setId(id);
		System.out.println("Digite o nome do usuário: ");
		user.setNome(scan.nextLine());
		System.out.println("Digite o endereço de e-mail do usuário: ");
		user.setEmail(scan.nextLine());
		System.out.println("Senha do usuário: ");
		senha = scan.nextLine();
		while (senha.length() < 6 || senha.length() > 8) {
			System.out.println("A senha deve conter entre 6 e 8 caracteres. Digite novamente: ");
			senha = scan.nextLine();
		}
		user.setSenha(senha);
		user.setDataCadastro(new Date(System.currentTimeMillis()));

		userDAO.update(user);

		System.out.println();
		System.out.println("Cadastro atualizado com sucesso!");
		System.out.println();

	}

	public void deletarUsuarioPeloID() {

		int id;
		String opcao;
		System.out.println();
		System.out.println("Digite o número ID do usuário a ser deletado:");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Tem certeza que deseja realizar a operação? s/n");
		opcao = scan.nextLine();
		switch (opcao) {
		case "s": {
			userDAO.deleteByID(id);
			System.out.println();
			System.out.println("Usuário deletado com sucesso!");
			System.out.println();
			break;
		}
		case "n": {
			System.out.println();
			System.out.println("Operação encerrada.");
			System.out.println();
		}

		}

	}

	// --------------- MÉTODOS DE VIAGENS --------------- //

	ViagemDAO viagemDao = new ViagemDAO();
	Viagem viagem = new Viagem();

	public void cadastrarViagem() {

		String opcao;
		System.out.println();
		System.out.println("Insira a origem da viagem: ");
		viagem.setOrigem(scan.nextLine());
		System.out.println("Insira o destino da viagem: ");
		viagem.setDestino(scan.nextLine());
		System.out.println("Insira a data de ida (No formato: aaaa-mm-dd): ");
		viagem.setIda(java.sql.Date.valueOf(scan.next()));
		System.out.println("Insira a data de volta (No formato: aaaa-mm-dd): ");
		viagem.setVolta(java.sql.Date.valueOf(scan.next()));
		System.out.println("Número ID do contratante: ");
		viagem.setId_user(scan.nextInt());
		System.out.println("Há promoção a ser adicionada à compra? s/n");
		opcao = scan.next();
		switch (opcao) {
		case "s":
			System.out.println("Número ID da promoção: ");
			viagem.setId_promo(scan.nextInt());
			break;
		}

		viagemDao.save(viagem);
		System.out.println();
		System.out.println("Viagem cadastrada com sucesso!");
		System.out.println();

	}

	public void consultarViagens() {

		for (Viagem v : viagemDao.getViagens()) {
			System.out.println();
			System.out.println(" ------ Viagem de ID número " + v.getId() + " ------ ");
			System.out.println();
			System.out.println("Origem: " + v.getOrigem());
			System.out.println("Destino: " + v.getDestino());
			System.out.println("Data de ida: " + v.getIda());
			System.out.println("Data de volta: " + v.getVolta());
			System.out.println("ID do contratante: " + v.getId_user());
			System.out.println("ID da promoção: " + v.getId_promo());
			System.out.println();
		}

	}

	public void consultarViagemPeloId() {

		System.out.println();
		System.out.println("Digite o número ID: ");
		int id = scan.nextInt();
		boolean test = false;
		for (Viagem v : viagemDao.getViagens()) {
			if (id == v.getId()) {
				System.out.println();
				System.out.println(" ------ Viagem de ID número " + v.getId() + " ------ ");
				System.out.println();
				System.out.println("Origem: " + v.getOrigem());
				System.out.println("Destino: " + v.getDestino());
				System.out.println("Data de ida: " + v.getIda());
				System.out.println("Data de volta: " + v.getVolta());
				System.out.println("ID do contratante: " + v.getId_user());
				System.out.println("ID da promoção: " + v.getId_promo());
				System.out.println();
				test = true;
			}
		}
		if (test == false) {
			System.out.println();
			System.out.println("Viagem não encontrada.");
			System.out.println();
		}

	}

	public void atualizarViagemPeloId() {

		String opcao;
		System.out.println();
		System.out.println("Insira o ID da viagem a ser atualizada: ");
		viagem.setId(scan.nextInt());
		scan.nextLine();
		System.out.println("Insira a origem da viagem: ");
		viagem.setOrigem(scan.nextLine());
		System.out.println("Insira o destino da viagem: ");
		viagem.setDestino(scan.nextLine());
		System.out.println("Insira a data de ida (No formato: aaaa-mm-dd): ");
		viagem.setIda(java.sql.Date.valueOf(scan.next()));
		System.out.println("Insira a data de volta (No formato: aaaa-mm-dd): ");
		viagem.setVolta(java.sql.Date.valueOf(scan.next()));
		System.out.println("Número ID do contratante: ");
		viagem.setId_user(scan.nextInt());
		System.out.println("Há promoção a ser adicionada à compra? s/n");
		opcao = scan.next();
		switch (opcao) {
		case "s":
			System.out.println("Número ID da promoção: ");
			viagem.setId_promo(scan.nextInt());
			break;
		}

		viagemDao.update(viagem);
		System.out.println();
		System.out.println("Viagem Atualizada com sucesso!");
		System.out.println();

	}

	public void deletarViagemPeloId() {

		int id;
		String opcao;
		System.out.println();
		System.out.println("Digite o número ID da viagem a ser deletada:");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Tem certeza que deseja realizar a operação? s/n");
		opcao = scan.nextLine();
		switch (opcao) {
		case "s": {
			viagemDao.deleteByID(id);
			System.out.println();
			System.out.println("Viagem deletada com sucesso!");
			System.out.println();
			break;
		}
		case "n": {
			System.out.println();
			System.out.println("Operação encerrada.");
			System.out.println();
		}

		}

	}

	public void consultarViagemPeloNomeUser() {

		System.out.println();
		System.out.println("Digite o nome do usuário: ");
		String nome = scan.nextLine();
		boolean test = false;

		for (Usuario u : userDAO.getUsuarios()) {
			for (Viagem v : viagemDao.getViagens()) {
				if (v.getId_user() == u.getId()) {
					if (nome.trim().equalsIgnoreCase(u.getNome().trim())) {
						System.out.println();
						System.out.println(" ------ Viagem de ID número " + v.getId() + " ------ ");
						System.out.println();
						System.out.println("Origem: " + v.getOrigem());
						System.out.println("Destino: " + v.getDestino());
						System.out.println("Data de ida: " + v.getIda());
						System.out.println("Data de volta: " + v.getVolta());
						System.out.println("ID do contratante: " + v.getId_user());
						System.out.println("ID da promoção: " + v.getId_promo());
						System.out.println();
						test = true;
					}
				}
			}

		}

		if (test == false) {
			System.out.println();
			System.out.println("Usuário inexistente ou sem viagem cadastrada.");
			System.out.println();
		}

	}

	// --------------- MÉTODOS DE PROMOÇÔES --------------- //

	PromocaoDAO promoDAO = new PromocaoDAO();
	Promocao promo = new Promocao();

	public void inserirPromo() {

		String data;

		System.out.println();
		System.out.println("Digite o prazo de validade da promoção (No formato: aaaa-mm-dd): ");
		data = scan.next();
		promo.setValidade(java.sql.Date.valueOf(data));
		System.out.println("Digite a porcentagem de desconto da promoção: ");
		promo.setPercent(scan.nextDouble());

		promoDAO.save(promo);

		System.out.println();
		System.out.println("Promoção inserida com sucesso!");
		System.out.println();

	}

	public void listarPromos() {

		for (Promocao p : promoDAO.getPromocoes()) {
			System.out.println(" ------ Promoção de ID número " + p.getId() + " ------ ");
			System.out.println();
			System.out.println("Validade da promoção: " + p.getValidade());
			System.out.println("Porcentagem de desconto: " + p.getPercent() + "%");
			System.out.println();
			System.out.println();
		}

	}

	public void listarPromosPeloID() {

		int id;
		boolean test;
		System.out.println();
		System.out.println("Digite o número ID da promoção: ");
		id = scan.nextInt();
		test = false;
		for (Promocao p : promoDAO.getPromocoes()) {
			if (id == p.getId()) {
				System.out.println(" ------ Promoção de ID número " + p.getId() + " ------ ");
				System.out.println();
				System.out.println("Validade da promoção: " + p.getValidade());
				System.out.println("Porcentagem de desconto: " + p.getPercent() + "%");
				System.out.println();
				System.out.println();
				test = true;
			}
		}
		if (test == false) {
			System.out.println();
			System.out.println("Promoção não encontrada.");
			System.out.println();
		}
	}

	public void atualizarPromoPeloID() {

		String data;
		int id;
		System.out.println();
		System.out.println("// Atualização de promoção \\");
		System.out.println();
		System.out.println("Digite o número ID da promoção: ");
		id = scan.nextInt();
		scan.nextLine();
		promo.setId(id);
		System.out.println("Digite o prazo de validade da promoção (No formato: aaaa-mm-dd): ");
		data = scan.next();
		promo.setValidade(java.sql.Date.valueOf(data));
		System.out.println("Digite a porcentagem de desconto da promoção: ");
		promo.setPercent(scan.nextDouble());

		promoDAO.update(promo);

		System.out.println();
		System.out.println("Promoção atualizada com sucesso!");
		System.out.println();

	}

	public void deletarPromoPeloID() {

		int id;
		String opcao;
		System.out.println();
		System.out.println("Digite o número ID da promoção a ser deletada:");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Tem certeza que deseja realizar a operação? s/n");
		opcao = scan.nextLine();
		switch (opcao) {
		case "s": {
			promoDAO.deleteByID(id);
			System.out.println();
			System.out.println("Promoção deletada com sucesso!");
			System.out.println();
			break;
		}
		case "n": {
			System.out.println();
			System.out.println("Operação encerrada.");
			System.out.println();
		}

		}

	}

}
