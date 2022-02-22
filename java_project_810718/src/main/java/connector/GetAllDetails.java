package connector;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.EmpDetails;

/**
 * Servlet implementation class GetAllDetails
 */
@WebServlet("/GetAllDetails")
public class GetAllDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dao dao = new Dao();
		List<EmpDetails> empList = dao.findAll();
		request.setAttribute("empList", empList);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);

	}

}
