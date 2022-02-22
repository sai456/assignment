package connector;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.EmpDetails;

/**
 * Servlet implementation class CreateEmp
 */
@WebServlet("/CreateEmp")
public class CreateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("empName");
		long salary = Long.parseLong(request.getParameter("salary"));
		String designation = request.getParameter("designation");

		Dao dao = new Dao();
		EmpDetails emp = new EmpDetails();

		emp.setName(name);
		emp.setSalary(salary);
		emp.setDesignation(designation);
		boolean confirmation = dao.insert(emp);

		RequestDispatcher rd;
		String message;
		if (confirmation) {
			message = "Employee created successfully";
			request.setAttribute("msg", message);
			rd = request.getRequestDispatcher("create.jsp");
			rd.forward(request, response);
		} else {
			message = "Failed to create employee!!! Try again";
			request.setAttribute("msg", message);
			rd = request.getRequestDispatcher("create.jsp");
			rd.forward(request, response);
		}
	}

}
