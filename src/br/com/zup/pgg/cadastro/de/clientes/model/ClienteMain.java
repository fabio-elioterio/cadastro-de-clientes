package br.com.zup.pgg.cadastro.de.clientes.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteMain {

	private static final int MAX_NUMBER = 5;
	private static final int MIN_NUMBER = 0;
	private static final String ADDRESS = "Digite seu endereço:";
	private static final String TELEPHONE = "Digite seu telefone:";
	private static final String EMAIL = "Digite seu email:";
	private static final String AGE = "Digite sua idade:";
	private static final String CPF = "Digite seu CPF:";
	private static final String NAME = "Digite seu nome:";
	public static Map<Long, Cliente> clientList = new HashMap<Long, Cliente>();

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		clientMenu(teclado);
		teclado.close();
	}

	public static void clientInserts(Scanner teclado, Map<Long, Cliente> clientList) {
		
		teclado.nextLine();
		System.out.println(NAME);
		String name = teclado.nextLine();
		System.out.println(CPF);
		Long cpf = teclado.nextLong();
		System.out.println(AGE);
		int age = teclado.nextInt();
		teclado.nextLine();
		System.out.println(EMAIL);
		String email = teclado.nextLine();
		System.out.println(TELEPHONE);
		String telephone = teclado.nextLine();
		System.out.println(ADDRESS);
		String address = teclado.nextLine();

		Cliente clientInserts = new Cliente(name, age, cpf, email, telephone, address);
		clientList.put(cpf, clientInserts);
	}

	public static void getClients() {

		for (Cliente client : clientList.values()) {
			clientList(client);
		}

	}

	public static void getClientByCpf(Scanner teclado) {

		System.out.println("Digite o cpf do usuário: ");
		Long cpf = teclado.nextLong();

		Cliente clientFromList = clientList.get(cpf);
		clientList(clientFromList);
	}

	public static void clientList(Cliente clientList) {

		System.out.println("Nome: " + clientList.getName());
		System.out.println("Idade: " + clientList.getAge());
		System.out.println("CPF: " + clientList.getCpf());
		System.out.println("Email: " + clientList.getEmail());
		System.out.println("Endereço: " + clientList.getAddress());
		System.out.println("Telefone: " + clientList.getTelephone());
	}

	public static void deleteClient(Scanner teclado) {

		System.out.println("Digite o cpf: ");
		Long cpfForDelete = teclado.nextLong();

		clientList.remove(cpfForDelete);
		System.out.println("\nCliente Deletado com sucesso!!!");
	}

	private static void putClient(Scanner teclado) {

		System.out.println("Digite o cpf do cliente a ser atualizado: ");
		Long cpfForPut = teclado.nextLong();

		Cliente clienteUpdated = clientList.get(cpfForPut);
		
		teclado.nextLine();
		System.out.println(NAME);
		clienteUpdated.setName(teclado.nextLine());
		System.out.println(AGE);
		clienteUpdated.setAge(teclado.nextInt());
		teclado.nextLine();
		System.out.println(EMAIL);
		clienteUpdated.setEmail(teclado.nextLine());
		System.out.println(TELEPHONE);
		clienteUpdated.setTelephone(teclado.nextLine());
		System.out.println(ADDRESS);
		clienteUpdated.setAddress(teclado.nextLine());

		clientList.put(cpfForPut, clienteUpdated);

	}

	private static void clientMenu(Scanner teclado) {

		int option = 0;
		do {

			System.out.println("#####BEM VINDO AO MENU DO CLIENTE#####\n");
			System.out.println("- Para inserir um cliente digite '1' ");
			System.out.println("- Para buscar por um cliente digite '2' ");
			System.out.println("- Para buscar todos os clientes digite '3' ");
			System.out.println("- Para atualizar dados de um cliente digite '4'");
			System.out.println("- Para deletar um cliente digite '5' ");
			System.out.println("- Para sair do programa digite '0' ");
			option = teclado.nextInt();
			if (option < MIN_NUMBER || option > MAX_NUMBER) {
				System.out.println("Digite um número solicitado no menu");

			}

			switch (option) {
			case 1:
				clientInserts(teclado, clientList);
				break;
			case 2:
				getClientByCpf(teclado);
				break;

			case 3:
				getClients();
				break;

			case 4:
				putClient(teclado);
				break;

			case 5:
				deleteClient(teclado);
				break;

			case 0:
				System.out.println("Obrigado por sua participação!!!");
				break;

			default:
				System.out.println("Digite apenas um dos números solicitados.");
			}

		} while (option != 0);

	}

}
