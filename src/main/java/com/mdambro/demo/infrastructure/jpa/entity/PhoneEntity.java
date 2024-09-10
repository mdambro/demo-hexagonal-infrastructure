package com.mdambro.demo.infrastructure.jpa.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Phone")
@Table(
        name = "MY_PHONE",
        indexes = {
                @Index(
                        name = "idx_myphone_userid",
                        columnList = "user_id"
                )
        }
)
public class PhoneEntity implements Serializable {

    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "BINARY(16)"
    )
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "number")
    private String number;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "country_code")
    private String countryCode;

}
