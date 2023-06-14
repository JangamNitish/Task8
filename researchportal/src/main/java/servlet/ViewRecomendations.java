package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import connecting.Connector;
import dao.ViewRecomendationsData;
import pojo.SubmitRecomendationPojo;
import pojo.ViewRecomendationsPojo;

/**
 * Servlet implementation class ViewRecomendations
 */
public class ViewRecomendations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	ViewRecomendationsData ViewRecomendationsData = new ViewRecomendationsData();
	JSONObject jsonobject = new JSONObject();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRecomendations() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		Connector con = (Connector) context.getAttribute("db");
		try {
			Connection conn = con.getConnection();
			PrintWriter out = response.getWriter();
			SubmitRecomendationPojo json = gson.fromJson(request.getReader(), SubmitRecomendationPojo.class);
			List<Object> output = ViewRecomendationsData.viewRecomendation(json, conn);
			response.setContentType("application/JSON");
			String string = gson.toJson(output);
			out.println(string);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
