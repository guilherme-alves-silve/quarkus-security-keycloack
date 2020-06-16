package br.com.guilhermealvessilve.security.keycloack.resource;

import br.com.guilhermealvessilve.security.keycloack.data.Info;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
public class KeycloackSimpleProfileResource {

    @GET
    @PermitAll
    @Path("/public")
    public Info getPublic() {
        return new Info("Some public");
    }

    @GET
    @Path("/username")
    @RolesAllowed({"user", "admin"})
    public Info getUserName() {
        return new Info("Some user");
    }

    @GET
    @DenyAll
    @Path("/private")
    public Info getPrivate() {
        return new Info("This is private");
    }
}
