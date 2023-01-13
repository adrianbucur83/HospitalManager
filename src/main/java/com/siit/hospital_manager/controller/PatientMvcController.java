package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.dto.CreatePatientDto;
import com.siit.hospital_manager.model.dto.PatientDto;
import com.siit.hospital_manager.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/mvc/patient")
public class PatientMvcController {

    private final PatientService patientService;
    @GetMapping("/viewAll")
    public String getAllPatients(Model model) {
        List<PatientDto> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient/viewAll";
    }

    @GetMapping("/create")
    public String showCreatePatientForm(Model model) {
        CreatePatientDto createPatientDto = new CreatePatientDto();
        model.addAttribute("createPatientDto", createPatientDto);
        return "patient/create";
    }

    @PostMapping("/submit")
    public String createPatient(@Valid CreatePatientDto createPatientDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "validationError";
        }
        model.addAttribute("createPatientDto", createPatientDto);
        patientService.createPatient(createPatientDto);
        return "success";
    }
}
