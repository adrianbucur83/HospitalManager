package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateAppointmentDto {

    private Integer id;
    private LocalDateTime date;

}
