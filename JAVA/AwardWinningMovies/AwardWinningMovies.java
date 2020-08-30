/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 3/31/2020
File: AwardWinningMovies.java
Purpose: Subclass of Movie Superclass
Compiler/IDE: Java 13/IntelliJIdea
Operating system: MacOS
Reference(s): Java 10 API - Oracle Documentation
 (http://docs.oracle.com/javase/10/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/

/**Subclass of Movie**/
public class AwardWinningMovies extends Movie{
    private String awardTitle;
    private int awardYear;

    /**Default Constructor**/
    public AwardWinningMovies(){
        super();
        awardTitle = "";
        awardYear = 0000;
    }

    /**Parameterized Constructor**/
    public AwardWinningMovies(String title, String rating, String genre, String director, String star,
                              String awardTitle, int awardYear){
        super(title, rating, genre, director, star);
        this.awardTitle = awardTitle;
        this.awardYear = awardYear;
    }

    /**Get Methods**/
    public String getAwardTitle(){
        return awardTitle;
    }

    public int getAwardYear(){
        return awardYear;
    }

    /**Set Methods**/
    public void setAwardTitle(String awardTitle){
        this.awardTitle = awardTitle;
    }

    public void setAwardYear(int awardYear){
        this.awardYear = awardYear;
    }

    /**Equals Method**/
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            AwardWinningMovies otherMovies = (AwardWinningMovies) otherObject;
            return((getTitle().equals(otherMovies.getTitle()))&&(getRating().equals(otherMovies.getRating()))
                    &&(getGenre().equals(otherMovies.getGenre()))&&(getDirector().equals(otherMovies.getDirector()))
                    &&(getStar().equals(otherMovies.getStar()))&&(getAwardTitle().equals(otherMovies.getAwardTitle()))
                    &&(getAwardYear()==otherMovies.getAwardYear()));
        }
    }

    /**toString Method**/
    @Override
    public String toString(){
        return(getTitle() + ", " + getRating() + ", " + getDirector() + ", " + getStar() +
                ", " + getAwardTitle() + ", " + getAwardYear());
    }
}
