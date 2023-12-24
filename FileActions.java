package com.proj.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.proj.dao.Dao;
import com.proj.dao.DaoImpl;
import com.proj.domain.ProjectReport;

/**
 * Servlet implementation class FileActions
 */
@WebServlet(urlPatterns = { "/reportreview", "/addreport", "/getreport", "/viewreport" })
@MultipartConfig
public class FileActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new DaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		if (url.endsWith("reportreview")) {
			String title = request.getParameter("title");
			session.setAttribute("title", title);
			response.sendRedirect("addreport.html");

		} else if (url.endsWith("addreport")) {
			int phase = Integer.parseInt(request.getParameter("phase"));
			String usn = session.getAttribute("usn").toString();
			String title = session.getAttribute("title").toString();
			final Part filePart = request.getPart("reportfile");
			InputStream pdfFileBytes = null;
			final PrintWriter writer = response.getWriter();
			try {

				if (!filePart.getContentType().equals("application/pdf")) {
					writer.println("<br/> Invalid File");
					return;
				}

				else if (filePart.getSize() > 1048576 * 8) { // 2mb*5
					{
						writer.println("<br/> File size too big");
						return;
					}
				}

				pdfFileBytes = filePart.getInputStream(); // to get the body of the request as binary data

				final byte[] report = new byte[pdfFileBytes.available()];
				pdfFileBytes.read(report);

				ProjectReport pr = new ProjectReport(0, usn, phase, title, report);

				if (dao.addReport(pr)) {
					session.setAttribute("msg", "Project report added successfully");
					response.sendRedirect("message.jsp");
				} else {
					session.setAttribute("msg", "Something went wrong");
					response.sendRedirect("message.jsp");
				}

			} catch (FileNotFoundException fnf) {
				writer.println("You did not specify a file to upload");
				writer.println("<br/> ERROR: " + fnf.getMessage());

			} finally {
				if (pdfFileBytes != null) {
					pdfFileBytes.close();
				}
				if (writer != null) {
					writer.close();
				}
			}
		} else if (url.endsWith("getreport")) {
			String title = request.getParameter("title");
			session.setAttribute("title", title);
			response.sendRedirect("selectprojectphase.jsp");
		} else if (url.endsWith("viewreport")) {
			String title = session.getAttribute("title").toString();
			int phase = Integer.parseInt(request.getParameter("phase"));
			ServletOutputStream sos;
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=" + title + ".pdf");
			sos = response.getOutputStream();
			ResultSet rs = dao.getReport(phase, title);
			try {
				if (rs.next()) {
					byte[] res = rs.getBytes("report");
					sos.write(res);
				} else {
					session.setAttribute("msg", "Project Report not found.");
					response.sendRedirect("message.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				sos.flush();
				sos.close();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
