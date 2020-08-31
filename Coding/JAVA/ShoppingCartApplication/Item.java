/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/3/2020
File: Item.java
Purpose: Item class to store item values.
Compiler/IDE: IntelliJ IDEA Ultimate 2019
Operating
system: MacOS
Reference(s): Java 8 API - Oracle Documentation
 (http://docs.oracle.com/javase/8/docs/api/)
(Include ALL additional references (Web page, etc.) here.)
*/

/** Item Class **/
public class Item {

    /** Item Instance Variables **/
    private int itemNum;
    private String itemName;
    private String itemCategory;
    private double itemPrice;
    private int itemQuantity;

    /** Default Constructor **/
    public Item() {
        itemNum = 0;
        itemName = "";
        itemCategory = "";
        itemPrice = 0.0;
        itemQuantity = 1;
    }

    /** Constructor with Custom Initialising **/
    public Item(int num, String name, String category, double price, int quantity) {
        itemNum = num;
        itemName = name;
        itemCategory = category;
        itemPrice = price;
        itemQuantity = quantity;
    }

    /** Accessor for ItemNum **/
    public int getItemNum(){
        return itemNum;
    }

    /** Accessor for ItemName **/
    public String getItemName(){
        return itemName;
    }

    /** Accessor for ItemCategory **/
    public String getItemCategory(){
        return itemCategory;
    }

    /** Accessor for ItemPrice **/
    public double getItemPrice(){
        return itemPrice;
    }

    /** Accessor for ItemQuantity **/
    public int getItemQuantity(){
        return itemQuantity;
    }

    /** Modifier for ItemNum **/
    public void setItemNum(int itemNum){
        this.itemNum = itemNum;
    }

    /** Modifier for ItemName **/
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /** Modifier for ItemCategory **/
    public void setItemCategory(String itemCategory){
        this.itemCategory = itemCategory;
    }

    /** Modifier for ItemPrice **/
    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    /** Modifier for ItemQuantity **/
    public void setItemQuantity(int itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    /** toString method **/
    public String toString(){
        return itemNum + "\n" + itemName + "\n" + itemCategory + "\n" + itemPrice + "\n" + itemQuantity;
    }
}
