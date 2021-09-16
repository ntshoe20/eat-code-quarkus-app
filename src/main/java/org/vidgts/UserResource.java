package org.vidgts;

import org.vidgts.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/users")
public class UserResource {

    private Set<User> users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public UserResource() {
        users.add(new User("Itumeleng", "Ntshoe"));
        users.add(new User("Mali", "Peaches"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<User> list() {
        return users;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<User> addUser(User person){
        users.add(person);
        return users;
    }
}