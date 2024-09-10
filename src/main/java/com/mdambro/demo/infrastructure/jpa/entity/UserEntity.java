package com.mdambro.demo.infrastructure.jpa.entity;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "User")
@Table(
        name = "MY_USER",
        indexes = {
                @Index(
                        name = "idx_myuser_email",
                        columnList = "email",
                        unique = true
                )
        }
)
public class UserEntity implements Serializable {

    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "BINARY(16)"
    )
    @GeneratedValue
    private UUID id;

    @Column(name = "created", columnDefinition="TIMESTAMP")
    private Date created;

    @Column(name = "last_login", columnDefinition="TIMESTAMP")
    private Date lastLogin;

    @Column(name = "modified", columnDefinition="TIMESTAMP")
    private Date modified;

    @Column(name = "token")
    private String token;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "name")
    private String name;

    @NotNull(message = "The email is mandatory")
    @NotEmpty(message = "The email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "The password is mandatory")
    @NotEmpty(message = "The password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    private Set<PhoneEntity> phones;

}
