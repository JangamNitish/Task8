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
import dao.UserRegData;
import pojo.UserRegPojo;

/**
 * Servlet implementation class UserReg
 */
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRegData UserRegData = new UserRegData();
	Gson gson = new Gson();
	JSONObject job = new JSONObject();

	/**
	 * Default constructor.
	 */
	public UserReg() {
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
		ServletContext context = request.getServletContext();
		Connector ob = (Connector) context.getAttribute("db");
		try {
			Connection conn = ob.getConnection();
			UserRegPojo json = gson.fromJson(request.getReader(), UserRegPojo.class);
			PrintWriter out = response.getWriter();
			String st = UserRegData.regestation(json, conn);
			response.setContentType("application/JSON");
			job.put("message", st);
			out.println(job);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
