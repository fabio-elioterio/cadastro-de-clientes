package br.com.zup.pgg.cadastro.de.clientes.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteMain {
	
	private static final String ADDRESS = "Digite seu endereço:";
	private static final String TELEPHONE = "Digite seu telefone:";
	private static final String EMAIL = "Digite seu email:";
	private static final String AGE = "Digite sua idade:";
	private static final String CPF = "Digite seu CPF:";
	private static final String NAME = "Digite seu nome:";
	public static Map<String, Cliente> clientList;

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Map<String, Cliente> clientList = new HashMap<String, Cliente>();
		
		
		
		
		
		
		teclado.close();
	}
	
	public static void clientInserts(Scanner teclado, Map<String, Cliente> clientList) {
	 
		System.out.println(NAME);
		String name = teclado.next();
		System.out.println(CPF);
		String cpf = teclado.next();
		System.out.println(AGE);
		int age = teclado.nextInt();
		System.out.println(EMAIL);
		String email = teclado.next();
		System.out.println(TELEPHONE);
		String telephone = teclado.next();
		System.out.println(ADDRESS);
		String address = teclado.next();
		
		Cliente clientInserts = new Cliente(name, age, cpf, email, telephone, address);
		clientList.put(cpf, clientInserts);	
	}
	
	public static void getClients() {
		
		for(Cliente client : clientList.values()) {
			clientList(client);
		}
		
	}
	
	public static void getClientByCpf(Scanner teclado) {
		
		System.out.println("Digite o cpf do usuário: ");
		String cpf = teclado.next();
		
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
		String cpfForDelete = teclado.next();
		
		clientList.remove(cpfForDelete);
		System.out.println("\nCliente Deletado com sucesso!!!");
	}
	
	private static void putClient(Scanner teclado) {
		
		System.out.println("Digite o cpf do cliente a ser atualizado: ");
		String cpfForPut = teclado.next();
		
		Cliente clienteUpdated = clientList.get(cpfForPut);
		
		System.out.println(NAME);
		clienteUpdated.setName(teclado.next());
		System.out.println(AGE);
		clienteUpdated.setAge(teclado.nextInt());
		System.out.println(EMAIL);
		clienteUpdated.setEmail(teclado.next());
		System.out.println(TELEPHONE);
		clienteUpdated.setTelephone(teclado.next());
		System.out.println(ADDRESS);
		clienteUpdated.setAddress(teclado.next());
		
		clientList.put(cpfForPut, clienteUpdated);
		
		
	}

}
