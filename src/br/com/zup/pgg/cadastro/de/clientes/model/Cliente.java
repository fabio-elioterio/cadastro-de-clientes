package br.com.zup.pgg.cadastro.de.clientes.model;

public class Cliente {
	
	private String name;
	private int age;
	private Long cpf;
	private String email;
	private String telephone;
	private String address;
	
	public Cliente(String name, int age, Long cpf, String email, String telephone, String address) {
		this.name = name;
		this.age = age;
		this.cpf = cpf;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
