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
#include "list.h"

using namespace std;

Node::Node(char value, Node* prev, Node* next){
    this->value = value;
    this->prev = prev;
    this->next = next;
}

List::List(){
}

List::~List(){
}

bool List::IsEmpty() const{
    return h == NULL;
}

char List::GetHead() const{
    return h->value;
}

char List::GetTail() const{
    return t->value;
}

void List::AddToHead(char v){
    if(IsEmpty())
        t = h = new Node(v, NULL, NULL);
    else
        h = h->prev = new Node(v, NULL, h);
}

void List::AddToTail(char v){
    if(IsEmpty())
        t = h = new Node(v, NULL, NULL);
    else
        t = t->next = new Node(v, t, NULL);
}

char List::RemoveHead(){
    if (IsEmpty()) {
        return ' ';
    }
    else{
        char v = h->value;
        h = h->next;
        h->prev = NULL;
        return v;
    }
}

char List::RemoveTail(){
    if (IsEmpty()){
        return ' ';
    }
    else{
        char v = t->value;
        t = t->prev;
        t->next = NULL;
        return v;
    }
}

void List::AddToEmpty(char v) {
}

char List::RemoveLast() {
    return 'a';
}

bool List::HasLast() {
    return false;
}

