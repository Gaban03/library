package model;

public class User {

	private String name;
	private String registrationNumber;

	
	public User(String name, String registrationNumber) {
		this.name = name;
		this.registrationNumber = registrationNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	// É uma formatação para aparecer as informações referentes ao usuário
	@Override
	public String toString() {
		return "Name = " + name + ", RegistrationNumber = " + registrationNumber;
	}
	
}
