package br.com.guilhermealvessilve.security.keycloack.resource;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/keycloack")
@Produces(MediaType.APPLICATION_JSON)
public class KeycloackUserResource {

    private final SecurityIdentity securityIdentity;

    @Inject
    public KeycloackUserResource(SecurityIdentity securityIdentity) {
        this.securityIdentity = securityIdentity;
    }

    /**
     * You need to call the /token resource first to get the token,
     * and pass in the Authorization header the value got from "access_token" in
     * the JSON.
     * Example:
     * <pre>
     *     curl --location --request GET 'http://localhost:8080/keycloack/user' \
     *          --header 'Authorization: Bearer {{access_token_here}}' \
     *          --header 'Cookie: q_auth=6b0b55ce-50d5-4986-ad68-9e1477079ca5; q_auth=0b1372e4-019b-45bf-b6ec-3ffd5d07a162'
     * </pre>
     * @return security identity JSON object from the user
     */
    @GET
    @NoCache
    @Path("/user")
    @RolesAllowed("user")
    public SecurityIdentity getUserInfo() {
        return securityIdentity;
    }

    /**
     * You need to call the /token resource first to get the token but with admin credentials,
     * and pass in the Authorization header the value got from "access_token" in
     * the JSON.
     * Example:
     * <pre>
     *     curl --location --request GET 'http://localhost:8080/keycloack/admin' \
     *          --header 'Authorization: Bearer {{access_token_here}}' \
     *          --header 'Cookie: q_auth=6b0b55ce-50d5-4986-ad68-9e1477079ca5; q_auth=0b1372e4-019b-45bf-b6ec-3ffd5d07a162'
     * </pre>
     * @return security identity JSON object from the admin
     */
    @GET
    @NoCache
    @Path("/admin")
    @RolesAllowed("admin")
    public SecurityIdentity getAdminInfo() {
        return securityIdentity;
    }
}
