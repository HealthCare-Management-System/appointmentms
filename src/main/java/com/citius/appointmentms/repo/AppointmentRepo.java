package com.citius.appointmentms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citius.appointmentms.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer>{

	List<Appointment> findByPatientIdInfo(int patientId);
	List<Appointment> findByPatientIdInfoAndStatus(int patientId,String status);

	List<Appointment> findByPhysicianIdInfo(int phy_id);
	List<Appointment> findByPhysicianIdInfoAndStatus(int phy_id,String status);

	
}
