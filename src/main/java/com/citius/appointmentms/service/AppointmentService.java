package com.citius.appointmentms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.AppointmentDTO;

@Service
public interface AppointmentService {
	public AppointmentDTO bookAppointment(AppointmentDTO app);

	public AppointmentDTO updateAppointment(AppointmentDTO appointment, int id);

	public void deleteAppointment(int id);

	public AppointmentDTO findAppointmentById(int id);
	
	public Boolean changeStatusOfMeetingById(int id);

	public List<AppointmentDTO> findAllAppointments();

   public List<AppointmentDTO> findAppointmentByPatientId(int patientId);
   public List<AppointmentDTO> findAppointmentByPatientIdAndStatus(int patientId,String status);

	public List<AppointmentDTO>findAppointmentByPhysicianIdInfo(int phy_id);
	public List<AppointmentDTO>findAppointmentByPhysicianIdInfoAndStatus(int phy_id,String status);

	
}
