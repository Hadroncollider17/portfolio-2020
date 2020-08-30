/**Author: Hayson ChuE-mail: hzc5389@psu.eduCourse: CMPSC 221Assignment: Programming Assignment 1Due date: 1/28/2020File: Chu_VINDecoder.javaPurpose: Java application that implements a simple Vehicle Identification Number (VIN) decoderCompiler/IDE: Java SE Development Kit 11.0.5/IntlliJ IDEA UltimateOperatingsystem: MacOSReference(s): * Beginner's Book Website Reference - Strings https://beginnersbook.com/2013/12/java-strings/ * How to Decode Your VIN https://www.edmunds.com/how-to/how-to-quickly-decode-your-vin.html * Java T Point - Format https://www.javatpoint.com/java-string-format * Remove White Space https://www.java67.com/2012/12/how-to-remove-all-white-space-from-String-beginning-end-between.html * ASCII Code Tabele https://www.ascii-code.com/ **/import java.util.Scanner;import java.lang.Character;public class VINDecoder {    /** Main Method **/    public static void main(String[] args){        System.out.println(            "\n********************************************************************************\n" +            " Welcome to HC's VIN Decoder\n" +            "********************************************************************************"        );        /** Runs User Interface, calls method to ask user for input, and calls method to check. if verify false calls         method to ask user if they want to reattempt VIN read. exits when user tells program to not repeat */        boolean repeat;        do{            String input = requestInput();;            if(verifyVIN(input))                decodeVIN(input);            repeat = repeatRequest();        } while(repeat);        System.out.println(            "********************************************************************************\n" +            "Thanks for using my VIN decoder!\n" +            "******************************************************************************** "        );    }    /** inputInvite method request input from user, prints it out, and returns the String **/    public static String requestInput(){        Scanner scan = new Scanner(System.in);        System.out.println("\nPlease enter a string representing a Vehicle Identification Number (VIN): ");        String input = scan.nextLine();        /** Gets rid of whitespace if need be */        String withoutSpace = input.replaceAll("\\s","");        System.out.println("\nVIN entered by user: \n" + withoutSpace);        return withoutSpace;    }    /** verifyVIN verifies input from user and checks for 17 characters, if it only contains letters & numbers and that     I/O/Q letters don't exist in VIN. Returns true or false **/    public static boolean verifyVIN(String input){        boolean verify = true;        /** checks input length */        if(input.length()!=17) {            verify = false;            System.out.println("\n** VIN must contain 17 characters. **\n");        }        else{            char charInput;            for(int i=0; i<input.length(); i++){                charInput = input.charAt(i);                /** This if statement compares each character in the string to check if char's ASCII digits are either                equivalent to number/letter ASCII digits, where numbers: 48-57, letters: 65-90, 97-122 */                if(!((charInput>=48)&&(charInput<=57)||(charInput>=65)&&(charInput<=90)||(charInput>=97)&&(charInput<=122))) {                    verify = false;                    System.out.println("\n** VIN can only contain letters and digits. **\n");                    break;                }                /** Checks if VIN has I/O/Q i/o/q characters. if so, gives false verify */                String cInput = Character.toString(charInput);                if(cInput.equalsIgnoreCase("I")||cInput.equalsIgnoreCase("O")||cInput.equalsIgnoreCase("Q")){                    verify = false;                    System.out.println("\n** VIN cannot contain I/O/Q/i/o/q **\n");                    break;                }            }        }        return verify;    }    /** decodeVIN decodes VIN and splits it into three divisions: wmi, vds, vis. also identifies country, serial, year,     manufacteurer, check number. **/    public static void decodeVIN(String input){        System.out.println("\nVIN is valid. Decoding in progress ... ");        String wmi, vds, vis, check, serial, year, country, manufacteurer;        wmi = check = serial = year = manufacteurer = country = vds = vis = "";        /** Seperating input into WMI, VDS, VIS codes **/        for(int i=0; i<3; i++)            wmi += input.charAt(i);        for(int i =3; i<9; i++)            vds += input.charAt(i);        for(int i=9; i<17; i++)            vis += input.charAt(i);        wmi = wmi.toUpperCase();        vds = vds.toUpperCase();        vis = vis.toUpperCase();        System.out.println("\n** VALUES BY GROUP **");        System.out.println("\tWorld Manufacturer Identifier (WMI): " + wmi);        System.out.println("\tVehicle Descriptor Section (VDS): \t " + vds);        System.out.println("\tVehicle Identifier Section (VIS): \t " + vis);        /** For categorising country code **/        switch(wmi.charAt(0)){            case '1':            case '4':            case '5':                country = "United States";                break;            case '2':                country = "Canada";                break;            case '3':                country = "Mexico";                break;            case 'J':                country = "Japan";                break;            case 'S':                country = "United Kingdom";                break;            case 'W':                country = "Germany";                break;            default:                country = "N/A";        }        /** For categorising manufacturer code **/        switch(wmi.charAt(1)){            case 'C':                manufacteurer = "Chrysler";                break;            case 'F':                manufacteurer = "Ford";                break;            case 'G':                manufacteurer = "General Motors";                break;            case 'H':                manufacteurer = "Honda";                break;            case 'T':                manufacteurer = "Toyota";                break;            case 'B':                manufacteurer = "BMW";                break;            case 'A':                manufacteurer = "Jaguar";                break;            case 'D':                manufacteurer = "Mercedes-Benz";                break;            default:                manufacteurer = "N/A";        }        /** For categorising year of manufacture **/        switch(vis.charAt(0)){            case 'Y':                year = "2000";                break;            case '1':                year = "2001";                break;            case '2':                year = "2002";                break;            case '3':                year = "2003";                break;            case '4':                year = "2004";                break;            case '5':                year = "2005";                break;            case '6':                year = "2006";                break;            case '7':                year = "2007";                break;            case '8':                year = "2008";                break;            case '9':                year = "2009";                break;            case 'A' :                year = "2010";                break;            case 'B':                year = "2011";                break;            case 'C':                year = "2012";                break;            case 'D':                year = "2013";                break;            case 'E':                year = "2014;";                break;            case 'F':                year = "2015";                break;            case 'G':                year = "2016";                break;            case 'H':                year = "2017";                break;            case 'J':                year = "2018";                break;            case 'K':                year = "2019";                break;            case 'L':                year = "2020";                break;            default:                year = "N/A";        }        /** find check number and serial code */        check += input.charAt(8);        for(int i=2; i<8; i++)            serial += vis.charAt(i);        /** prints out findings */        System.out.println("\n** VEHICLE ATTRIBUTES **");        System.out.println("\tCountry of Manufacture: " + country);        System.out.println("\tManufacturer: \t\t\t" + manufacteurer);        System.out.println("\tCheck Digit: \t\t\t" + check);        System.out.println("\tModel Year: \t\t\t" + year);        System.out.println("\tSerial Number: \t\t\t" + serial);    }    /** repeatRequest asks if user wants to type in another VIN, and returns true if user types y/Y and false if user     types n/N. this method also verifies if user types a valid entry or not, and repeats until valid entry given. **/    public static boolean repeatRequest(){        boolean repeat = false;        boolean verify;        do{            System.out.println("********************************************************************************");            System.out.println("\nEnter another VIN (Y/N)? ");            Scanner scan = new Scanner(System.in);            String input = scan.nextLine();            if(input.equalsIgnoreCase("y")){                repeat = true;                verify = true;            }            else if (input.equalsIgnoreCase("n")) {                repeat = false;                verify = true;            }            else{                verify = false;                System.out.println("\n** You may only choose Y or N. ** \n");            }        } while(!verify);        return repeat;    }}