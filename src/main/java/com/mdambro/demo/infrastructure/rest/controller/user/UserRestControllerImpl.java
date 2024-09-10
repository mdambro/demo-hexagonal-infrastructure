package com.mdambro.demo.infrastructure.rest.controller.user;

import com.mdambro.demo.infrastructure.rest.controller.user.constant.SignUpApiConstants;
import com.mdambro.demo.infrastructure.rest.dto.ErrorDTO;
import com.mdambro.demo.infrastructure.rest.dto.UserDTO;
import com.mdambro.demo.infrastructure.rest.mapper.UserRESTMapper;
import com.mdambro.demo.application.adapter.input.user.UserSignUpInputAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "User REST endpoint", description = "Api used for manage users.")
public class UserRestControllerImpl implements UserRestController {

    private UserSignUpInputAdapter userSignUpInputAdapter;

    private UserRESTMapper userRESTMapper;

    @Override
    @PostMapping(path = SignUpApiConstants.SIGN_UP_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = SignUpApiConstants.SIGN_UP_ENDPOINT_OPERATION_SUMMARY,
            description = SignUpApiConstants.SIGN_UP_ENDPOINT_OPERATION_DESCRIPTION,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class),
                            examples = {@ExampleObject(value = SignUpApiConstants.SIGN_UP_REQUEST_EXAMPLE)}
                    )
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = SignUpApiConstants.SIGN_UP_RESPONSE_SUCCESS_CODE,
                            description = SignUpApiConstants.SIGN_UP_RESPONSE_SUCCESS_MESSAGE,
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserDTO.class),
                                    examples = {@ExampleObject(value = SignUpApiConstants.SIGN_UP_RESPONSE_SUCCESS_EXAMPLE)}
                            )
                    ),
                    @ApiResponse(
                            responseCode = SignUpApiConstants.SIGN_UP_RESPONSE_BAD_REQUEST_CODE,
                            description = SignUpApiConstants.SIGN_UP_RESPONSE_BAD_REQUEST_MESSAGE,
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDTO.class),
                                    examples = {@ExampleObject(value = SignUpApiConstants.SIGN_UP_RESPONSE_BAD_REQUEST_EXAMPLE)}
                             )
                    ),
                    @ApiResponse(
                            responseCode = SignUpApiConstants.SIGN_UP_RESPONSE_ERROR_CODE,
                            description = SignUpApiConstants.SIGN_UP_RESPONSE_ERROR_MESSAGE,
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDTO.class),
                                    examples = {@ExampleObject(value = SignUpApiConstants.SIGN_UP_RESPONSE_ERROR_EXAMPLE)}
                             )
                    )
            }
    )
    public ResponseEntity<UserDTO> signUp(@Valid @RequestBody UserDTO user) {

        return ResponseEntity.ok()
                .body(
                    userRESTMapper.userToUserDTO(
                        userSignUpInputAdapter.signUp(userRESTMapper.userDTOToUser(user))
                    )
                );

    }

}
