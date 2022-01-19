package com.citius.appointmentms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private int appid;

	@Column(name = "meeting_title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "appointment_time")
	private String time;

	@Column(name = "appointment_date")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date appointmentDate;

	@Column(name = "patient_id_info")
	private int patientIdInfo;

	@Column(name = "physician_id_info")
	private int physicianIdInfo;

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

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getPatientIdInfo() {
		return patientIdInfo;
	}

	public void setPatientIdInfo(int patientIdInfo) {
		this.patientIdInfo = patientIdInfo;
	}

	public int getPhysicianIdInfo() {
		return physicianIdInfo;
	}

	public void setPhysicianIdInfo(int physicianIdInfo) {
		this.physicianIdInfo = physicianIdInfo;
	}

}
