package com.proj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.Dao;
import com.proj.dao.DaoImpl;
import com.proj.domain.MyProject;
import com.proj.domain.Student;

/**
 * Servlet implementation class UserActions
 */
@WebServlet(urlPatterns = { "/signup", "/login", "/studentDashboard", "/showmyprojects", "/addnewproject", "/myprofile",
		"/searchproject" })
public class UserActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao dao = new DaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		Student student = null;
		if (url.endsWith("signup")) {
			String usn, name, dept, email, mob, pwd;
			int sem;
			usn = request.getParameter("usn").toUpperCase().trim();
			name = request.getParameter("name").toUpperCase();
			dept = request.getParameter("dept").toUpperCase();
			email = request.getParameter("email").toLowerCase();
			mob = request.getParameter("mobile").toUpperCase();
			pwd = request.getParameter("password").toUpperCase().trim();
			sem = Integer.parseInt(request.getParameter("sem"));
			Student stu = new Student(usn, name, dept, email, mob, pwd, sem);
			if (dao.signUpStudent(stu)) {
				response.sendRedirect("SignUpSucess.html");
			} else {
				response.getWriter().append("Signup Failed, Try again");
			}

		} else if (url.endsWith("login")) {
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			if (email.equalsIgnoreCase("admin@ncet.com") && password.equals("ncet")) {
				response.sendRedirect("AdminDashboard.html");
			} else if ((student = dao.loginStudent(email, password)) != null) {
				String name = student.getName();
				String usn = student.getUsn();
				session.setAttribute("usn", usn);
				session.setAttribute("name", name);
				response.sendRedirect("dashboard.jsp");

			} else {
				response.sendRedirect("invalid.html");
			}

		} else if (url.endsWith("addnewproject")) {
			String usn, ptitle, type, pabstract, status, feedback, team;
			usn = session.getAttribute("usn").toString();
			ptitle = request.getParameter("ptitle");
			type = request.getParameter("type");
			pabstract = request.getParameter("abs");
			team = request.getParameter("team");
			MyProject project = new MyProject(usn, ptitle, type, pabstract, usn + "(L) ," + team);
			if (dao.registerProject(project)) {
				response.sendRedirect("ProjectsAddedSuccessfully.html");
			} else {
				response.sendRedirect("dashboard.jsp");
			}

		} else if (url.endsWith("showmyprojects")) {
			List<MyProject> list = dao.getStudentProject(session.getAttribute("usn").toString());
			request.setAttribute("myprojects", list);
			RequestDispatcher rd = request.getRequestDispatcher("myprojects.jsp");
			rd.forward(request, response);
		}

		else if (url.endsWith("searchproject")) {
			String searchStr = request.getParameter("searchstr");
			List<MyProject> list = dao.searchProject(searchStr);
			request.setAttribute("myprojects", list);
			RequestDispatcher rd = request.getRequestDispatcher("searchprojects.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
