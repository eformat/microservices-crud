package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;

import javax.persistence.Entity;

@Entity
public class Movie extends PanacheEntity {

    public String title;

    public Movie(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie() {
    }

    public static Multi<Movie> findAll(PgPool client) {
        return client.query("SELECT id, title FROM movie ORDER BY title ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(Movie::from);
    }

    private static Movie from(Row row) {
        return new Movie(row.getLong("id"), row.getString("title"));
    }
}
