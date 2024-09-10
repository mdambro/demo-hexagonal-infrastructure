package com.mdambro.demo.infrastructure.rest.controller.user;

import com.mdambro.demo.infrastructure.rest.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserRestController {

    ResponseEntity<UserDTO> signUp(UserDTO user);

}
