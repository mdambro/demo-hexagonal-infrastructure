package com.mdambro.demo.infrastructure.rest.controller.user;

import com.mdambro.demo.application.adapter.input.user.UserSignUpInputAdapter;
import com.mdambro.demo.infrastructure.InfrastructureApplication;
import com.mdambro.demo.infrastructure.rest.controller.user.constant.SignUpApiConstants;
import com.mdambro.demo.infrastructure.rest.controller.user.mock.UserMocked;
import com.mdambro.demo.infrastructure.rest.dto.ErrorDTO;
import com.mdambro.demo.infrastructure.rest.dto.UserDTO;
import com.mdambro.demo.infrastructure.rest.mapper.UserRESTMapper;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = InfrastructureApplication.class
)
@ActiveProfiles("dev")
@AutoConfigureWebTestClient(timeout = "20000")
class UserRestControllerImplTest {

    @MockBean
    private UserSignUpInputAdapter userSignUpInputAdapter;

    @Autowired
    private UserRESTMapper userRESTMapper;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void signUp_resultOk() {

        when(userSignUpInputAdapter.signUp(any())).thenReturn(UserMocked.getSavedUserMocked());

        webTestClient.post()
                .uri(uriBuilder -> uriBuilder.path(SignUpApiConstants.SIGN_UP_ENDPOINT).build())
                .header("content-type","application/json")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(UserMocked.getCorrectUserMocked())
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(UserDTO.class);

    }

    @Test
    void signUp_resultBadRequest() {

        when(userSignUpInputAdapter.signUp(any())).thenThrow(BusinessRuleException.class);

        webTestClient.post()
                .uri(uriBuilder -> uriBuilder.path(SignUpApiConstants.SIGN_UP_ENDPOINT).build())
                .header("content-type","application/json")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(UserMocked.getCorrectUserMocked())
                .exchange()
                .expectStatus()
                .is4xxClientError()
                .expectBody(ErrorDTO.class);

    }

    @Test
    void signUp_resultInternalServerError() {

        when(userSignUpInputAdapter.signUp(any())).thenThrow(NullPointerException.class);

        webTestClient.post()
                .uri(uriBuilder -> uriBuilder.path(SignUpApiConstants.SIGN_UP_ENDPOINT).build())
                .header("content-type","application/json")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(UserMocked.getCorrectUserMocked())
                .exchange()
                .expectStatus()
                .is5xxServerError()
                .expectBody(ErrorDTO.class);

    }

}
