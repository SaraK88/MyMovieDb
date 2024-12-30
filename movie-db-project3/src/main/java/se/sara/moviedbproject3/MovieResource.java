//name of the package this class belongs to
package se.sara.moviedbproject3;

//DI, imported classes
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.sara.moviedbproject3.model.Movie;
import java.util.List;

//@name of the path in the URL
@Path("/movies")
//Name and the opening of the class
public class MovieResource {
    // Injects the MovieRepository for accessing the database
    @Inject
    private MovieRepository movieRepository;

    //GET request handler for finding entities in the database
    @GET
    //Produces annotation creating a specific type of information
    //in this case media type which is JSON format (text format)
    @Produces(MediaType.APPLICATION_JSON)
    //method for finding movies
    public List <Movie> getMovies() {
        return movieRepository.findMovies();
    }

    //POST request handler for adding new entities on the list
    @POST
    //Consumes data in JSON format
    //Produces data in JSON format
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //Method for adding new entities
    public Response addMovie(Movie movie) {
        movieRepository.createMovie(movie);
        return Response.status(Response.Status.CREATED)
                //returning message when the entity is created
                .entity("Movie successfully added")
                .build();
    }

    //PUT request handler for updating entities in the  repository
    @PUT
    //The path in the URL for reaching the specific entity based on its ID
    @Path("/{id}")
    //Consumes data in JSON format
    //Produces data in JSON format
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    //Method for updating the entity
    public Response updateMovie(@PathParam("id") Long id, Movie uppdateMovie) {
        Movie existingMovie = movieRepository.findById(id);//finding movie by ID
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Movie not found").build();
        } // Returns a 404 if the movie doesn't exist
        //setters of updating the information
        existingMovie.setMovieTitle(uppdateMovie.getMovieTitle());
        existingMovie.setProductionYear(uppdateMovie.getProductionYear());
        existingMovie.setGenre(uppdateMovie.getGenre());
        existingMovie.setDirector(uppdateMovie.getDirector());
        existingMovie.setSynopsis(uppdateMovie.getSynopsis());
        movieRepository.updateMovie(existingMovie);
        //return message if entity successfully updated
        return Response.ok("Movie successfully updated").build();
    }

    //Delete request handler for deleting the entity from the repository
    @DELETE
    //The path in the URL for reaching the specific entity based on its ID
    @Path("/{id}")
    //Consumes data in JSON format
    //Produces data in JSON format
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    //Method for deleting the entity
    public Response deleteMovie (@PathParam("id") Long id) {
        Movie existingMovie = movieRepository.findById(id); //finding the entity by ID
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Movie not found").build();
        }// Returns a 404 if the movie doesn't exist
        movieRepository.deleteMovie(id); //deleting the movie form the repository
        return Response.ok("Movie successfully deleted").build();
    } //return a message for successfull deleting

}
