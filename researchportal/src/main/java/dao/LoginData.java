package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import DBqueries.Queries;
import pojo.LoginPojo;

public class LoginData {
	Queries ob = new Queries();
	int userid;
	String password, sessiontoken, dbusername;

	public String loginSession(LoginPojo l, Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(ob.CHECK());
		pstmt.setString(1, l.getUsername());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			dbusername = rs.getString("username");
		}
		if (l.getUsername() == null && l.getPassword() == null) {
			return "enter username and password";
		} else if (l.getUsername() == null) {
			return "enter username";
		} else if (l.getPassword() == null) {
			return "enter password";
		} else {
			if (dbusername.equals(l.getUsername())) {
				PreparedStatement pstmt2 = conn.prepareStatement(ob.CHECK());
				pstmt2.setString(1, l.getUsername());
				ResultSet rs1 = pstmt2.executeQuery();
				if (rs1.next()) {
					userid = rs1.getInt("userid");
					password = rs1.getString("password");
				}
				if (l.getPassword().equals(password)) {

					PreparedStatement pstmt1 = conn.prepareStatement(ob.generate());
					sessiontoken = UUID.randomUUID().toString();
					pstmt1.setInt(1, userid);
					pstmt1.setString(2, sessiontoken);
					pstmt1.execute();
					return sessiontoken;
				} else {
					return "password entered is incorrect";
				}
			} else {
				return "username not Found";
			}
		}
	}
}
