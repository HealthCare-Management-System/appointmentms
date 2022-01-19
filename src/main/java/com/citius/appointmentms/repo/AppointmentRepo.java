package com.citius.appointmentms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citius.appointmentms.entity.Appointment;
import com.model.AppointmentDTO;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer>{

//	List<Appointment> findBypatientIdInfo(int patientId);

//	List<Appointment> findByPatientId(int patientId);
//
//	List<Appointment> findByPhysicianName(String name);

	
}
