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

#include <iostream>
#include <string>
#include "stack.h"

using namespace std;

bool Stack::IsEmpty() const{
    return list.IsEmpty();
}

void Stack::Push(char elem){
    list.AddToHead(elem);
}

char Stack::Pop(){
    return list.RemoveHead();
}

char Stack::Top() const{
    return list.GetHead();
}

void Stack::Clear(){
    while(!list.IsEmpty()) {
        char contain = Pop();
        cout << contain;
    }
}
