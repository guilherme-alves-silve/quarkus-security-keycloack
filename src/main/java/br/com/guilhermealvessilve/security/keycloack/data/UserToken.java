package br.com.guilhermealvessilve.security.keycloack.data;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class UserToken {

    @JsonbProperty("access_token")
    private String accessToken;

    @JsonbProperty("expires_in")
    private Integer expiresIn;

    @JsonbProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    @JsonbProperty("refresh_token")
    private String refreshToken;

    @JsonbProperty("token_type")
    private String tokenType;

    @JsonbProperty("not-before-policy")
    private String notBeforePolicy;

    @JsonbProperty("session_state")
    private String sessionState;

    private String scope;

}
