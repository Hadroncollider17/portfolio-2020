/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 3/31/2020
File: Movie.java
Purpose: Superclass Movie
Compiler/IDE: Java 13/IntelliJIdea
Operating system: MacOS
Reference(s): Java 10 API - Oracle Documentation
 (http://docs.oracle.com/javase/10/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/

/**Superclass**/
public class Movie {
    /**Instance Variables**/
    private String title;
    private String rating;
    private String genre;
    private String director;
    private String star;

    /**Default Constructor**/
    public Movie(){
        title = "";
        rating = "";
        genre = "";
        director = "";
        star = "";
    }

    /**Parameterized Constructor**/
    public Movie(String title, String rating, String genre, String director, String star){
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.star = star;
    }

    /**Get Methods**/
    public String getTitle(){
        return title;
    }

    public String getRating(){
        return rating;
    }

    public String getGenre(){
        return genre;
    }

    public String getDirector(){
        return director;
    }

    public String getStar(){
        return star;
    }

    /**Set Methods**/
    public void setTitle(String title){
        this.title = title;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setStar(String star){
        this.star = star;
    }

    /**Equals Method**/
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(getClass()!= otherObject.getClass())
            return false;
        else{
            Movie otherMovie = (Movie)otherObject;
            return((title.equals(otherMovie.title))&&(rating.equals(otherMovie.rating))
                    &&(genre.equals(otherMovie.genre))&&(director.equals(otherMovie.director))
                    &&(star.equals(otherMovie.star)));
        }
    }

    /**toString Method**/
    @Override
    public String toString(){
        return(title + " " + rating + " " + genre + " " + director + " " + star);
    }
}
