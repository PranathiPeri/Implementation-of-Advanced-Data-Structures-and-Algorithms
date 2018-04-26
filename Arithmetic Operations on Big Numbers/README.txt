
In this project, we developed a program that implements arithmetic with large integers, of arbitrary size.

The files that are included are :
Num.java
LP1L1.java
LP1L3.java


Num.java is the file which has implemntations for different arithmethic operations on large numbers.

Num.java contains the following methods:
Level 1:
Num(String s): Constructor for Num class; takes a string s as parameter and creates the Num object representing that number in the chosen base. 
Num(long x): Constructor for Num class.
Num():Default Constructor for Num Class.

String toString(): Converts the Num class object into its equivalent string (in decimal). 
Num add(Num a, Num b):Sum of two numbers stored as Num.
Num subtract(Num a, Num b):Returns the Num corresponding to n1-n2.
Num product(Num a, Num b): Product of two numbers.
Num power(Num x, long n):Given an Num x  and long n, returns the Num corresponding to x^n (x to the power n). We have assumed that n is a nonnegative number. 
printList(): Prints the base + ":" + elements of the list, separated by spaces.

Helper Functions:
static Long next(ListIterator<Long> it):Helper Method to return the next element in the list.
static Num subtractHelp(Num a, Num b) : Helper method  for subtract functionality.
static Num productHelp(Num a,Num b): Helper Method to calculate the product.
static Num formatting(Num a): Helper function for formatting  the number.
public int compareTo(Num other): compares "this" to "other" and  returns +1 if this is greater, 0 if equal, -1 otherwise.

Level 2 :
Num power(Num x, Num n):Returns x^n, where x and n are both Num. Here x may be negative, but we have assumed that n is non-negative.
Num divide(Num a, Num b): Divide a by b result. Fractional part is discarded. If b is 0, we have raised an exception.
Num mod(Num a, Num b): Returns the remainder which we  get when a is divided by b (a%b). We have assumed that a is non-negative, and b > 0.
Num squareRoot(Num a): Returns the square root of number using binary search. We have assumed that a is non-negative.

Helper Functions:
static Num divideByTwo(Num a) - Helper function for divide functionality.
static Num binaryHelp(Num a,Num b)-Helper function for divide functionality 
static Num powerHelp(Num a, Num n) -Helper function to calculate the power   


LP1L1.java is the driver class  that illustrates the different arithmethic operations described in Level1 and Level2.

LP1L3.java is the  driver class that illustrates the methods, based on the following input/output specification.The operands of the expressions are names of variables and  the operators are {+, -, *, /, %, ^, |} representing add, subtract, multiply, divide, mod, power, and square root, respectively. 

Sample input:
a = 999 ;
b = 8 ;
c = a b ^ ;
d = a b + ;
;

Output:
999
8
992027944069944027992001
1007
10: 7 0 0 1
     




  
   
    

  	
   

