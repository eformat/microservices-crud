package org.acme;

import io.smallrye.mutiny.Multi;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class MovieResource {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @GET
    public Multi<Movie> getAll() {
        return Movie.findAll(client);
    }

}
