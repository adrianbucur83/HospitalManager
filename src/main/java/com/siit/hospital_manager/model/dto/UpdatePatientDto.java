package com.siit.hospital_manager.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdatePatientDto {

    Integer id;

    @Range(min = 0, max = 120)
    private Integer age;

}
