package com.citius.appointmentms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citius.appointmentms.entity.Appointment;
import com.citius.appointmentms.repo.AppointmentRepo;
import com.citius.appointmentms.service.AppointmentService;
import com.model.AppointmentDTO;
import com.model.PatientDetailsDto;
import com.model.UserDto;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo repo;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AppointmentDTO bookAppointment(AppointmentDTO app) {
		AppointmentDTO app1 =  app;
  System.out.println(app1);
		return convertEntityToDto(repo.save(convertDtoToEntity(app)));
	}

	@Override
	public AppointmentDTO updateAppointment(AppointmentDTO appointment, int id) {
		
		return convertEntityToDto(repo.save(convertDtoToEntity(appointment)));
	}

	@Override
	public void deleteAppointment(int id) {
		repo.deleteById(id);

	}

	@Override
	public AppointmentDTO findAppointmentById(int id) {

		return convertEntityToDto(repo.findById(id).get());

	}

	@Override
	public List<AppointmentDTO> findAllAppointments() {
		List<AppointmentDTO> dtolist = new ArrayList<>();
		List<Appointment> applist = repo.findAll();
		for (Appointment app : applist) {
			dtolist.add(convertEntityToDto(app));
	}
		return dtolist;
	}

	@Override
	public List<AppointmentDTO> findAppointmentByPatientId(int patientId) {
		List<AppointmentDTO> dtolist = new ArrayList<>();
		List<Appointment> applist = repo.findByPatientIdInfo(patientId);
		for (Appointment app : applist) {
			dtolist.add(convertEntityToDto(app));
	}
		return dtolist;
		
	}

	@Override
	public List<AppointmentDTO> findAppointmentByPhysicianIdInfo(int phy_id) {
		
		List<AppointmentDTO> dtolist = new ArrayList<>();
		List<Appointment> applist = repo.findByPhysicianIdInfo(phy_id);
		for (Appointment app : applist) {
			dtolist.add(convertEntityToDto(app));
	}
		return dtolist;
		
	}

	public UserDto getUserDtoFromUserMs(int id) {

		ResponseEntity<UserDto> response = restTemplate.getForEntity("http://localhost:8081/users/users/" + id,
				UserDto.class);
		return response.getBody();
	}
	
	public PatientDetailsDto getPatientInfoDtoFromPatientMs(int id) {		
		ResponseEntity<PatientDetailsDto> response = restTemplate.getForEntity("http://localhost:8084/patientdetails/user/"+id,
				PatientDetailsDto.class);
		return response.getBody();
	}

	public AppointmentDTO convertEntityToDto(Appointment app) {

		AppointmentDTO dto = new AppointmentDTO();
		dto.setAppid(app.getAppid());
		dto.setTitle(app.getTitle());
		dto.setDescription(app.getDescription());
		dto.setTime(app.getTime());
		dto.setAppointmentDate(app.getAppointmentDate());		
		dto.setPatientIdInfo(getPatientInfoDtoFromPatientMs(app.getPatientIdInfo()));
		dto.setPhysicianIdInfo(getUserDtoFromUserMs(app.getPhysicianIdInfo()));

		return dto;

	}

	public Appointment convertDtoToEntity(AppointmentDTO appdto) {
		Appointment app = new Appointment();
		app.setAppid(appdto.getAppid());
		app.setTitle(appdto.getTitle());
		app.setDescription(appdto.getDescription());
		app.setTime(appdto.getTime());
		app.setAppointmentDate(appdto.getAppointmentDate());
		

		app.setPatientIdInfo(appdto.getPatientIdInfo().getId());
		app.setPhysicianIdInfo(appdto.getPhysicianIdInfo().getId());

		return app;
	}

}
