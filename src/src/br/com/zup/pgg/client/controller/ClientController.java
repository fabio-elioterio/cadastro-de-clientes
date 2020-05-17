package br.com.zup.pgg.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.pgg.client.Client;

@WebServlet(urlPatterns = "/clientes")
public class ClientController extends HttpServlet {

	private static final String CLIENTE_INSERIDO_COM_SUCESSO = "Cliente inserido com sucesso!!!!";
	private static final String CPF_NULL = "CPF nulo, por favor inserir um CPF valido.";
	private static final String CLIENTE_JA_EXISTE = "Cliente ja existe!!!";
	public static Map<String, Client> clientList = new HashMap<String, Client>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		Client clientInserted = new Client();
		String cpf = req.getParameter("cpf");

		if (cpf != "") {

			clientInserted.setName(req.getParameter("name"));
			clientInserted.setAge(Integer.parseInt(req.getParameter("age")));
			clientInserted.setCpf(req.getParameter("cpf"));
			clientInserted.setAddress(req.getParameter("address"));
			clientInserted.setTelephone(req.getParameter("telephone"));
			clientInserted.setEmail(req.getParameter("email"));

			if (!clientList.containsKey(clientInserted.getCpf())) {
				clientList.put(clientInserted.getCpf(), clientInserted);
				writer.println(CLIENTE_INSERIDO_COM_SUCESSO);
			} else {

				writer.println(CLIENTE_JA_EXISTE);
			}

		} else {
			writer.println(CPF_NULL);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String cpf = req.getParameter("cpf");

		if (cpf == null) {
			for (Client getClients : clientList.values()) {
				writer.println("Name: " + getClients.getName());
				writer.println("Age: " + getClients.getAge());
				writer.println("Cpf: " + getClients.getCpf());
				writer.println("Addres: " + getClients.getAddress());
				writer.println("Email: " + getClients.getEmail());
				writer.println("Telephone: " + getClients.getTelephone());
			}

		} else {
			if (clientList.containsKey(cpf)) {

				Client getClients = clientList.get(cpf);

				writer.println("Name: " + getClients.getName());
				writer.println("Age: " + getClients.getAge());
				writer.println("Cpf: " + getClients.getCpf());
				writer.println("Addres: " + getClients.getAddress());
				writer.println("Email: " + getClients.getEmail());
				writer.println("Telephone: " + getClients.getTelephone());

			}
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String cpfForPut = req.getParameter("cpf");
		Client putClint = clientList.get(cpfForPut);

		putClint.setName(req.getParameter("name"));
		putClint.setAge(Integer.parseInt(req.getParameter("age")));
		putClint.setAddress(req.getParameter("address"));
		putClint.setTelephone(req.getParameter("telephone"));
		putClint.setEmail(req.getParameter("email"));

		clientList.put(cpfForPut, putClint);
		writer.println("Cliente alterado com sucesso!!!!");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String cpfForDelete = req.getParameter("cpf");

		clientList.remove(cpfForDelete);
		writer.println("Cliente removido com sucesso!");

	}

}
