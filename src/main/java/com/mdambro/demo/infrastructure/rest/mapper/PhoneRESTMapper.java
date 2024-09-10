package com.mdambro.demo.infrastructure.rest.mapper;

import com.mdambro.demo.domain.Phone;
import com.mdambro.demo.infrastructure.rest.dto.PhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PhoneRESTMapper {

    Phone phoneDTOToPhone(PhoneDTO phone);

    PhoneDTO phoneToPhoneDTO(Phone phone);

}
