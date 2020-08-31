/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 5
Due date: 4/14/2020
File: MathTutor.java
Purpose: Java GUI application that helps an elementary school
 student learn addition, subtraction, and multiplication
Compiler/IDE: Java 11.0.5/Apache NetBeans IDE 11.2
Operating
system: MacOS
Reference(s): Java 10 API - Oracle Documentation
 (http://docs.oracle.com/javase/10/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/

package mathtutor;

public class MathTutor {

    private static int rand1, rand2, operation;

    public static void main(String[] args){
    }

    public static void generateProblem(){
        operation = (int)(Math.random()*(3-1+1)+1);
        rand1 = (int)((Math.random()*(10-1+1)+1));
        rand2 = (int)((Math.random()*(10-1+1)+1));
    }

    public static void generateWindow(){
        Window window = new Window();
        window.setVisible(true);
    }

    public static boolean checkAnswer(int answer){
        switch(operation){
            case 1:
                return answer == (rand1 + rand2);
            case 2:
                return answer == (rand1 - rand2);
            case 3:
                return answer == (rand1 * rand2);
            default:
                return false;
        }
    }

}
