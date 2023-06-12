package DBqueries;

public class Queries {

	public String generate() {
		return "INSERT INTO sessiontoken (userid, Sessiontoken) VALUES(?,?)";
	}

	public String CHECK() {
		return "SELECT * FROM users WHERE username=?";
	}

	public String VALIDATION() {
		return "SELECT * FROM sessiontoken WHERE Sessiontoken=?";
	}

	public String RECOMENDATIONS() {
		return "INSERT INTO recomendationtable (userid, stocksymbol, recomendationtype, recomendationdate, recomendationdetails) VALUES (?,?,?,?,?)";
	}

	public String insert() {
		return "INSERT INTO users (username, password, email, phonenumber) VALUES(?,?,?,?)";
	}

	public String VALIDAT() {
		return "SELECT * FROM sessiontoken WHERE Sessiontoken=?";
	}

	public String GETINGDATA() {
		return "SELECT * FROM recomendationtable WHERE userid=?";
	}

}
