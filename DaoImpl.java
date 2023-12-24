package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proj.dbutil.DBUtil;
import com.proj.domain.MyProject;
import com.proj.domain.ProjectReport;
import com.proj.domain.Student;

public class DaoImpl implements Dao {

	private DBUtil db = DBUtil.db;
	private Connection con = db.getConnection();
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	@Override
	public boolean signUpStudent(Student s) {
		String sql = "INSERT INTO studentinfo values (?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getUsn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getDept());
			pst.setInt(7, s.getSem());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getMob());
			pst.setString(6, s.getPwd());
			int rows = pst.executeUpdate();
			if (rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student getStudent(String usn) {
		String sql = "SELECT * FROM STUDENTINFO WHERE USN = ?";
		Student student = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, usn);
			rs = pst.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean registerProject(MyProject p) {
		String sql = "INSERT INTO PROJECTINFO (usn,projecttitle,type,abstract,team) values (?,?,?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getUsn());
			pst.setString(2, p.getPtitle());
			pst.setString(3, p.getType());
			pst.setString(4, p.getPabstract());
			pst.setString(5, p.getTeam());
			int count = pst.executeUpdate();
			if (count == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<MyProject> getStudentProject(String usn) {
		String sql = "SELECT * FROM PROJECTINFO WHERE USN = ?";
		List<MyProject> pList = new ArrayList<>();
		MyProject project = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, usn);
			rs = pst.executeQuery();
			while (rs.next()) {
				project = new MyProject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

				pList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public boolean updateProject(int pid, String status, String feedback) {
		String sql = "UPDATE PROJECTINFO SET STATUS = ?,FEEDBACK = ? WHERE PID = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			pst.setString(2, feedback);
			pst.setInt(3, pid);
			int count = pst.executeUpdate();
			if (count == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MyProject getProjectByID(int pid) {
		String sql = "SELECT * FROM PROJECTINFO WHERE PID = ?";
		MyProject project = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			while (rs.next()) {
				project = new MyProject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public Student loginStudent(String email, String password) {
		String sql = "SELECT * FROM STUDENTINFO WHERE email = ? and password = ?";
		Student student = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<MyProject> getProjectsByStatus(String status) {
		String sql = "SELECT * FROM PROJECTINFO WHERE status = ?";
		List<MyProject> pList = new ArrayList<>();
		MyProject project = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			rs = pst.executeQuery();
			while (rs.next()) {
				project = new MyProject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

				pList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public List<MyProject> getAllProjects() {
		String sql = "SELECT * FROM PROJECTINFO";
		List<MyProject> pList = new ArrayList<>();
		MyProject project = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				project = new MyProject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

				pList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public List<MyProject> searchProject(String str) {
		List<MyProject> allProjects = getAllProjects();
		String usn = null, title = null;
		List<MyProject> pList = new ArrayList<>();
		for (MyProject project : allProjects) {
			usn = project.getUsn();
			title = project.getPtitle();
			if (usn.equalsIgnoreCase(str) || usn.contains(str) || title.equalsIgnoreCase(str) || title.contains(str)) {
				pList.add(project);
			}
		}
		return pList;
	}

	@Override
	public boolean addReport(ProjectReport report) {
		String sql = "INSERT INTO projectreport (USN,PHASE,REPORT,TITLE) VALUES (?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, report.getUsn());
			pst.setInt(2, report.getPhase());
			pst.setBytes(3, report.getReport());
			pst.setString(4, report.getTitle());
			int rows = pst.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getReport(int phase, String title) {
		String sql = "SELECT REPORT FROM projectreport WHERE PHASE = ? AND TITLE = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, phase);
			pst.setString(2, title);
			rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
