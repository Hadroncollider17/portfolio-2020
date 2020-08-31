/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 3/31/2020
File: MovieAndAwardWinnerMovie.java
Purpose: Java application that implements a driver to demonstrate the
 functionality of a base class (Movie) and its derived class
 (AwardWinningMovie)
Compiler/IDE: Java 13/IntelliJIdea
Operating system: MacOS
Reference(s): Java 10 API - Oracle Documentation
 (http://docs.oracle.com/javase/10/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/

/**Imports**/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**Driver Program**/
public class MovieAndAwardWinnerMovie {

/**
 * Movies in Database
 1. Joker;8.5;Crime;Todd Phillips;Joaquin Phoenix;Golden Globe;2020;
 2. Parasite;8.6;Thriller;Bong Joon Ho;Kang-ho Song;AcademyAward;2020;
 3. Social Network;7.7;The Social Network;Biography;David Fincher;Jesse Eisenberg;Academy Award;2012;
 4. The Grand Budapest Hotel;8.1;Adventure;Wes Anderson;Ralph Fiennes;BAFTA;2015;
 5. Weathering With You;7.6;Drama;Makoto Shinkai;Kotaro Daigo;Japan Academy Prize;2020;
 6. Spirited Away;8.6;Adventure;Hayao Miyazaki;Rumi Hiiragi;Academy Award;2003;
 7. The Dark Knight;9.0;Action;Christopher NOlan;Christian Bale;Academy Award;2009;
 8. Forrest Gump;8.8;Drama;Robert Zemeckis;Tom Hanks;Academy Award;1995;
 9. Pulp Fiction;8.9;Crime;Quentin Tarantino;Samuel L. Jackson;Golden Globe;1995;
 10. Django Unchained;8.4;Western;Quentin Tarantino;Jamie Foxx;Academy Award;2013;
 **/

    /**Main Method**/
    public static void main(String[] args){
        ArrayList <AwardWinningMovies> database = new <AwardWinningMovies> ArrayList();
        database = createDatabase(database);

        programWelcome();
        programInterface(database);
    }

    /**Method To Create Database**/
    public static ArrayList<AwardWinningMovies> createDatabase(ArrayList<AwardWinningMovies> database){
        //database of movies
        String[] movies = {
                "Joker;8.5;Crime;Todd Phillips;Joaquin Phoenix;Golden Globe;2020;",
                "Parasite;8.6;Thriller;Bong Joon Ho;Kang-ho Song;AcademyAward;2020;",
                "The Social Network;7.7;Biography;David Fincher;Jesse Eisenberg;Academy Award;2012;",
                "The Grand Budapest Hotel;8.1;Adventure;Wes Anderson;Ralph Fiennes;BAFTA;2015;",
                "Weathering With You;7.6;Drama;Makoto Shinkai;Kotaro Daigo;Japan Academy Prize;2020;",
                "Spirited Away;8.6;Adventure;Hayao Miyazaki;Rumi Hiiragi;Academy Award;2003;",
                "The Dark Knight;9.0;Action;Christopher NOlan;Christian Bale;Academy Award;2009;",
                "Forrest Gump;8.8;Drama;Robert Zemeckis;Tom Hanks;Academy Award;1995;",
                "Pulp Fiction;8.9;Crime;Quentin Tarantino;Samuel L. Jackson;Golden Globe;1995;",
                "Django Unchained;8.4;Western; Quentin Tarantino;Jamie Foxx;Academy Award;2013;"
        };

        //converts String elements to AwardWinningMovies inside ArrayList.
        ArrayList<AwardWinningMovies> store = new <AwardWinningMovies> ArrayList();
        for(int i = 0; i<movies.length; i++){
            String name, rating, genre, director, actor, award;
            int awardYear;
            String save = movies[i];
            String[] split = save.split(";",9);
            name = split[0];
            rating = split[1];
            genre = split[2];
            director = split[3];
            actor = split[4];
            award = split[5];
            awardYear = Integer.parseInt(split[6]);
            store.add(new AwardWinningMovies(name, rating, genre, director, actor, award, awardYear));
        }
        return store;
    }

    /**Method to Welcome User**/
    public static void programWelcome(){
        System.out.println("RUNNING \'EXPERIMENTAL MOVIE DATABASE\'");
        System.out.println("--------------------------------------------------------------");
    }

    /**Method to Generate Interface**/
    public static void programInterface(ArrayList<AwardWinningMovies> database){
        boolean exit = false;

        //presents options to user and asks for their choice.
        while(!exit){
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("\nSelect an option from the menu below");
            System.out.println("1) Display a list of popular movies\n2) Search the database\n3) Exit");
            System.out.println("Your answer: ");

            //validates user input and executes method according to choice.
            Scanner scan = new Scanner(System.in);
            try{
                int scanned = scan.nextInt();
                if (scanned >= 1 && scanned <= 3) {
                    switch (scanned) {
                        case 1:
                            displayMovies(database);
                            break;
                        case 2:
                            searchMovies(database);
                            break;
                        case 3:
                            exit = exitProgram();
                            break;
                        default:
                            exit = false;
                            break;
                    }
                } else {
                    exit = false;
                    System.out.println("Please input a valid integer (ie. 1, 2, 3)");
                    System.out.println("--------------------------------------------------------------");
                }
            }
            catch(Exception e){
                exit = false;
                System.out.println("Please input an integer (ie. 1, 2, 3)");
                System.out.println("--------------------------------------------------------------");
            }
        }
    }

    /**Method to Display Movies**/
    public static void displayMovies(ArrayList<AwardWinningMovies> database){
        //lists movies in the database and exit option.
        boolean exit = false;
        while(!exit){
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("\nSelected award-winning movies:");
            int i = 0, scanned;
            Scanner scan = new Scanner(System.in);
            Iterator<AwardWinningMovies> iter = database.iterator();
            while(iter.hasNext()){
                AwardWinningMovies temp = iter.next();
                i++;
                System.out.println(i + ") " + temp.getTitle());
            }
            i++;
            System.out.println(i + ") " + "Exit");

            System.out.println("\nPlease enter number of movie you would like to know more about, or exit: ");
            AwardWinningMovies temp2 = null;

            //validates input and lists more detailed information about movies.
            try{
                scanned = scan.nextInt();
                if(scanned >= 0 && scanned <= i) {
                    if(scanned == i+1){
                        exit = true;
                        break;
                    }
                    temp2 = database.get(scanned-1);
                    System.out.println("Title: " + temp2.getTitle());
                    System.out.println("Rating: " + temp2.getRating());
                    System.out.println("Director: " + temp2.getDirector());
                    System.out.println("Star: " + temp2.getStar());
                    System.out.println("Award: " + temp2.getAwardTitle() + " (" + temp2.getAwardYear() + ")");

                    //asks user if they want to repeat detailed information.
                    boolean valid = false;
                    String answer = "";
                    while(!valid){
                        System.out.println("\nInquire about other movies (Y/N)?");
                        answer = scan.next();
                        if(!((answer.equalsIgnoreCase("Y")||answer.equalsIgnoreCase("N")))){
                            System.out.println("Please input either \'Y\' or \'N\'");
                            valid = false;
                        }
                        else {
                            if (answer.equalsIgnoreCase("Y"))
                                exit = false;
                            else
                                exit = true;
                            valid = true;
                        }
                    }
                }
                else{
                    exit = false;
                    System.out.println("Please input a valid integer (ie. 1, 2, 3)");
                    System.out.println("--------------------------------------------------------------");
                }
            }
            catch(Exception e){
                exit = false;
                System.out.println("Please input an integer (ie. 1, 2, 3)");
                System.out.println("--------------------------------------------------------------");
            }
        }
    }

    /**Method to Search Movies By Title or Star**/
    public static void searchMovies(ArrayList<AwardWinningMovies> database){
        //displays options and validates if answer is 't' or 's' or 'e'.
        boolean exit = false;
        while(!exit){
            Scanner scan = new Scanner(System.in);
            String answer = "";
            boolean valid = false;
            while(!valid){
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("\nType T to search by title or S to search by star or E for exit: ");
                answer = scan.next();
                answer = answer.toLowerCase();
                if(!(answer.equals("t")||answer.equals("s")||answer.equals("e"))){
                    System.out.println("Please input either 'T' or 'S' or 'E'");
                    valid = false;
                }
                else
                    valid = true;
            }

            //gives search input according to option given by user and searches through database.
            String answer2 = "";
            Iterator<AwardWinningMovies> iter = database.iterator();
            switch(answer){
                case "t":
                    boolean foundT = false;
                    System.out.println("Please enter a movie title: ");
                    answer2 = scan.nextLine();
                    answer2 = scan.nextLine();
                    while(iter.hasNext()){
                        AwardWinningMovies temp = iter.next();
                        if(temp.getTitle().equalsIgnoreCase(answer2)){
                            System.out.println("Title: " + temp.getTitle());
                            System.out.println("Rating: " + temp.getRating());
                            System.out.println("Director: " + temp.getDirector());
                            System.out.println("Star: " + temp.getStar());
                            System.out.println("Award: " + temp.getAwardTitle() + " (" + temp.getAwardYear() + ")");
                            foundT = true;
                            exit = true;
                            break;
                        }
                    }
                    if(!foundT)
                        System.out.println("That title does not exist in the database.");
                    break;
                case "s":
                    boolean foundS = false;
                    System.out.println("Please enter a movie title: ");
                    answer2 = scan.nextLine();
                    answer2 = scan.nextLine();
                    while(iter.hasNext()){
                        AwardWinningMovies temp = iter.next();
                        if(temp.getStar().equalsIgnoreCase(answer2)){
                            System.out.println("Title: " + temp.getTitle());
                            System.out.println("Rating: " + temp.getRating());
                            System.out.println("Director: " + temp.getDirector());
                            System.out.println("Star: " + temp.getStar());
                            System.out.println("Award: " + temp.getAwardTitle() + " (" + temp.getAwardYear() + ")");
                            foundS = true;
                            exit = true;
                            break;
                        }
                    }
                    if(!foundS)
                        System.out.println("That title does not exist in the database.");
                    break;
                case "e":
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**Method for Exit Messages**/
    public static boolean exitProgram(){
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Thank you for using \'EXPERIMENTAL MOVIE DATABASE\'");
        return true;
    }
}
