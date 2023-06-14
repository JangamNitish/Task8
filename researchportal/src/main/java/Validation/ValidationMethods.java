package Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import DBqueries.Queries;
import pojo.LoginPojo;
import pojo.SubmitRecomendationPojo;

public class ValidationMethods {

	Queries ob = new Queries();

	public String getinsgsessiontoken(SubmitRecomendationPojo v, Connection conn) throws SQLException {
		String sessiontoken = null;
		int userid;
		PreparedStatement pstmt = conn.prepareStatement(ob.VALIDAT());
		pstmt.setString(1, v.getSessiontoken());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			sessiontoken = rs.getString("Sessiontoken");
			userid = rs.getInt("userid");
		}
		return sessiontoken;
	}

	public int getinsguserid(SubmitRecomendationPojo v, Connection conn) throws SQLException {
		String sessiontoken = null;
		int userid = 0;
		PreparedStatement pstmt = conn.prepareStatement(ob.VALIDAT());
		pstmt.setString(1, v.getSessiontoken());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			sessiontoken = rs.getString("Sessiontoken");
			userid = rs.getInt("userid");
		}
		return userid;
	}

}