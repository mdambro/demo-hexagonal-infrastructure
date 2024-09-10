package com.mdambro.demo.infrastructure.jpa.repository;

import com.mdambro.demo.application.repository.UserRepository;
import com.mdambro.demo.domain.User;
import com.mdambro.demo.infrastructure.jpa.mapper.UserJPAMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private UserEntityRepository userEntityRepository;

    private UserJPAMapper userJPAMapper;

    @Override
    public User saveNewUser(User user) {

        var userEntity = userJPAMapper.userToUserEntity(user);

        return userJPAMapper.userEntityToUser(
                userEntityRepository.saveAndFlush(userEntity)
        );

    }

    @Override
    public User findUserByEmail(String email) {

        var userFromDB = userEntityRepository.findUserByEmail(email);

        if(userFromDB == null || userFromDB.getEmail().isBlank())
            return null;

        return userJPAMapper.userEntityToUser(userFromDB);

    }

}
