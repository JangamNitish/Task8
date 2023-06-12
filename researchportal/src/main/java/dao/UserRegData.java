package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.validator.routines.EmailValidator;

import DBqueries.Queries;
import pojo.UserRegPojo;

public class UserRegData {
	static Connection conn = null;

	EmailValidator validator = EmailValidator.getInstance();
	Queries ob = new Queries();

	public String regestation(UserRegPojo u, Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(ob.insert());
		if (u.getUsername() == null && u.getPassword() == null && u.getEmail() == null && u.getPhonenumber() == null) {
			return "enter credentials correctly";
		} else {
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			if (validator.isValid(u.getEmail())) {
				pstmt.setString(3, u.getEmail());
			} else {
				return "Incorrect email Address";
			}
			if (u.getPhonenumber().matches("\\d{10}")) {
				pstmt.setString(4, u.getPhonenumber());
			} else {
				return "Incorrect Mobile number";
			}

			pstmt.execute();
			return "registered succesfully";
		}
	}
}
