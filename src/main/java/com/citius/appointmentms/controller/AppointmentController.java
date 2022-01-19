package com.citius.appointmentms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citius.appointmentms.service.AppointmentService;
import com.model.AppointmentDTO;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

	@Autowired
	private AppointmentService service;

	@Autowired
	public AppointmentController(AppointmentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/ping")
	public String greetings() {
		return "Working";
	}
	@GetMapping("")
	public List<AppointmentDTO> AllAppointments() {
		return service.findAllAppointments();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AppointmentDTO> findAppointmentById(@PathVariable Integer id) {
	    try {
    	AppointmentDTO app = service.findAppointmentById(id);
	        return new ResponseEntity<AppointmentDTO>(app, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<AppointmentDTO>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/save")
	public AppointmentDTO newAppointment(@RequestBody AppointmentDTO app) {
		return service.bookAppointment(app);
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<?>  updatAppoinment(@PathVariable("id")int id,@RequestBody AppointmentDTO app) {
		try {
			AppointmentDTO exist=service.findAppointmentById(id);
			service.bookAppointment(app);
			return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }    
	}

	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable("id")int id) {
		service.deleteAppointment(id);
	}
	
	@GetMapping("/patient/{id}")
	public List<AppointmentDTO> getAllAppointmentByPatientId(@PathVariable("id") int patientId){
		return service.findAppointmentByPatientId(patientId);
	}
	@GetMapping("/physician/{id}")
	public List<AppointmentDTO>getAppointmentByPhysicianId(@PathVariable("id") int physician_id){
		return service.findAppointmentByPhysicianIdInfo(physician_id);
	}
	
}
