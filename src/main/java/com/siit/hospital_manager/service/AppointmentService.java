package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Appointment;
import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import com.siit.hospital_manager.model.dto.UpdateAppointmentDto;
import com.siit.hospital_manager.repository.AppointmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentsRepository appointmentsRepository;

    public List<AppointmentDto> findAllByPatientId(Integer id) {
        List<Appointment> appointments = appointmentsRepository.findAllByPatientId(id);

       return appointments
                .stream()
                .map(Appointment::toDto)
                .toList();
    }

    public List<AppointmentDto> findAll() {
        return appointmentsRepository.findAll()
                .stream()
                .map(Appointment::toDto)
                .toList();
    }

    public void createAppointment(CreateAppointmentDto createAppointmentDto) {
        appointmentsRepository.save(new Appointment(createAppointmentDto));
    }

    public void updateAppointment(UpdateAppointmentDto updateAppointmentDto) {
        Appointment appointment = appointmentsRepository
                .findById(updateAppointmentDto.getId())
                .orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, "Appointment with id " + updateAppointmentDto.getId() + " not found"));
        appointment.setDate(updateAppointmentDto.getDate());
        appointmentsRepository.save(appointment);
    }
}
