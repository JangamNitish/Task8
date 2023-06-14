package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import DBqueries.Queries;
import Validation.ValidationMethods;
import pojo.SubmitRecomendationPojo;

public class SubmitRecomendationData {
	Queries ob = new Queries();
	ValidationMethods ValOb = new ValidationMethods();
	String sessiontoken;
	int userid;

	public String recomendations(SubmitRecomendationPojo v, Connection conn) throws SQLException {

		Date date = Date.valueOf(LocalDate.now());
		if ((ValOb.getinsgsessiontoken(v, conn)) == null) {
			String str = "Invalid Session Token";
		} else if (ValOb.getinsgsessiontoken(v, conn).equals(v.getSessiontoken())) {
			PreparedStatement pstmt1 = conn.prepareStatement(ob.RECOMENDATIONS());
			pstmt1.setInt(1, userid);

			if (v.getSymbol().isEmpty()) {
				return "Stock symbol Can't be empty";
			} else {
				pstmt1.setString(2, v.getSymbol());

			}
			if (v.getRecomendationtype().equals("sell") || v.getRecomendationtype().equals("buy")) {
				pstmt1.setString(3, v.getRecomendationtype());
			} else {
				return "Invalid type";
			}
			pstmt1.setDate(4, date);
			pstmt1.setString(5, v.getRecomendationdetails());
			pstmt1.execute();
			return "entered sucessfully";

		}

		return null;
	}
}
