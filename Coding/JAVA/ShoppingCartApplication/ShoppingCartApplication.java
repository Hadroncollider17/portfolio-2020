/*
Author: Hayson Chu
E-mail: hzc5389@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/3/2020
File: ShoppingCartApplication.java
Purpose: Java application that implements an online store complete
 with shopping cart and check out procedure
Compiler/IDE: IntelliJ IDEA Ultimate 2019
Operating
system: MacOS
Reference(s): Java 8 API - Oracle Documentation
 (http://docs.oracle.com/javase/8/docs/api/)
(Include ALL additional references (Web page, etc.) here.)
*/

//Part 2: Create/Add to/Remove from Shopping Cart. After creating the store inventory, the program
//        welcomes the customer, then provides him/her with a menu of options for creating a shopping cart,
//        adding items to or removing items from the shopping cart, or checking out. Creating a shopping cart
//        entails creating an empty shopping cart. Adding an item to the shopping cart entails searching the
//        store inventory first by category then by item to locate an item to add. (If the customer chooses to
//        add an item that is already in the cart, simply increase the quantity by one.) Removing an item from
//        the shopping cart entails displaying the current contents of the shopping cart, then prompting the
//        customer to enter the number of the item to remove. The shopping cart must be displayed after each
//        addition or removal. All customer input must be validated. try-catch blocks must be used to
//        handle unchecked exceptions. The program continues to display the main menu until the customer
//        decides to check out.

/** Imports **/
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/** Program Driver **/
public class ShoppingCartApplication {

    /** Instance Variable **/
    /* Stores inventory for store */
    private static ArrayList<Item> storeInventory = new ArrayList<Item>();
    private static ArrayList<Sorted> sortedStore = new ArrayList<Sorted>();

    /** Main **/
    public static void main(String[] args){
        boolean proceed = true;
        ArrayList<Item> shoppingCart = null;
        createInventory();
        welcome();
        while(proceed) {
            switch(menuPage()){
                case 1:
                    shoppingCart = createShoppingCart(shoppingCart);
                    break;
                case 2:
                    try{
                        addItem(shoppingCart);
                    }catch(Exception e){
                        System.out.println("Back to Main Menu\n");
                    }
                    break;
                case 3:
                    try{
                        removeItem(shoppingCart);
                    }catch(Exception e){
                        System.out.println("Back to Main Menu\n");
                    }
                    break;
                case 4:
                    proceed = checkOut(shoppingCart);
                    break;
                default:
                    break;
            }
        }
    }

    /** Method to Create Store Inventory From TXT File and Sorts Them Into Categories **/
    public static void createInventory(){
        /* Attempt to import data from text file for store inventory */
        Scanner reader = null;
        try {
            reader = new Scanner(new FileInputStream("ShoppingInventory.txt"));
        }
        catch(Exception e) {
            System.out.println("Sorry, ShoppingInventory file couldn't be found or something else went wrong");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while(reader.hasNext()) {
            Item temp = new Item();
            temp.setItemNum(reader.nextInt());
            reader.nextLine(); //to read \n
            temp.setItemName(reader.nextLine());
            temp.setItemCategory(reader.nextLine());
            temp.setItemPrice(reader.nextDouble());
            temp.setItemQuantity(reader.nextInt());
            storeInventory.add(temp);
        }

        for(int i = 0; i < storeInventory.size(); i++){
            Item temp = storeInventory.get(i);
            String category = temp.getItemCategory();

            if(sortedStore.isEmpty()){
                ArrayList<Item> temp2 = new ArrayList<Item>();
                temp2.add(temp);
                Sorted temp3 = new Sorted(temp2, category);
                sortedStore.add(temp3);
            }
            else{
                boolean same = false;
                for(int j = 0; j < sortedStore.size(); j++){
                    Sorted save = sortedStore.get(j);
                    if(category.equalsIgnoreCase(save.getCategory())){
                        sortedStore.remove(j);
                        ArrayList<Item> save2 = save.getList();
                        save2.add(temp);
                        save.setList(save2);
                        sortedStore.add(save);
                        same = true;
                        break;
                    }
                }
                if(!same){
                    ArrayList<Item> temp2 = new ArrayList<Item>();
                    temp2.add(temp);
                    Sorted temp3 = new Sorted(temp2, category);
                    sortedStore.add(temp3);
                }
            }

        }

    }

    /** Method to Welcome Users **/
    public static void welcome(){
        System.out.println("Welcome to Book Affair Online!\n");
    }

    /** Method to Run Menu Page **/
    public static int menuPage(){
        boolean valid = false;
        int answer = 0;
        do {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Choose An Option:");
            System.out.println("1) Create an empty shopping cart");
            System.out.println("2) Add item to shopping cart");
            System.out.println("3) Remove item from shopping cart");
            System.out.println("4) Check out");
            System.out.println("\nYour choice: ");
            Scanner option = new Scanner(System.in);
            if(option.hasNextInt()) {
                answer = option.nextInt();
                if ((1 <= answer) && (4 >= answer))
                    valid = true;
            }
            if(!valid)
                System.out.println("Please enter a valid integer!");
        }while(!valid);
        return answer;
    }

    /** Method to Create Shopping Cart And Check If There Are Any Existing Shopping Carts And Create Sorted Objects
     To Help Sort Items Into List of Categories They Belong To **/
    public static ArrayList<Item> createShoppingCart(ArrayList<Item> shopCart){
        if(!(shopCart == null)){
            int answer;
            boolean valid = false;
            do{
                System.out.println("You already have a shopping cart.");
                System.out.println("Do you want to: \n1) Clear cart and make a new one? (No turning back!)" +
                        "\n2) Go back to main menu?");
                System.out.println("Your choice: ");
                Scanner option = new Scanner(System.in);
                if(option.hasNextInt()) {
                    answer = option.nextInt();
                    if ((1 <= answer) && (4 >= answer))
                        valid = true;
                }
                if(!valid)
                    System.out.println("Please enter a valid integer!");
            } while(!valid);
            return shopCart;
        }
        else{
            shopCart = new ArrayList<Item>();
            System.out.println("Shopping cart has been created!");
            return shopCart;
        }
    }

    /** Method to Run Add Item Feature, Will Display Categories And Items Within Those Categories For User
     To Choose From And Add To Shopping Cart **/
    public static void addItem(ArrayList<Item> shopCart)throws Exception{
        if(shopCart == null){
            System.out.println("You need to create a cart!");
            return;
        }

        int answer = -1;
        boolean valid = false;
        Scanner option = new Scanner(System.in);
        do {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Choose a category:");
            for (int i = 0; i < sortedStore.size(); i++) {
                Sorted temp = sortedStore.get(i);
                String category = temp.getCategory();
                System.out.println(i+1 + ") " + category);
            }
            if(option.hasNextInt()) {
                answer = option.nextInt();
                if ((1 <= answer) && (sortedStore.size() >= answer))
                    valid = true;
                if(answer == 0)
                    throw new Exception("Go to main menu");
            }
            if(!valid)
                System.out.println("Please enter a valid integer! Enter 0 to return to main menu.");
        } while(!valid);

        int answer2 = -1;
        boolean valid2 = false;
        Sorted hold = sortedStore.get(answer);
        ArrayList<Item> hold2 = hold.getList();
        do{
            for(int j = 0; j < hold2.size(); j++){
                Item hold3 = hold2.get(j);
                int itemNum = hold3.getItemNum();
                String itemName = hold3.getItemName();
                double itemPrice = hold3.getItemPrice();
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String priceFormated = formatter.format(itemPrice);
                System.out.println(itemNum + "\t" + itemName + "\t$" + priceFormated);
            }
            System.out.println("Enter the number of the item you wish to add: ");
            if(option.hasNextInt()) {
                answer2 = option.nextInt();
                if ((1 <= answer2)) {
                    for(int z = 0; z<hold2.size(); z++){
                        Item reserve = hold2.get(z);
                        if(reserve.getItemNum()==answer2){
                            valid2 = true;
                            break;
                        }
                    }
                }
                if(answer2 == 0)
                    throw new Exception("Go to main menu");
            }
            if(!valid2)
                System.out.println("Please enter a valid item number! Enter 0 to return to main menu.");
        } while(!valid2);

        Item compare;
        boolean found = false;
        for(int j = 0; j < hold2.size(); j++){
            Item rest = hold2.get(j);
            if(rest.getItemNum()==answer2) {
                found = true;
                if(rest.getItemQuantity()>0){
                    if(shopCart.isEmpty()){
                        Item rest2 = new Item(rest.getItemNum(),rest.getItemCategory(),rest.getItemName(),
                                rest.getItemPrice(), 1);
                        shopCart.add(rest2);
                    }
                    else{
                        boolean inShopCart = false;
                        int count = -1;
                        for(int k = 0; k<shopCart.size(); k++){
                            Item save = shopCart.get(k);
                            if(rest.getItemNum()== save.getItemNum()) {
                                inShopCart = true;
                                count = k;
                            }
                        }
                        if(inShopCart){
                            Item save2 = shopCart.get(count);
                            int quantity = save2.getItemQuantity();
                            Item rest2 = new Item(rest.getItemNum(),rest.getItemCategory(),rest.getItemName(),
                                    rest.getItemPrice(), quantity);
                            shopCart.add(rest2);
                        }
                    }

                    System.out.println("Your choice: \"#" + rest.getItemNum() + " " +
                            rest.getItemName() + "\" has been added to the shopping cart");
                    rest.setItemQuantity(rest.getItemQuantity()-1);
                    for(int k = 0; k < shopCart.size(); k++){
                        Item store = shopCart.get(k);
                        double itemPrice = rest.getItemPrice();
                        NumberFormat formatter = NumberFormat.getCurrencyInstance();
                        String priceFormated = formatter.format(itemPrice);
                        System.out.println("\n\nNumber: #" + store.getItemNum()
                                +"\nName: " + store.getItemName() + "\nCategory: " + store.getItemCategory() +
                                "\n Price: $" + priceFormated + "\nQuantity: " + store.getItemQuantity());
                    }
                    break;
                }
                else{
                    System.out.println("Sorry, item \"#" + rest.getItemNum()
                            + " " + rest.getItemName() + "\" has run out.");
                }
            }
        }
        if (found = false)
            System.out.println("Sorry, item #" + answer2 + " does not exist.");
    }

    public static void removeItem(ArrayList<Item> shopCart)throws Exception{
        if(shopCart == null){
            System.out.println("You need to create a cart!");
            return;
        }
        if(shopCart.isEmpty()){
            System.out.println("There's nothing in your cart!");
            return;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Displaying contents of your shopping cart: ");
        boolean valid = false;
        int answer = -1;
        Scanner scan = new Scanner(System.in);
        do{
            for(int i = 0; i<shopCart.size(); i++){
                Item store = shopCart.get(i);
                double itemPrice = store.getItemPrice();
                String priceFormated = formatter.format(itemPrice);
                System.out.println("\n\n" + "Number: " + store.getItemNum() + "\nName: " + store.getItemName() +
                        "\nCategory: "+ store.getItemCategory() + "\nPrice: $" + priceFormated + "\nQuantity: " +
                        store.getItemQuantity());
            }
            System.out.println("Your choice: ");
            if(scan.hasNextInt()) {
                answer = scan.nextInt();
                if ((1 <= answer) && (sortedStore.size() >= answer))
                    valid = true;
                if(answer == 0)
                    throw new Exception("Go to main menu");
            }
            if(!valid)
                System.out.println("Please enter a valid item Number! Enter 0 to return to main menu.");

        }while(!valid);

        boolean exists = false;
        for(int k = 0; k<shopCart.size(); k++){
            Item store2 = shopCart.get(k);
            if(store2.getItemNum() == answer) {
                exists = true;
                break;
            }
        }
        if(!exists)
            System.out.println("Sorry, that item does not exist in your shopping cart.");
        else{
            System.out.println("Item #" + answer + " has been removed from your cart");
            int count =-1;
            for(int j = 0; j<shopCart.size(); j++){
                Item save = shopCart.get(j);
                if(save.getItemNum() == answer) {
                    count = j;
                    break;
                }
            }
            shopCart.remove(count);
            System.out.println("Displaying current contents in your cart: ");
            for(int z = 0; z<shopCart.size(); z++){
                Item store3 = shopCart.get(z);
                double itemPrice = store3.getItemPrice();
                String priceFormated = formatter.format(itemPrice);
                System.out.println("\n\n" + "Number: " + store3.getItemNum() + "\nName: " + store3.getItemName() +
                        "\nCategory: "+ store3.getItemCategory() + "\nPrice: $" + priceFormated + "\nQuantity: " +
                        store3.getItemQuantity());
            }
        }
    }

    /** Method to Summarise Items In Shopping Cart And Delievers Payment Options  **/
    public static boolean checkOut(ArrayList<Item> shopCart){
        if(shopCart == null){
            System.out.println("You need to create a cart!");
            return true;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("DISPLAYING ORDER SUMMARY: ");
        double priceTotal = 0.0;
        for(int z = 0; z<shopCart.size(); z++){
            Item store3 = shopCart.get(z);
            double itemPrice = store3.getItemPrice();
            priceTotal += itemPrice;
            String priceFormated = formatter.format(itemPrice);
            System.out.println("\n\n" + "Number: " + store3.getItemNum() + "\nName: " + store3.getItemName() +
                    "\nCategory: "+ store3.getItemCategory() + "\nPrice: $" + priceFormated + "\nQuantity: " +
                    store3.getItemQuantity());
        }
        double withTax = priceTotal*1.06;
        String priceFormated2 = formatter.format(withTax);
        System.out.println("\nOrder Total: $" + priceFormated2 + " (6.0% Tax Included)" +
                "\n\n_______________________________________________________");

        Scanner scan2 = new Scanner(System.in);
        boolean valid = false;
        int option = -1;
        do{
            System.out.println("How do you wish to pay for your order? (Enter 1 to charge to credit card on file, " +
                    "Enter 2 to charge to new credit card");
            if(scan2.hasNextInt()) {
                 option = scan2.nextInt();
                if (option != 1 || option != 2)
                    System.out.println("\nYou need to put in 1 or 2!");
                else
                    break;
            }
            else
                System.out.println("\nYou need to put in 1 or 2!");
        }while(!valid);


        String name = "";
        String cardType = "";
        String cardNum = "";
        String date = "";
        Scanner scan3 = new Scanner(System.in);
        switch(option){
            case 1:
                System.out.println("Thank you for your purhcase, have a great day!");
            case 2:
                System.out.println("Please input your credit card details: ");
                System.out.println("Card holder name: ");
                name = scan3.nextLine();
                System.out.println("Credit card type:");
                cardType = scan3.nextLine();
                System.out.println("Credit card number: ");
                cardNum = scan3.nextLine();
                System.out.println("Expiration date: ");
                date = scan3.nextLine();
        }

        System.out.println("Your Credit Card Summary");
        System.out.println("\nCustomer name: " + name);
        System.out.println("Payment amount: " + withTax);
        System.out.println("Credit card number: " + cardNum);
        System.out.println("Expiration date: " + date);
        return false;
    }
}