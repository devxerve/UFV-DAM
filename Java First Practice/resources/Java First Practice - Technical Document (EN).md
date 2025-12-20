# Array Generator - Odd & Even Numbers
**Java Practice | Universidad Francisco de Vitoria**
## Description
Generates two arrays: **odd numbers** (random 5-50 range) and **even numbers** (5-50 range, sized by odd array's minimum value). Displays both arrays with indexed format, min/max values for each, and GCD between even array's min/max using Euclid's algorithm.

## How It Works

User inputs odd array size (>0) with error handling

Fills odd array with random odd numbers (5-50)

Even array size = smallest odd number found

Fills even array with random even numbers (5-50)

Shows both arrays, min/max per array, GCD(even_min, even_max)

## Code Structure

Main.java (200 lines, 9 methods)
├── readInt(Scanner) → Validates numeric input, returns 0 on error
├── numGen(min,max) → Random integer generator (inclusive range)
├── checkEven(num) → Returns true if even (num % 2 == 0)
├── fillOdds(odds[]) → Fills with random odds 5-50 using do-while
├── fillEvens(evens[]) → Fills with random evens 5-50 using do-while
├── showArray(array[]) → Prints "[index]=value | " format
├── smallerNumber(array[]) → Linear search minimum (O(n))
├── greaterNumber(array[]) → Linear search maximum (O(n))
└── gcd(a,b) → Euclid's algorithm (while b != 0)

## Sample Output

Please, type the size of the Array you want to create
5
Array containing odd numbers
=17 | =23 | =41 | =7 | =35 |
Array containing even numbers
=12 | =28 | =6 | =44 | =18 |
The greatest number of the Array containing odds is : 41
The smallest number of the Array containing odds is :7
The greatest number of the Array containing evens is :44
The smallest number of the Array containing evens is :6

The greatest common divisor of 6 and 44 is: 2

## Key Features
- **Input validation** catches non-numeric input
- **Consistent ranges** 5-50 for both arrays  
- **Cached calculations** evensSmall/evensGreat variables
---
**Author:** [Javier Cervera Rodríguez] | DAM Student | UFV  
**Version:** 3.0 | Dec 20, 2025