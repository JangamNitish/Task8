package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBqueries.Queries;
import Validation.ValidationMethods;
import pojo.SubmitRecomendationPojo;
import pojo.ViewRecomendationsPojo;

public class ViewRecomendationsData {
	
	Queries ob = new Queries();
	ValidationMethods Valob = new ValidationMethods();


	ViewRecomendationsPojo view;
	List<Object> List1 = new ArrayList<Object>();
	List<Object> List2 = new ArrayList<Object>();

	public List<Object> viewRecomendation(SubmitRecomendationPojo v, Connection conn) throws SQLException {
		if ((Valob.getinsgsessiontoken(v, conn)) == null) {
			String str = "Invalid Session Token";
			List2.add(str);
			return List2;
		} else if ((Valob.getinsgsessiontoken(v, conn)).equals(v.getSessiontoken())) {
			PreparedStatement pstmt1 = conn.prepareStatement(ob.GETINGDATA());
			pstmt1.setInt(1, Valob.getinsguserid(v, conn));
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				view = new ViewRecomendationsPojo(rs1.getString("stocksymbol"), rs1.getString("recomendationtype"),
						rs1.getString("recomendationdetails"));
				List1.add(view);
			}
			return List1;
		} else {
			return null;

		}

	}
}
