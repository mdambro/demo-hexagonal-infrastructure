package com.mdambro.demo.infrastructure.jpa.mapper;

import com.mdambro.demo.domain.Phone;
import com.mdambro.demo.infrastructure.jpa.entity.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PhoneJPAMapper {

    Phone phoneEntityToPhone(PhoneEntity phone);

    PhoneEntity phoneToPhoneEntity(Phone phone);

}
