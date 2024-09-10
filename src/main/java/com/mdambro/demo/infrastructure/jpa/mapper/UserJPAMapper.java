package com.mdambro.demo.infrastructure.jpa.mapper;

import com.mdambro.demo.domain.User;
import com.mdambro.demo.infrastructure.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = PhoneJPAMapper.class
)
public interface UserJPAMapper {

    User userEntityToUser(UserEntity user);

    UserEntity userToUserEntity(User user);

}
