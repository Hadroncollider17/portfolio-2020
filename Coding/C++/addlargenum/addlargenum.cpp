//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122, Session 2
// Homework 4
// Due Date: Nov 6, 2019
//
// Description: This program read a txt file and adds large numbers.
//
// Acknowledgement:
//---------------------------------------------------------------------

#include <stdio.h>
#include <iostream> // std::ostream
#include <sstream>  // std::stringstream
#include <string>   // std::string
#include <assert.h> // void assert(scalar expression);
#include "stack.h"

using namespace std;


// Convert a numeric character to an integer
int CharToInt(char ch)
{
    assert('0' <= ch && ch <= '9');
    int i = ch - '0';
    return i;
}

// convert one digit integer to a numeric character
char IntToChar(int i)
{
    assert(0 <= i && i <= 9);
    char ch = i + '0';
    return ch;
}

string AddLargeNum(string num1, string num2) {
    ////////////////////////////////////////////////////
    // Implement the algorithm that adds two strings num1 and num2 representing large numbers
    // and return another string that represents the sum of the two large numbers
    // You must use char Stack implemented using Doubly-Linked List for char; otherwise, you will lose huge amount of points.

    Stack firstNum, secondNum, sum;
    int size;
    int size1 = num1.length();
    int size2 = num2.length();

    for(int i = 0; i < size1+1; i++) {
        firstNum.Push(num1[i]);
    }
    for(int i = 0; i < size2+1; i++) {
        secondNum.Push(num2[i]);
    }

    if(size1>=size2)
        size = size1;
    else
        size = size2;

    int store1, store2, store_sum;
    int* carry = new int [size+1];
    char save1, save2;
    for(int i=0; i<(size+1); i++) {

        save1 = firstNum.Pop();
        save2 = secondNum.Pop();

        if((i==size)&&(carry[i-1]!=1)){
            sum.Push(' ');
            break;
        }
        else if((i==size)&&(carry[i-1]==1)){
            sum.Push('1');
            sum.Push(' ');
            break;
        }

        if((i==size)&&(carry[i]!=1))
            break;

        if(i!=0) {
            //convert popped values from char to int
            if (save1 == ' ')
                store1 = 0;
            else
                store1 = CharToInt(save1);
            if (save2 == ' ')
                store2 = 0;
            else
                store2 = CharToInt(save2);

            //the addition
            store_sum = store1 + store2;

            if (store_sum > 9) {
                carry[i] = 1;
                store_sum -= 10;
            } else
                carry[i] = 0;

            if (i != 1)
                sum.Push(IntToChar(carry[i - 1] + store_sum));
            else
                sum.Push(IntToChar(store_sum));
        }
        else
            carry[0] = 0;
    }

    char hold;
    string final_sum = "";
    for(int i = 0; i < size+2; i++) {
        hold = sum.Pop();
        if((i==size)&&(hold==' '))
            break;
        final_sum += hold;
    }

    return final_sum;
    ////////////////////////////////////////////////////
}

int main()
{
    int n;
    // read the number of the large integers to read from cin
    cin >> n;
    // quit program if there is no large integers to read
    if (n <= 0)
        return 0;

    /////////////////////////////////////////////////////////////
    // replace the following lines of code with your own code
    //
    if(n==1){
        string* store =  new string[1];
        cin >> store[0];
        cout << store[0];
        return 0;
    }

    string* store =  new string[n];
    for(int i=0; i<n; i++) {
        string temp = "";
        cin >> temp;
        store[i] = ' ' + temp;
    }

    string* sum = new string;
    for(int i=0; i<(n-1); i++) {
        if (i == 0) {
            AddLargeNum(store[0], store[1]);
        }
        else {
            *sum = AddLargeNum(*sum, store[i+1]);
        }
    }
    cout << *sum;

    // replace the above lines of code to your own code
    /////////////////////////////////////////////////////////////
}
