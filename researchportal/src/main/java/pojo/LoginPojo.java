package pojo;

public class LoginPojo {
	String username, password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
