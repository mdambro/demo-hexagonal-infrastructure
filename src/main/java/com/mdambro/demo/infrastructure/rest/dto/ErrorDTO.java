package com.mdambro.demo.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Error representation.")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    @Schema(description = "Error message.")
    @JsonProperty("mensaje")
    private String message;

}
