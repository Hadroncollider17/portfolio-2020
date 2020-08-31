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

/*************************************************************************
 *  CMPSC 122                                                            *
 *  Startup code for HW 2                                                *
 *  Sukmoon Chang, sukmoon@psu.edu                                       *
 *  Hyuntae Na, htna@psu.edu                                             *
 *                                                                       *
 *                                                                       *
 *  Description:                                                         *
 *                                                                       *
 *  This is a header file for class ExactNumber.                         *
 *  Do not modify this file and implement each methods defined here in   *
 *     exact_number.cxx                                                  *
 *                                                                       *
 *  Please report any bug to sukmoon@psu.edu or htna@psu.edu             *
 *************************************************************************/


#ifndef EXACTNUMBER_1_H
#define EXACTNUMBER_1_H

#include <iostream>

using namespace std;

class ExactNumber
{
private:
    int numer;
    int denom;

    // private methods
    // - implementations are provided in this file
    inline int gcd() const;
    inline void simplify();
public:
    ExactNumber();
    ExactNumber(int n, int d = 1);
    ExactNumber(const ExactNumber& n);

    ~ExactNumber();

    // implicit type conversion operator
    // - implementation is provided in this file
    inline operator double() const;

    // assignment operator
    ExactNumber& operator=(const ExactNumber& rhs);

    // arithmatic operators
    ExactNumber& operator+=(const ExactNumber& rhs);
    ExactNumber& operator-=(const ExactNumber& rhs);
    ExactNumber& operator*=(const ExactNumber& rhs);
    ExactNumber& operator/=(const ExactNumber& rhs);

    friend ExactNumber operator+(const ExactNumber& lhs, const ExactNumber& rhs);
    friend ExactNumber operator-(const ExactNumber& lhs, const ExactNumber& rhs);
    friend ExactNumber operator*(const ExactNumber& lhs, const ExactNumber& rhs);
    friend ExactNumber operator/(const ExactNumber& lhs, const ExactNumber& rhs);

    // equality/inequality operators
    bool operator==(const ExactNumber& rhs) const;
    bool operator!=(const ExactNumber& rhs) const;

    // relational operators
    bool operator< (const ExactNumber& rhs) const;
    bool operator> (const ExactNumber& rhs) const;
    bool operator<=(const ExactNumber& rhs) const;
    bool operator>=(const ExactNumber& rhs) const;


    // stream insertion/extraction operators as friend
    friend ostream& operator<< (ostream& os, const ExactNumber& n);
};



// Implementation of private methods

// returns the greatest common divisor of number and denom
// - Eulclid algorithm for gcd
inline int ExactNumber::gcd() const
{
    int n = (numer < 0) ? -numer : numer;
    int d = (denom < 0) ? -denom : denom;
    while (n > 0) {
        int tmp = d % n;
        d = n;
        n = tmp;
    }
    return d;
}

// Simplifies the rational number
inline void ExactNumber::simplify()
{
    int d = gcd();
    numer /= d;
    denom /= d;
}

// implicite type conversion operator to double
inline ExactNumber::operator double() const
{
    return static_cast<double>(numer) / static_cast<float>(denom);
}

#endif
