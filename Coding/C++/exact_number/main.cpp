//---------------------------------------------------------------------
// Name: Hayson Chu
// Email: hzc5389@psu.edu
// Class: CMPSC 122, Session 2
// Homework 2
// Due Date: October 7, 2019
//
// Description: This program implements an easy approach to improving
//      floating-point number representation.
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


string error_msg(string rand, ExactNumber& n, double ans)
{
    ostringstream msg;
    msg << "  " << rand << " failed with " << static_cast<double>(n) << "... expecting " << ans;
    return msg.str();
}

string error_msg(string rand, ExactNumber& n1, ExactNumber& n2, bool ans)
{
    ostringstream msg;
    msg << "  " << rand << " failed with " << ans << "... expecting " << !ans
        << " => " << n1 << " : " << n2 << endl;
    return msg.str();
}


int main()
{
    cout << "Testing ExactNumber..." << endl << endl;

    cout << "Manual check:";
    cout << "   operator<<   should print an ExactNumber as \"(a/b)\"" << endl;

    ExactNumber e1;    // default constructor
    cout << "  manual check for (0/1) : " << e1 << endl;

    ExactNumber e2(3);  // memberwise-copy constructor
    cout << "  manual check for (3/1) : " << e2 << endl;

    ExactNumber e3(5, 2);  // memberwise-copy constructor
    cout << "  manual check for (5/2) : " << e3 << endl;

    ExactNumber e4(e3);   // copy constructor
    cout << "  manual check for (5/2) : " << e4 << endl;

    ExactNumber e5(10, 5);  // simplification
    cout << "  manual check for (2/1) : " << e5 << endl;



    cout << endl;
    cout << "Automatic check" << endl;
    cout.precision(numeric_limits<double>::digits10);

    unsigned int num_tests = 0;
    unsigned int num_failed = 0;

    ExactNumber n1(2, 4), n2(5, 3), n3(5, 6), n4;

    // =
    num_tests++;
    n4 = n1;
    try { if (static_cast<double>(n4) != 1.0/2.0) throw error_msg("operator=", n4, 1.0/2.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    // +=, -=, *=, /=
    num_tests++;
    n4 += n2;
    try { if (static_cast<double>(n4) != 13.0/6.0) throw error_msg("opeator=", n4, 13.0/6.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 -= n2;
    try { if (static_cast<double>(n4) != 1.0/2.0) throw error_msg("operator-=", n4, 1.0/2.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 *= n2;
    try { if (static_cast<double>(n4) != 5.0/6.0) throw error_msg("operator*=", n4, 5.0/6.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 /= n2;
    try { if (static_cast<double>(n4) != 1.0/2.0) throw error_msg("operator/=", n4, 1.0/2.0); }
    catch(string m) { cout << m << endl; num_failed++; }


    // +, -, *, /
    num_tests++;
    n4 = n1 + n2;
    try { if (static_cast<double>(n4) != 13.0/6.0) throw error_msg("operator+", n4, 13.0/6.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = n1 - n2;
    try { if (static_cast<double>(n4) != -7.0/6.0) throw error_msg("operator-", n4, -7.0/6.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = n1 * n2;
    try { if (static_cast<double>(n4) != 5.0/6.0) throw error_msg("operator*", n4, 5.0/6.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = n1 / n2;
    try { if (static_cast<double>(n4) != 3.0/10.0) throw error_msg("operator/", n4, 3.0/10.0); }
    catch(string m) { cout << m << endl; num_failed++; }

    // ==, !=
    num_tests++;
    n4 = n1 * n2;
    bool result = n4 == n3;
    try { if (result != true) throw error_msg("operator==", n4, n3, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n1 == n2;
    try { if(result != false) throw error_msg("operator==", n4, n1, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n1 != n2;
    try { if (result != true) throw error_msg("operator!=", n1, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n4 != n3;
    try { if(result != false) throw error_msg("operator!=", n1, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    // <, >, <=, >=
    num_tests++;
    result = n1 < n2;
    try { if (result != true) throw error_msg("operator<", n1, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n2 > n3;
    try { if (result != true) throw error_msg("operator>", n2, n3, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n1 <= n2;
    try { if (result != true) throw error_msg("operator<=", n1, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }


    num_tests++;
    result = n2 <= n2;
    try { if (result != true) throw error_msg("operator<=", n2, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n2 >= n3;
    try { if (result != true) throw error_msg("operator>=", n2, n3, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    result = n2 >= n2;
    try { if (result != true) throw error_msg("operator>=", n2, n2, result); }
    catch(string m) { cout << m << endl; num_failed++; }

    // combination
    num_tests++;
    n4 = (n1 - n2) * n3 + n1;
    try {
        if (static_cast<double>(n4) != ExactNumber(-17, 36))
            throw error_msg("(n1 - n2) * n3 + n1", n4, -17.0/36.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = n1 * n1 / n1 / n1;
    try {
        if (static_cast<double>(n4) != ExactNumber(1, 1))
            throw error_msg("n1 * n1 / n1 / n1", n4, 1.0/1.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = n1 * n3 / n2 + n3 / n1 * n2;
    try {
        if (static_cast<double>(n4) != ExactNumber(109, 36))
            throw error_msg("n1 * n3 / n2 + n3 / n1 * n2", n4, 109.0/36.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    num_tests++;
    n4 = (n1 + n2) / (n3 * (n1 - n2) / (n3 + n1 * n2));
    try {
        if(static_cast<double>(n4) != ExactNumber(-26, 7))
            throw error_msg("(n1 + n2) / (n3 * (n1 - n2) / (n3 + n1 * n2))", n4, -26.0/7.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    // operator* involving 0
    ExactNumber n5(11, 3), n6(0, 5);
    num_tests++;
    n4 = n5 * n6;
    try {
        if (static_cast<double>(n4) != ExactNumber(0, 1))
            throw error_msg("operator* involving 0", n4, 0.0/1.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    // operator/ involving 0
    num_tests++;
    n4 = n5 / n6;
    try {
        if(static_cast<double>(n4) != ExactNumber(1, 0))
            throw error_msg("operator/ involving 0", n4, 0.0/1.0);
    }
    catch(string m) { cout << m << endl; num_failed++; }

    /* Do not modify the code below */

    if (num_failed == 0)
        cout << "passed all " << num_tests << " default test cases" << endl;
    else
        cout << "failed " << num_failed << " default test cases out of " << num_tests << " default test cases" << endl;
    cout << endl;

    /********************************************************/



    //Personal Test
    /********************************************************/
    cout << endl << "------------------------------------------";
    cout << endl << endl << "Automatic Check: Round 2\n";

    unsigned int num_tests2 = 0;
    unsigned int num_failed2 = 0;

    ExactNumber m1(2, 1), m2(4, 3), m3(8, 3), m4;

    // =
    num_tests2++;
    m4 = m1;
    try { if (static_cast<double>(m4) != 2.0 / 1.0) throw error_msg("operator=", m4, 2.0 / 1.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    // +=, -=, *=, /=
    num_tests2++;
    m4 += m2;
    try { if (static_cast<double>(m4) != 10.0 / 3.0) throw error_msg("operator+=", m4, 10.0 / 3.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 -= m2;
    try { if (static_cast<double>(m4) != 2.0 / 1.0) throw error_msg("operator-=", m4, 8.0 / 9.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 *= m2;
    try { if (static_cast<double>(m4) != 8.0 / 3.0) throw error_msg("operator*=", m4, 8.0 / 3.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 /= m2;
    try { if (static_cast<double>(m4) != 2.0 / 1.0) throw error_msg("operator/=", m4, 2.0 / 1.0); }
    catch(string m) { cout << m << endl; num_failed2++; }


    // +, -, *, /
    num_tests2++;
    m4 = m1 + m2;
    try { if (static_cast<double>(m4) != 10.0 / 3.0) throw error_msg("operator+", m4, 10.0 / 3.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 = m1 - m2;
    try { if (static_cast<double>(m4) != 2.0 / 3.0) throw error_msg("operator-", m4, 2.0 / 3.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 = m1 * m2;
    try { if (static_cast<double>(m4) != 8.0 / 3.0) throw error_msg("operator*", m4, 8.0 / 3.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 = m1 / m2;
    try { if (static_cast<double>(m4) != 3.0 / 2.0) throw error_msg("operator/", m4, 3.0 / 2.0); }
    catch(string m) { cout << m << endl; num_failed2++; }

    // ==, !=
    num_tests2++;
    m4 = m1 * m2;
    bool result2 = m4 == m3;
    try { if (result2 != true) throw error_msg("operator==", m4, m3, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m1 == m2;
    try { if(result2 != false) throw error_msg("operator==", m4, m1, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m1 != m2;
    try { if (result2 != true) throw error_msg("operator!=", m1, m2, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m4 != m3;
    try { if(result2 != false) throw error_msg("operator!=", m1, m2, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    // <, >, <=, >=
    num_tests2++;
    result2 = m1 < m2;
    try { if (result2 != false) throw error_msg("operator<", m1, m2, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m2 > m3;
    try { if (result2 != false) throw error_msg("operator>", m2, m3, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m1 >= m2;
    try { if (result2 != true) throw error_msg("operator<=", m1, m2, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m2 <= m3;
    try { if (result2 != true) throw error_msg("operator>=", m2, m3, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    result2 = m2 >= m2;
    try { if (result2 != true) throw error_msg("operator>=", m2, m2, result2); }
    catch(string m) { cout << m << endl; num_failed2++; }

    // combination
    num_tests2++;
    m4 = (m1 - m2) * m3 + m1;
    try {
        if (static_cast<double>(m4) != ExactNumber(34, 9))
            throw error_msg("(m1 - m2) * m3 + m1", m4, -17.0 / 36.0);
    }
    catch(string m) { cout << m << endl; num_failed2++; }

    num_tests2++;
    m4 = m1 * m3 / m2 + m3 / m1 * m2;
    try {
        if (static_cast<double>(m4) != ExactNumber(52, 9))
            throw error_msg("n1 * n3 / n2 + n3 / n1 * n2", m4, 52.0 / 9.0);
    }
    catch(string m) { cout << m << endl; num_failed2++; }

    if (num_failed2 == 0)
        cout << "passed all " << num_tests2 << " Round Two test cases" << endl;
    else
        cout << "failed " << num_failed2 << " Round Two test cases out of " << num_tests2 << " default test cases" << endl;
    cout << endl;
    /********************************************************/


    return 0;
}
