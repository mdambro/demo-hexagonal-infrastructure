package com.mdambro.demo.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Schema(description = "User representation.")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @Schema(description = "ID.")
    private UUID id;

    @Schema(description = "Name.")
    @NotNull(message = "The name is mandatory.")
    @NotEmpty(message = "The name can not be empty.")
    private String name;

    @Schema(description = "Email.")
    @NotNull(message = "The email is mandatory.")
    @NotEmpty(message = "The email can not be empty.")
    @Email(message = "Email should be valid." )
    private String email;

    @Schema(description = "Password.")
    @NotNull(message = "The password is mandatory.")
    @NotEmpty(message = "The password can not be empty.")
    @Pattern(
            regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-_]).{8,}$",
            message = "The password must contain only 1 mandatory capital letter and only 2 mandatory numbers."
            /*
            * This regex will enforce these rules:
            * At least one upper case English letter, (?=.*?[A-Z])
            * At least one lower case English letter, (?=.*?[a-z])
            * At least one digit, (?=.*?[0-9])
            * At least one special character, (?=.*?[#?!@$%^&*-_])
            * Minimum eight in length .{8,} (with the anchors)
            * */
    )
    private String password;

    @Schema(description = "Token.")
    private String token;

    @Schema(description = "Creation date.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy HH:mm:ss")
    private Date created;

    @Schema(description = "Last modified date.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy HH:mm:ss")
    private Date modified;

    @Schema(description = "Last login date.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy HH:mm:ss")
    private Date lastLogin;

    @Schema(description = "Active flag.")
    private Boolean isActive;

    @Schema(description = "Phones list.")
    @NotNull(message = "The phones list is mandatory.")
    @NotEmpty(message = "The phones list can not be empty.")
    private List<PhoneDTO> phones;

}
