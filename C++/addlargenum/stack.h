#ifndef __CharStack__
#define __CharStack__

#include <iostream>
#include <string>
#include "list.h"

using namespace std;

class Stack
{
private:
    List list;
public:
    bool IsEmpty() const;
    void Push(char elem);
    char Pop();
    char Top() const;
    void Clear();

    inline friend ostream& operator<< (ostream& os, Stack& stack);
    inline operator string();
    //////////////////////////////////////////
    // Do not change the above prototype.
    // Add member function(s) below if you need.



    // Do not change the below.
    ///////////////////////////////////////////
};

inline Stack::operator string()
{
    if (IsEmpty())
    {
        return "()";
    }
    else
    {
        Stack buff1;
        while (IsEmpty() == false)
        {
            char top = Pop();
            buff1.Push(top);
        }

        stringstream os;
        os << "(";
        while (buff1.IsEmpty() == false)
        {
            Push(buff1.Pop());
            char top = Top();
            os << top;
            if (buff1.IsEmpty() == false)
                os << ",";
        }
        os << ")";
        string str = os.str();
        return str;
    }
}

inline ostream& operator<< (ostream& os, Stack& stack)
{
    os << (string)stack;
    return os;
}

#endif //__STACK__
