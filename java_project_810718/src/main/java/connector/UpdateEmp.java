package connector;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("empName");
		long salary = Long.parseLong(request.getParameter("salary"));

		Dao dao = new Dao();
		boolean confirmation = dao.update(name, salary);
		String message;
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		if (confirmation) {
			message = "Updated successfully";
			request.setAttribute("msg", message);
			rd.forward(request, response);
		} else {
			message = "Updation failed!!";
			request.setAttribute("msg", message);
			rd.forward(request, response);
		}
	}

}
