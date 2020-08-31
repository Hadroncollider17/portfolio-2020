/**
 Author: Hayson Chu
 E-mail: hzc5389@psu.edu
 Course: CMPSC 221
 Assignment: Programming Assignment 2
 Due date: 2/18/2020
 File: TriviaGame.java
 Purpose: Java application that implements a simple trivia game on Naruto the anime.
 Compiler/IDE: Java 11.0.5/IntelliJ Idea 3.1
 Operating
 system: MacOS Mojave
 Reference(s): Java 10 API - Oracle Documentation
 (https://docs.oracle.com/javase/10/docs/api/);
 (Include ALL additional references (Web page, etc.) here.)
 https://mkyong.com/swing/java-swing-how-to-make-a-confirmation-dialog/
 https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 **/

/** Import Packages **/
import javax.swing.JOptionPane;
import java.util.Random;

/** Program Driver **/
public class TriviaGame {

    //trivia questions and answers
    private static final String[][] trivia = {{"Who gave Kakashi a Sharingan (full name)?", "Obito Uchiha"},
            {"What is Naruto's Chakra nature?", "Wind"},
            {"What kind of ninja is Sakura?", "Medical"},
            {"Who murdered his entire clan at 13 years old? (full name)", "Itachi Uchiha"},
            {"What is Konoha's most popular restaurant joint? (full name)", "Ramen Ichiraku"},
            {"What is the name of the evolved eye of the Sharingan?", "Mangekyou"},
            {"Who was the person Naruto respected the most?", "Iruka Sensei"},
            {"Which village is Naruto from? (english)", "Hidden Leaf Village"},
            {"Who is the highest scoring student on the ninja academy exam to date? (full name)", "Minato Namikaze"},
            {"What does \"Kage-Bunshin-No-Jutsu\" translate into?", "Multi-Shadow Clone Jutsu"}};

    //store random arrangement of trivia questions
    private static String[][] scramTrivia;

    /** Main Method **/
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Welcome to 'Naruto Shippuden Trivia Extravaganza!'");
        int i = 0;
        scramTrivia = randQAGenerator();
        //keeps new trivia questions coming until user clicks cancel or says they don't want to continue
        //or when trivia questions run out.
        do{
            if(checkEmpty(i))
                break;
            QuestionAndAnswer game = new QuestionAndAnswer();
            assignQAndA(game, i);
            askPlayerQA(game);
            i++;
        } while(askRepeat());
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
        System.exit(0);
    }

    /** Method For Generating A Scrambled Trivia List **/
    public static String[][] randQAGenerator(){

        //trivia's array element at random number is copied as first element of new random trivia sequence,
        // and preceding trivia are copied in that order.
        String[][] scram = new String[10][2];
        Random rand = new Random();
        int rand_int = rand.nextInt(10);
        for(int i = 0; i < 10; i++){
            if(rand_int == 10)
                rand_int = 0;
            for(int j = 0; j < 2; j++){
                scram[i][j] = trivia[rand_int][j];
            }
            rand_int++;
        }
        return scram;
    }

    /** Method To Check If Trivia List Is Empty **/
    public static boolean checkEmpty(int i){

        //if list is empty ends the loop.
        if(i>=10){
            JOptionPane display = new JOptionPane();
            display.showMessageDialog(null, "Sorry, no more questions!");
            return true;
        }
        else return false;
    }

    /** Method To Ask Question And Check Answer **/
    public static void askPlayerQA(QuestionAndAnswer game){

        //simplification
        game.checkAnswer(game.displayQuestion());
    }

    /** Method To Simplify Assigning Question and Answer to QuestionAndAnswer Class **/
    public static void assignQAndA(QuestionAndAnswer game, int i){

        //more simplification
        game.setQuestion(scramTrivia[i][0]);
        game.setAnswer(scramTrivia[i][1]);
    }

    /** Method To Ask User If They Want To Play Again **/
    public static boolean askRepeat(){

        //displays question if user wants to play again, can only choose (y/n) or cancel. cancel exits system.
        boolean repeat = true;
        JOptionPane display = new JOptionPane();
        int confirm = display.showConfirmDialog(null,"Play Again? (Y/N)", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
        switch(confirm){
            case 0:
                repeat = true;
                break;
            case 1:
                repeat = false;
                break;
            case 2:
                System.exit(0);
                break;
        }
        return repeat;
    }

}
