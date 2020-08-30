//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122 Session 2
// Homework 5
// Due Date: 9 December 2019
// Description: This program compares two sorting algorithms (bst and sorting)
// Acknowledgement:
//---------------------------------------------------------------------


#include <iostream>
#include <string>
#include <sstream>
#include <iomanip> // std::setprecision
#include <stdio.h> // printf()
#include <time.h>  // clock();
#include <cstdlib> // rand()

using namespace std;

void SelectionSort(double* arr, int n)
{
    ///////////////////////////////////////////
    // Do not change the above.
    // Implement function body

    int imin;
    double arrSwap;

    for(int i=0; i<(n-1); i++){
        imin = i;
        for(int j=i+1; j<n; j++){
            if(arr[j]<arr[imin])
                imin = j;
        }
        if(imin != i){
            arrSwap = arr[i];
            arr[i] = arr[imin];
            arr[imin] = arrSwap;
        }
    }

    // Implement function body

    ///////////////////////////////////////////
}
