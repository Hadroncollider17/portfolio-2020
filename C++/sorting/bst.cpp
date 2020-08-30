//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122 Session 2
// Homework 5
// Due Date: 9 December 2019
// Description: This program compares two sorting algorithms (bst and sorting)
// Acknowledgement:
//---------------------------------------------------------------------

#include "bst.h"
#include <assert.h>

using namespace std;

///////////////////////////////////////////
// Implement function bodies

void BST::Clear(){
    if(IsEmpty()) return;
    Clear(root);
}

void BST::Clear(Node* n){
    if(n==NULL) return;
    Clear(n->left);
    Clear(n->right);
    delete n;
}

Node* BST::Search(double query){
    return Search(root, query);
}

Node* BST::Search(Node* n, double query) {
    double v = n->value;
    if(n == NULL) return n;
    if(v == query) return root;
    else if(v > query)
        return Search(n->left, query);
    else
        return Search(n->right, query);
}

void BST::Insert(double value){
    Insert(root, value);
}

void BST::Insert(Node*& n, double value){
    double v = n->value;
    if(n == NULL)
        n = new Node(value);
    if(v == value) return;
    else if(v > value)
        Insert(n->left, value);
    else
        Insert(n->right, value);
}

void BST::Inorder(void (*visit)(const Node*)){
    Inorder(root, visit);
}

void BST::Inorder(Node *n, void (*visit)(const Node*)){
    if(n==NULL) return;
    Inorder(n->left, visit);
    visit(n);
    Inorder(n->right, visit);
}

void BST::Preorder(void (*visit)(const Node*)){
    Preorder(root, visit);
}

void BST::Preorder(Node* n, void (*visit)(const Node*)){
    if(n==NULL) return;
    visit(n);
    Preorder(n->left, visit);
    Preorder(n->right, visit);
}

void BST::Postorder(void (*visit)(const Node*)){
    Postorder(root, visit);
}

void BST::Postorder(Node* n, void (*visit)(const Node*)){
    if(n==NULL) return;
    Postorder(n->left, visit);
    Postorder(n->right, visit);
    visit(n);
}

// Implement function bodies
///////////////////////////////////////////

