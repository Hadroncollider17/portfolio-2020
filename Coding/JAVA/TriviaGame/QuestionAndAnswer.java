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

/** QuestionAndAnswer Class **/
public class QuestionAndAnswer {

    String question, answer;

    /** Constructor **/
    public QuestionAndAnswer(){
        question = "";
        answer = "";
    }

    /** Method Sets Instance Variable 'question' **/
    public void setQuestion(String question){
        this.question = question;
    }

    /** Method Sets Instance Variable 'answer' **/
    public void setAnswer(String answer){
        this.answer = answer;
    }

    /** Method Checks if User Answer is Correct and Gets Rid of Whitespaces and Capitalisation **/
    public void checkAnswer(String answer){
        JOptionPane display = new JOptionPane();
        String noSpace, rightAnswer = this.answer;
        if (answer==null) {
            display.showMessageDialog(null, "Quitter.");
        }
        else{
            noSpace = answer.trim();
            if(rightAnswer.equalsIgnoreCase(noSpace))
                display.showMessageDialog(null, "That's right! Noice.");
            else
                display.showMessageDialog(null,"Nope :(");
        }
    }


    /** Method Displays Question and receives answer **/
    public String displayQuestion(){
        JOptionPane display = new JOptionPane();
        return display.showInputDialog(question);
    }


}


