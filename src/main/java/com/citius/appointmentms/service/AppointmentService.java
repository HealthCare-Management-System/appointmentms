package com.citius.appointmentms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citius.appointmentms.entity.Appointment;
import com.model.AppointmentDTO;

@Service
public interface AppointmentService {
	public AppointmentDTO bookAppointment(AppointmentDTO app);

	public AppointmentDTO updateAppointment(AppointmentDTO appointment, int id);

	public void deleteAppointment(int id);

	public AppointmentDTO findAppointmentById(int id);

	public List<AppointmentDTO> findAllAppointments();

//	public List<Appointment> findAppointmentByPatientId(int patientId);
//
//	public List<AppointmentDTO> getAppointmentByName(String name);

}
