package model;

public class Employee extends Person {
	private String login;
	private String password;
	private String job;
	
	public Employee(String lastname, String firstname, String email, int phone, Address address, String login, String password, String job) {
		super(lastname, firstname, email, phone, address);
		this.login = login;
		this.password = password;
		this.job = job;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
