/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/3/2020
File: Sorted.java
Purpose: Sorted class to store items in their categories
Compiler/IDE: IntelliJ IDEA Ultimate 2019
Operating
system: MacOS
Reference(s): Java 8 API - Oracle Documentation
 (http://docs.oracle.com/javase/8/docs/api/)
(Include ALL additional references (Web page, etc.) here.)
*/

/** Imports **/
import java.util.ArrayList;

/** Sorted Class **/
public class Sorted {

    /** Sorted Instance Variables **/
    private ArrayList<Item> list = new ArrayList<Item>();
    private String category;

    /** Default Constructor **/
    public Sorted(){
        list = null;
        category = "";
    }

    /** Constructor with Custom Initialising **/
    public Sorted(ArrayList<Item>list, String category){
        this.list = list;
        this.category = category;
    }

    /** Accessor for List **/
    public ArrayList<Item> getList(){
        return list;
    }

    /** Accessor for Category **/
    public String getCategory(){
        return category;
    }

    /** Modifier for List **/
    public void setList(ArrayList<Item> list){
        this.list = list;
    }

    /** Modifier for Category **/
    public void setCategory(String category){
        this.category = category;
    }
}
