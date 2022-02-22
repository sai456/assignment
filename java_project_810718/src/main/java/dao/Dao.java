package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EmpDetails;
import util.ConnectionUtil;

public class Dao {

	public boolean insert(EmpDetails emp) {
		boolean confirmation = false;
		int rowsAffected = 0;
		Connection con = null;
		PreparedStatement stmnt = null;
		try {
			con = ConnectionUtil.getConnection();
			stmnt = con.prepareStatement("insert into emp_details(name,salary,designation) values(?,?,?)");
			stmnt.setString(1, emp.getName());
			stmnt.setLong(2, emp.getSalary());
			stmnt.setString(3, emp.getDesignation());
			rowsAffected = stmnt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			ConnectionUtil.closeConAndStatmnt(con, stmnt);
		}
		if (rowsAffected >= 1) {
			confirmation = true;
		}
		return confirmation;

	}

	public boolean update(String name, long salary) {
		boolean confirmation = false;
		int rowsAffected = 0;
		Connection con = null;
		PreparedStatement stmnt = null;
		try {
			con = ConnectionUtil.getConnection();
			stmnt = con.prepareStatement("update emp_details set salary = salary+? where name = ?");
			stmnt.setLong(1, salary);
			stmnt.setString(2, name);

			rowsAffected = stmnt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			ConnectionUtil.closeConAndStatmnt(con, stmnt);
		}
		if (rowsAffected >= 1) {
			confirmation = true;
		}
		return confirmation;
	}

	public List<EmpDetails> findAll() {
		List<EmpDetails> empList = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmnt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			stmnt = con.prepareStatement("select * from emp_details");

			rs = stmnt.executeQuery();
			while (rs.next()) {
				EmpDetails emp = new EmpDetails();
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getLong("salary"));
				emp.setDesignation(rs.getString("designation"));
				emp.setId(rs.getInt("id"));
				empList.add(emp);

			}

		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			ConnectionUtil.closeConAndStatmnt(con, stmnt);
		}
		return empList;
	}

	public boolean delete(String name) {
		boolean confirmation = false;
		int rowsAffected = 0;
		Connection con = null;
		PreparedStatement stmnt = null;
		try {
			con = ConnectionUtil.getConnection();
			stmnt = con.prepareStatement("delete from emp_details where name = ?");
			stmnt.setString(1, name);

			rowsAffected = stmnt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			ConnectionUtil.closeConAndStatmnt(con, stmnt);
		}
		if (rowsAffected >= 1) {
			confirmation = true;
		}

		return confirmation;

	}
}
