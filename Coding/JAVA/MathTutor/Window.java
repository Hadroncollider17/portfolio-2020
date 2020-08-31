/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 5
Due date: 4/14/2020
File: Window.java
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

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public Window(){
        super();
        setSize(WIDTH,HEIGHT);
        setTitle("Math Tutor");
        JButton next = new JButton("Next Problem");
        next.addActionListener(this);
        add(next); 
    }

    public void actionPerformed(ActionEvent e){

    }
}
