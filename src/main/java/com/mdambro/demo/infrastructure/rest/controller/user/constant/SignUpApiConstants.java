package com.mdambro.demo.infrastructure.rest.controller.user.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpApiConstants {

    public static final String SIGN_UP_ENDPOINT = "/user/sign-up";
    public static final String SIGN_UP_ENDPOINT_OPERATION_SUMMARY = "User Registration Endpoint.";
    public static final String SIGN_UP_ENDPOINT_OPERATION_DESCRIPTION = "Receives a UserDTO json object to save it in the data base.";

    public static final String SIGN_UP_REQUEST_EXAMPLE =
            "{\n"+
                    "  \"name\": \"Homero Simpson\",\n"+
                    "  \"email\": \"hsimpson@fox.com\",\n"+
                    "  \"password\": \"pAss-W0rd\",\n"+
                    "  \"token\": \"zxCvC5321tuYkluy6l7S\",\n"+
                    "  \"phones\": [\n"+
                    "    {\n"+
                    "      \"number\": \"54\",\n"+
                    "      \"contrycode\": \"11\",\n"+
                    "      \"citycode\": \"123456789\"\n"+
                    "    }\n"+
                    "  ]\n"+
                    "}";
    public static final String SIGN_UP_RESPONSE_SUCCESS_CODE = "200";
    public static final String SIGN_UP_RESPONSE_SUCCESS_MESSAGE = "Ok";
    public static final String SIGN_UP_RESPONSE_SUCCESS_EXAMPLE =
            "{\n"+
                    "  \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n"+
                    "  \"name\": \"Homero Simpson\",\n"+
                    "  \"email\": \"simpson@gmail.com\",\n"+
                    "  \"password\": \"pAss-W0rd\",\n"+
                    "  \"token\": \"zxCvC5321tuYkluy6l7S\",\n"+
                    "  \"created\": \"2024/09/09 09:25:39\",\n"+
                    "  \"modified\": null,\n"+
                    "  \"lastLogin\": \"2024/09/09 09:25:39\",\n"+
                    "  \"isActive\": true,\n"+
                    "  \"phones\": [\n"+
                    "    {\n"+
                    "      \"number\": \"+54\",\n"+
                    "      \"contrycode\": \"11\",\n"+
                    "      \"citycode\": \"12 35689\"\n"+
                    "    }\n"+
                    "  ]\n"+
                    "}";
    public static final String SIGN_UP_RESPONSE_BAD_REQUEST_CODE = "400";
    public static final String SIGN_UP_RESPONSE_BAD_REQUEST_MESSAGE = "Bad Request.";
    public static final String SIGN_UP_RESPONSE_BAD_REQUEST_EXAMPLE = "{\"message\": \"User is null.\"}";
    public static final String SIGN_UP_RESPONSE_ERROR_CODE = "500";
    public static final String SIGN_UP_RESPONSE_ERROR_MESSAGE = "Internal Server Error.";
    public static final String SIGN_UP_RESPONSE_ERROR_EXAMPLE = "{\"message\": \"Internal server error.\"}";

}
