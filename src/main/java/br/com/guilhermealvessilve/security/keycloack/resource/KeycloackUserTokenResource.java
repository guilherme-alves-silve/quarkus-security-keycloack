package br.com.guilhermealvessilve.security.keycloack.resource;

import br.com.guilhermealvessilve.security.keycloack.client.KeycloackClient;
import br.com.guilhermealvessilve.security.keycloack.data.UserToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/token")
public class KeycloackUserTokenResource {

    private final KeycloackClient keycloackClient;

    @Inject
    public KeycloackUserTokenResource(@RestClient KeycloackClient keycloackClient) {
        this.keycloackClient = keycloackClient;
    }

    /**
     * Used to get the user token from Keycloack.
     * An example below using curl.
     * <pre>
     *     curl --location --request GET 'http://localhost:8080/token' \
     *          --header 'Authorization: Basic cXVhcmt1cy1zZWN1cml0eS1zZXJ2aWNlOnNlY3JldA==' \
     *          --header 'username: user' \
     *          --header 'password: user' \
     *          --header 'grant_type: password'
     * </pre>
     * Observation.: "cXVhcmt1cy1zZWN1cml0eS1zZXJ2aWNlOnNlY3JldA==" is equal to "quarkus-security-service:secret" but encoded in Base64
     * @param authorization "Basic cXVhcmt1cy1zZWN1cml0eS1zZXJ2aWNlOnNlY3JldA=="
     * @param username "user" or "admin"
     * @param password "user" or "admin"
     * @param grantType "password"
     * @return UserToken JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserToken getUserToken(
            @HeaderParam("Authorization") final String authorization,
            @HeaderParam("username") final String username,
            @HeaderParam("password") final String password,
            @HeaderParam("grant_type") final String grantType
    ) {
        return keycloackClient.getUserToken(authorization, username, password, grantType);
    }
}
