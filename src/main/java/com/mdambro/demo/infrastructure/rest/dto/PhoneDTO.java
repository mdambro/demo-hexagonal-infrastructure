package com.mdambro.demo.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema(description = "Phone.")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneDTO {

    @Schema(description = "Country code.")
    @JsonProperty("contrycode")
    @NotNull(message = "The name is mandatory.")
    private String countryCode;

    @Schema(description = "City code.")
    @JsonProperty("citycode")
    @NotNull(message = "The name is mandatory.")
    private String cityCode;

    @Schema(description = "Number.")
    @NotNull(message = "The name is mandatory.")
    private String number;

}
