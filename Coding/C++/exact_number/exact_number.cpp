//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122, Session 2
// Homework 2
// Due Date: October 7, 2019
//
// Description: This program read a txt file and determines if it gives a solution to a N Queen Problem
//
// Acknowledgement:
//---------------------------------------------------------------------

#include <iostream>
#include <sstream>
#include <limits>
#include <cmath>
#include <string>
#include "exact_number.h"

using namespace std;

//default constructor
ExactNumber::ExactNumber() {
    numer = 0;
    denom = 1;
}

//memberwise-copy constructor
ExactNumber::ExactNumber(int n, int d) {
    numer = n;
    denom = d;
    simplify();
}

//copy constructor
ExactNumber::ExactNumber(const ExactNumber &n) {
    numer = n.numer;
    denom = n.denom;
}

//destructor
ExactNumber::~ExactNumber() {

}

// assignment operator
ExactNumber& ExactNumber::operator=(const ExactNumber& rhs){
    numer = rhs.numer;
    denom = rhs.denom;
    return *this;
}

// arithmatic operators
ExactNumber& ExactNumber::operator+=(const ExactNumber& rhs){
    numer = numer*rhs.denom + denom*rhs.numer;
    denom *= rhs.denom;
    simplify();
    return *this;
}
ExactNumber& ExactNumber::operator-=(const ExactNumber& rhs){
    numer = numer*rhs.denom - rhs.numer*denom;
    denom *= rhs.denom;
    simplify();
    return *this;
}
ExactNumber& ExactNumber::operator*=(const ExactNumber& rhs){
    numer *= rhs.numer;
    denom *= rhs.denom;
    simplify();
    return *this;
}
ExactNumber& ExactNumber::operator/=(const ExactNumber& rhs){
    numer /= rhs.numer;
    denom /= rhs.denom;
    simplify();
    return *this;
}

//friends
ExactNumber operator+(const ExactNumber& lhs, const ExactNumber& rhs){
    ExactNumber temp;
    temp.numer = lhs.numer*rhs.denom + rhs.numer*lhs.denom;
    temp.denom = lhs.denom*rhs.denom;
    return temp;
}
ExactNumber operator-(const ExactNumber& lhs, const ExactNumber& rhs){
    ExactNumber temp;
    temp.numer = lhs.numer*rhs.denom - rhs.numer*lhs.denom;
    temp.denom = lhs.denom*rhs.denom;
    return temp;
}
ExactNumber operator*(const ExactNumber& lhs, const ExactNumber& rhs){
    ExactNumber temp;
    temp.numer = lhs.numer*rhs.numer;
    temp.denom = lhs.denom*rhs.denom;
    return temp;
}
ExactNumber operator/(const ExactNumber& lhs, const ExactNumber& rhs){
    ExactNumber temp;
    temp.numer = lhs.numer*rhs.denom;
    temp.denom = lhs.denom*rhs.numer;
    return temp;
}

// equality/inequality operators
bool ExactNumber::operator==(const ExactNumber& rhs) const{
    ExactNumber temp1(rhs.numer, rhs.denom);
    ExactNumber temp2(numer, denom);
    temp1.simplify();
    temp2.simplify();

    return (temp1.numer == temp2.numer)&&(temp1.denom == temp2.denom);
}
bool ExactNumber::operator!=(const ExactNumber& rhs) const{
    ExactNumber temp1(rhs.numer, rhs.denom);
    ExactNumber temp2(numer, denom);
    temp1.simplify();
    temp2.simplify();

    return !((temp1.numer == temp2.numer)&&(temp1.denom == temp2.denom));
}

// relational operators
bool ExactNumber::operator< (const ExactNumber& rhs) const{
    ExactNumber temp1(numer, denom);
    ExactNumber temp2(rhs.numer, rhs.denom);
    temp1.simplify();
    temp2.simplify();
    return (temp1.numer/temp1.denom) < (temp2.numer/temp2.denom);
}
bool ExactNumber::operator> (const ExactNumber& rhs) const{
    ExactNumber temp1(numer, denom);
    ExactNumber temp2(rhs.numer, rhs.denom);
    temp1.simplify();
    temp2.simplify();

    return (temp1.numer/temp1.denom) > (temp2.numer/temp2.denom);
}
bool ExactNumber::operator<=(const ExactNumber& rhs) const{
    ExactNumber temp2(rhs.numer, rhs.denom);
    ExactNumber temp1(numer, denom);
    temp1.simplify();
    temp2.simplify();

    return (temp1.numer/temp1.denom) <= (temp2.numer/temp2.denom);
}
bool ExactNumber::operator>=(const ExactNumber& rhs) const{
    ExactNumber temp2(rhs.numer, rhs.denom);
    ExactNumber temp1(numer, denom);
    temp1.simplify();
    temp2.simplify();

    return (temp1.numer/temp1.denom) >= (temp2.numer/temp2.denom);
}

// stream insertion/extraction operators as friend
ostream& operator<< (ostream& os, const ExactNumber& n){
    os << "(" << n.numer << "/" << n.denom << ")";
    return os;
}

