package com.model;

public class AppointmentDTO {
	private int appid;
	private String title;
	private String description;
	private String time;
	private String appointmentDate;
	private String status;
	private PatientDetailsDto patientIdInfo;
	private UserDto physicianIdInfo;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
    
	
	
	
	public PatientDetailsDto getPatientIdInfo() {
		return patientIdInfo;
	}
	public void setPatientIdInfo(PatientDetailsDto patientIdInfo) {
		this.patientIdInfo = patientIdInfo;
	}
	public UserDto getPhysicianIdInfo() {
		return physicianIdInfo;
	}
	public void setPhysicianIdInfo(UserDto physicianIdInfo) {
		this.physicianIdInfo = physicianIdInfo;
	}
	
}
