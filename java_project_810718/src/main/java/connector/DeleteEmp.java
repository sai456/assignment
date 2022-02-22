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
 * Servlet implementation class DeleteEmp
 */
@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("empName");

		Dao dao = new Dao();
		boolean confirmation = dao.delete(name);
		String message;
		RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
		if (confirmation) {
			message="Employee deleted Successfully";
			request.setAttribute("msg", message);
			rd.forward(request, response);
		} else {
			message="Task failed !!! try again";
			request.setAttribute("msg", message);
			rd.forward(request, response);
		}
	}

}
