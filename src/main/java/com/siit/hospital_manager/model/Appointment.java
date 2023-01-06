package com.siit.hospital_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@RequiredArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    public Appointment(CreateAppointmentDto createAppointmentDto) {
        this.date = createAppointmentDto.getDate();
        this.patient = createAppointmentDto.getPatient();
    }

    public AppointmentDto toDto(){
        return AppointmentDto
                .builder()
                .id(id)
                .date(date)
                .patient(patient)
                .build();
    }
}
