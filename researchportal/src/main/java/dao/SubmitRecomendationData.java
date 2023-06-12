package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import DBqueries.Queries;
import pojo.SubmitRecomendationPojo;

public class SubmitRecomendationData {
	Queries ob = new Queries();
	String sessiontoken;
	int userid;

	public String recomendations(SubmitRecomendationPojo s, Connection conn) throws SQLException {

		PreparedStatement pstmt = conn.prepareStatement(ob.VALIDATION());
		Date date = Date.valueOf(LocalDate.now());
		pstmt.setString(1, s.getSessiontoken());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			userid = rs.getInt("userid");
			sessiontoken = rs.getString("Sessiontoken");
		}
		if (sessiontoken.equals(null)) {
			return "Enter valid sessiontoken";
		} else if (sessiontoken.equals(s.getSessiontoken())) {
			PreparedStatement pstmt1 = conn.prepareStatement(ob.RECOMENDATIONS());
			pstmt1.setInt(1, userid);

			if (s.getSymbol().isEmpty()) {
				return "Stock symbol Can't be empty";
			} else {
				pstmt1.setString(2, s.getSymbol());

			}
			if (s.getRecomendationtype().equals("sell") || s.getRecomendationtype().equals("buy")) {
				pstmt1.setString(3, s.getRecomendationtype());
			} else {
				return "Invalid type";
			}
			pstmt1.setDate(4, date);
			pstmt1.setString(5, s.getRecomendationdetails());
			pstmt1.execute();
			return "entered sucessfully";

		}

		return "Invalid SessionToken";
	}
}
