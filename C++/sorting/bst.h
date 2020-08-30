//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122 Session 2
// Homework 5
// Due Date: 9 December 2019
// Description: This program compares two sorting algorithms (bst and sorting)
// Acknowledgement:
//---------------------------------------------------------------------


#ifndef __BST__
#define __BST__

#include <iostream>
#include <string>
#include <sstream>
#include <stdio.h>

using namespace std;

class BST;

class Node
{
private:
    double value;
    Node*  left;
    Node*  right;
public:
    Node(double v, Node* l = NULL, Node* r = NULL)
    {
        value = v;
        left = l;
        right = r;
    }
    double GetValue() const                                   
    {                                                         
        return value;                                         
    }                                                         
    friend class BST;                                         
};                                                            
                                                              
class BST                                                     
{                                                             
private:                                                      
    Node* root;                                               
public:                                                       
    BST(Node* r = NULL)                                       
    {
        root = r;
    }
    bool IsEmpty() const                                      
    {                                                         
        return (root == NULL);                                
    }                                                         
    string ToString() const                                   
    {                                                         
        if (IsEmpty()) return "()";                           
        string str = ToString(root);                          
        if (root->left == NULL && root->right == NULL) str = "(" + str + ")";
        return str;                                           
    }                                                         
                                                              
    void Clear();                                             
    Node* Search(double query);                               
    void Insert(double value);                                
    void Inorder(void (*visit)(const Node*));                 
    void Preorder(void (*visit)(const Node*));                
    void Postorder(void (*visit)(const Node*));               
                                                              
    ///////////////////////////////////////////               
    // Do not change the above prototype.                     
    // Add member function(s) below if you need.

    void Clear(Node* n);
    Node* Search(Node* n, double query);
    void Insert(Node*& n, double value);
    void Inorder(Node* n, void(*visit)(const Node* ));
    void Preorder(Node* n, void (*visit)(const Node* ));
    void Postorder(Node* n, void (*visit)(const Node* ));

    // Do not change the below.                               
    ///////////////////////////////////////////               
private:                                                      
    string ToString(Node* n) const                            
    {                                                         
        if (n == NULL) return "_";                            
        stringstream ss;                                      
        if (n->left == NULL && n->right == NULL) ss << n->value;
        else
            ss << "(" << ToString(n->left) << "," << n->value << "," << ToString(n->right) << ")";
        return ss.str();                                      
    }                                                         
                                                              
    ///////////////////////////////////////////               
    // Do not change the above prototype.
    // Add member function(s) below if you need.              
                                                              
    // Do not change the below.                               
    ///////////////////////////////////////////               
};                                                            
                                                              
#endif //__BST__  
