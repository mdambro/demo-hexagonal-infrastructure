package com.mdambro.demo.infrastructure.jpa.repository;

import com.mdambro.demo.infrastructure.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    @Query( "SELECT user " +
            "  FROM User user " +
            " WHERE LOWER( TRIM( user.email ) ) = LOWER( TRIM( :email ) )"
    )
    UserEntity findUserByEmail(@Param("email") String email);

}
