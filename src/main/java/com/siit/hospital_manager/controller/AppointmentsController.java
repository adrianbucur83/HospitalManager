package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import com.siit.hospital_manager.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentsController {

    private final AppointmentService appointmentService;



    @GetMapping("/patient/{id}")
    public List<AppointmentDto> getByPatientId(@PathVariable("id") Integer id) {
        return appointmentService.findAllByPatientId(id);
    }

    @GetMapping
    public List<AppointmentDto> findAll(){
        return appointmentService.findAll();
    }

    // CREATE, UPDATE

    @PostMapping
    public void createAppointment(@RequestBody @Valid CreateAppointmentDto createAppointmentDto){
        appointmentService.createPatient(createAppointmentDto);
    }


}
