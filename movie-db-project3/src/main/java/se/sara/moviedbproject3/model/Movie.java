//This is a movie class
//It's a blueprint av information that is going to help me
//create new movies, but also find them in my database, update and delete.

//This class is a part of subpackage model
package se.sara.moviedbproject3.model;

//Here I import persistence class that is in charge of creating database
import jakarta.persistence.*;

// "@" here symbol means this is an annotation
//Annotations are helping us by reducing "boilerplate code" and
//specify and define methods or classes functionality

//Entity means that its databases entity
@Entity
//Specifies the nane of the column in the
@Table(name = "movies2")
//the actual class opening and its name
public class Movie {

    //@Id and generatedValue means that program generates id by its self
    //and how it generates it -GenerationType
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    //@Column and the name of the column in the table
    @Column(name = "id", nullable= false)
    //Creating unique id for each movie
    private Long id;

    //movie attributes
    private String movieTitle; //Name
    private String genre;
    private int productionYear;
    private String synopsis;
    private String director;

    //empty constructor that every entity class must have
    public Movie() {
    }

    //constructor with parameters for creating instances with certain value
    public Movie(Long id, String genre, String movieTitle, int productionYear, String synopsis, String director) {
        this.id = id;
        this.genre = genre;
        this.movieTitle = movieTitle;
        this.productionYear = productionYear;
        this.synopsis = synopsis;
        this.director = director;
    }

    //the following getter methods enabling to reach the information of the private values
    public Long getId() {
        return id;
    }
    //the following setters to update or modify the value
    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
