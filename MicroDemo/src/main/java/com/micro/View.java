package com.micro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			PrintWriter pw = response.getWriter();
			while(rs.next()) {
				pw.print("<br><br>"+rs.getInt(1) +"    "+ rs.getString(2)+"    " + rs.getFloat(3));
			}
			rs.close();
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
