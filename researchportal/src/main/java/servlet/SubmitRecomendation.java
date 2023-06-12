package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import connecting.Connector;
import dao.SubmitRecomendationData;
import pojo.SubmitRecomendationPojo;

/**
 * Servlet implementation class SubmitRecomendation
 */
public class SubmitRecomendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	SubmitRecomendationData SubmitRecomendationData = new SubmitRecomendationData();
	JSONObject obj = new JSONObject();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitRecomendation() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ocntext = request.getServletContext();
		Connector con = (Connector) ocntext.getAttribute("db");
		try {
			Connection conn = con.getConnection();
			PrintWriter out = response.getWriter();
			SubmitRecomendationPojo json = gson.fromJson(request.getReader(), SubmitRecomendationPojo.class);
			String outptu = SubmitRecomendationData.recomendations(json, conn);
			response.setContentType("application/JSON");
			obj.put("message", outptu);
			out.println(obj);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
