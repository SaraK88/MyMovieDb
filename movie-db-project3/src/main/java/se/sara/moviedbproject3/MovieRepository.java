//name of the package this class belongs to
package se.sara.moviedbproject3;

//DI, imported classes
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import se.sara.moviedbproject3.model.Movie;

import java.util.ArrayList;
import java.util.List;

// @ApplicationScoped means this class is a singleton in the application.
// It is created once and can be accessed from anywhere in the application.
@ApplicationScoped
//Transactional ensures that all database operations are executed.
@Transactional

// This is MovieRepository class.
// Its performing database operations such as creating, reading,
// updating, and deleting movie records.

public class MovieRepository {

    //Persistence is injecting entity manager and saving the data
    //so it doesn't get lost
    @PersistenceContext

    //entityManager is an object in charge of saving, retrieving,
    //updating, and deleting data in the database.
    private EntityManager entityManager;

    //method to find all movies in the database
    public List<Movie> findMovies() {
        //SQL query is a command written in SQL (Structured Query Language)
        // to interact with a database.
        // This SQL query is to select all rows from the "movies2" table.
        String sql = "SELECT * FROM movies2";
        //Command to create a native query using entity manager
        Query query = entityManager.createNativeQuery(sql);
        //Retrieving all the information from the query and returning them
        List<Movie> movies = query.getResultList();
        return movies;
    }

    //Method for creating a new entity(movie)
    public void createMovie(Movie movie) {
        entityManager.persist(movie);
    }
    //method for finding an entity by Id
    public Movie findById(Long id) {
        return entityManager.find(Movie.class, id);
    }
    //Method for updating an entity
    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }
    //method for deleting an entity

    public void deleteMovie(Long id) {
        entityManager.remove(entityManager.find(Movie.class, id));

    }

}
