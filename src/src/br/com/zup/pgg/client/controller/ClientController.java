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
	
	public static Map<Long, Client> clientList = new HashMap<Long, Client>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		Client clientInserted = new Client();
		
		clientInserted.setName(req.getParameter("name"));
		clientInserted.setAge(Integer.parseInt(req.getParameter("age")));
		clientInserted.setCpf(Long.parseLong(req.getParameter("cpf")));
		clientInserted.setAddress(req.getParameter("address"));
		clientInserted.setTelephone(req.getParameter("telephone"));
		clientInserted.setEmail(req.getParameter("email"));
		
		clientList.put(clientInserted.getCpf(), clientInserted);
		writer.println("Cliente inserido com sucesso!!!!");
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		for (Client getClients : clientList.values()) {
			writer.println("Name: " + getClients.getName());
			writer.println("Age: " + getClients.getAge());
			writer.println("Cpf: " + getClients.getCpf());
			writer.println("Addres: " + getClients.getAddress());
			writer.println("Email: " + getClients.getEmail());
			writer.println("Telephone: " + getClients.getTelephone());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		Long cpfForPut = Long.parseLong(req.getParameter("cpf"));
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
		Long cpfForDelete = Long.parseLong(req.getParameter("cpf"));
		
		clientList.remove(cpfForDelete);
		writer.println("Cliente removido com sucesso!");
		
	}
	
}
