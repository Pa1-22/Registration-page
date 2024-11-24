package com.tap;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/jee3";
		String username="root";
		String password="root";
		Connection con;
		String sql="INSERT INTO jee3.members(Firstname,Lastname,Email) VALUES(?,?,?)";
		PreparedStatement pstmt;
		String Firstname = req.getParameter("Firstname");
		String Lastname = req.getParameter("Lastname");
		String Email = req.getParameter("Email");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,Firstname);
			pstmt.setString(2,Lastname);
			pstmt.setString(3, Email);
			int a=pstmt.executeUpdate();
			PrintWriter out=resp.getWriter();
			
			if(a>0) {
				
				out.println("REGISTER SUCCESSFULLY "+Firstname);
			}
			else {
				out.println("REGISTER FAILURE "+Firstname);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
