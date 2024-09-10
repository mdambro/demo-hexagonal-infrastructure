package com.mdambro.demo.infrastructure.rest.mapper;

import com.mdambro.demo.domain.User;
import com.mdambro.demo.infrastructure.rest.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = PhoneRESTMapper.class
)
public interface UserRESTMapper {

    User userDTOToUser(UserDTO user);

    UserDTO userToUserDTO(User user);

}
