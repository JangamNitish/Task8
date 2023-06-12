package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBqueries.Queries;
import pojo.SubmitRecomendationPojo;
import pojo.ViewRecomendationsPojo;

public class ViewRecomendationsData {
	String sessiontoken;
	int userid;
	Queries ob = new Queries();
	ViewRecomendationsPojo view;
	List<ViewRecomendationsPojo> List1 = new ArrayList<>();

	public List<ViewRecomendationsPojo> viewRecomendation(SubmitRecomendationPojo v, Connection conn)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(ob.VALIDAT());
		pstmt.setString(1, v.getSessiontoken());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			sessiontoken = rs.getString("Sessiontoken");
			userid = rs.getInt("userid");
		}
		if (sessiontoken.equals(v.getSessiontoken())) {
			PreparedStatement pstmt1 = conn.prepareStatement(ob.GETINGDATA());
			pstmt1.setInt(1, userid);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				view = new ViewRecomendationsPojo(rs1.getString("stocksymbol"), rs1.getString("recomendationtype"),
						rs1.getString("recomendationdetails"));
				List1.add(view);
			}
			return List1;
		}
		return null;

	}

}
