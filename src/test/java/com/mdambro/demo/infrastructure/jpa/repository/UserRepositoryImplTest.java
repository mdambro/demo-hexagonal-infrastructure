package com.mdambro.demo.infrastructure.jpa.repository;

import com.mdambro.demo.application.repository.UserRepository;
import com.mdambro.demo.infrastructure.jpa.mock.UserEntityMocked;
import com.mdambro.demo.infrastructure.jpa.mock.UserMocked;
import com.mdambro.demo.infrastructure.jpa.mapper.UserJPAMapper;
import com.mdambro.demo.infrastructure.jpa.repository.UserEntityRepository;
import com.mdambro.demo.infrastructure.jpa.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserRepositoryImplTest {

    @Mock
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserJPAMapper userJPAMapper;

    private UserRepository userRepository;

    @Test
    void saveNewUser_ok() {

        when(userEntityRepository.saveAndFlush(any())).thenReturn(UserEntityMocked.getUserEntity());

        userRepository =
                UserRepositoryImpl.builder()
                        .userEntityRepository(userEntityRepository)
                        .userJPAMapper(userJPAMapper)
                        .build();

        assertDoesNotThrow(() -> userRepository.saveNewUser(UserMocked.getCorrectUserMocked()));

    }

    @Test
    void saveNewUser_unexpectedError() {

        when(userEntityRepository.saveAndFlush(any())).thenThrow(RuntimeException.class);

        userRepository =
                UserRepositoryImpl.builder()
                        .userEntityRepository(userEntityRepository)
                        .userJPAMapper(userJPAMapper)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertThrows(
                RuntimeException.class,
                () -> userRepository.saveNewUser(user)
        );

    }

    @Test
    void findUserByEmail_okAndUserExists() {

        when(userEntityRepository.findUserByEmail(anyString())).thenReturn(UserEntityMocked.getUserEntity());

        userRepository =
                UserRepositoryImpl.builder()
                        .userEntityRepository(userEntityRepository)
                        .userJPAMapper(userJPAMapper)
                        .build();

        assertDoesNotThrow(() -> userRepository.findUserByEmail(UserMocked.getCorrectUserMocked().getEmail()));

    }

    @Test
    void findUserByEmail_okButDoesNotReturnAUser() {

        when(userEntityRepository.findUserByEmail(anyString())).thenReturn(null);

        userRepository =
                UserRepositoryImpl.builder()
                        .userEntityRepository(userEntityRepository)
                        .userJPAMapper(userJPAMapper)
                        .build();

        assertDoesNotThrow(() -> userRepository.findUserByEmail(UserMocked.getCorrectUserMocked().getEmail()));

    }

    @Test
    void findUserByEmail_unexpectedError() {

        when(userEntityRepository.findUserByEmail(anyString())).thenThrow(RuntimeException.class);

        userRepository =
                UserRepositoryImpl.builder()
                        .userEntityRepository(userEntityRepository)
                        .userJPAMapper(userJPAMapper)
                        .build();

        var email = UserMocked.getCorrectUserMocked().getEmail();

        assertThrows(
                RuntimeException.class,
                () -> userRepository.findUserByEmail(email)
        );

    }

}
