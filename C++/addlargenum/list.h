#ifndef __DLList__
#define __DLList__

#include <iostream>
#include <sstream>
#include <string>

using namespace std;

class List;

class Node
{
private:
    char value;
    Node* prev;
    Node* next;
public:
    Node(char value, Node* prev = NULL, Node* next = NULL);
    friend class List;
};

class List
{
private:
    Node* h;
    Node* t;
public:
    List();
    ~List();
    bool IsEmpty() const;
    char GetHead() const;
    char GetTail() const;
    void AddToHead(char v);
    void AddToTail(char v);
    char RemoveHead();      // return value of the deleted deleted node
    char RemoveTail();      // return value of the deleted deleted node

    inline friend ostream& operator<< (ostream& os, const List& list);
    inline operator string() const;
    ///////////////////////////////////////////
    // Do not change the above prototype.
    // Add member function(s) below if you need.
    void AddToEmpty(char v);
    char RemoveLast();
    bool HasLast();
    // Do not change the below.
    ///////////////////////////////////////////
};

inline List::operator string() const
{
    if (IsEmpty())
    {
        return "()";
    }
    else
    {
        std::stringstream os;
        os << "(";
        Node* r = h;
        while (r != t)
        {
            os << r->value << ",";
            r = r->next;
        }
        os << r->value << ")";
        string str = os.str();
        return str;
    }
}

inline ostream& operator<< (std::ostream& os, const class List& list)
{
    os << (string)list;
    return os;
}


#endif //__DLList__
