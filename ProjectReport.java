package com.proj.domain;


public class ProjectReport {
	private int id;
	private String usn;
	private int phase;
	private String title;
	private byte[] report;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getReport() {
		return report;
	}
	public void setReport(byte[] report) {
		this.report = report;
	}
	public ProjectReport(int id, String usn, int phase, String title, byte[] report) {
		super();
		this.id = id;
		this.usn = usn;
		this.phase = phase;
		this.title = title;
		this.report = report;
	}
	
	
}
