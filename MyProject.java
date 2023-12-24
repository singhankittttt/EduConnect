package com.proj.domain;

public class MyProject {

	private int id;
	private String usn, ptitle, type, pabstract, status, feedback, team;

	public MyProject(int id, String usn, String ptitle, String type, String pabstract, String status, String feedback,
			String team) {
		super();
		this.id = id;
		this.usn = usn;
		this.ptitle = ptitle;
		this.type = type;
		this.pabstract = pabstract;
		this.status = status;
		this.feedback = feedback;
		this.team = team;
	}

	public MyProject(String usn, String ptitle, String type, String pabstract, String team) {
		super();
		this.usn = usn;
		this.ptitle = ptitle;
		this.type = type;
		this.pabstract = pabstract;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public String getUsn() {
		return usn;
	}

	public String getPtitle() {
		return ptitle;
	}

	public String getType() {
		return type;
	}

	public String getPabstract() {
		return pabstract;
	}

	public String getStatus() {
		return status;
	}

	public String getFeedback() {
		return feedback;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "MyProject [id=" + id + ", usn=" + usn + ", ptitle=" + ptitle + ", type=" + type + ", pabstract="
				+ pabstract + ", status=" + status + ", feedback=" + feedback + ", team=" + team + "]";
	}
	
	

}
