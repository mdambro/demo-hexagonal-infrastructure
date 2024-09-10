package com.mdambro.demo.infrastructure.jpa.mock;

import com.mdambro.demo.infrastructure.jpa.entity.PhoneEntity;
import com.mdambro.demo.infrastructure.jpa.entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntityMocked {

    public static UserEntity getUserEntity() {

        return UserEntity.builder()
                .id(UUID.randomUUID())
                .name("Mocked Name")
                .email("mocked@mocked.com")
                .password("m0ck3d_passw0rd")
                .token("x2cvG5dsd858S")
                .created(new Date())
                .lastLogin(new Date())
                .modified(null)
                .isActive(true)
                .phones(Set.of(
                        PhoneEntity.builder()
                                .id(UUID.randomUUID())
                                .countryCode("+54")
                                .cityCode("11")
                                .number("111111")
                                .build()
                )).build();

    }

}
