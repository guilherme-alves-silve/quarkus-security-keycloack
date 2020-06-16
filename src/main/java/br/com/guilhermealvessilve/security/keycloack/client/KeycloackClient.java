package br.com.guilhermealvessilve.security.keycloack.client;

import br.com.guilhermealvessilve.security.keycloack.data.UserToken;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "config.api.keycloack")
@Path("/protocol/openid-connect/token")
public interface KeycloackClient {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    UserToken getUserToken(
            @HeaderParam("Authorization") String basicAuth,
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("grant_type") String grantType
    );
}
