
// Starter code for lp1.
/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/
// Change following line to your group number
// Changed type of base to long: 1:15 PM, 2017-09-08.
package cs6301.g22;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Num  implements Comparable<Num> {

    static long defaultBase = 10;  // This can be changed to what you want it to be.
    long base = defaultBase;  // Change as needed
     LinkedList<Long> list= new LinkedList<Long>();
     boolean sign;
    /* Start of Level 1 */
     
    Num(String s) {
      int size;
      Num	result=  new Num(0L);
      
      if (s.contains("-")) {
 			sign = true;
 			size=s.length()-1;
    	}
    	else{
    		sign=false;
    		size=s.length();
    	}
    		for(int i = 0; i <size ; i++)
    			{
    			  result=add(product(result, new Num(10L)), new Num (Long.parseLong(s.substring(i, i+1))));	
    			this.list=result.list;
    			}
      }

    Num(long x) {
    	if(x>=0)
    	{
    		sign=false;
    	}
    	else
    	{
    		sign=true;
    		x=x*-1;
    	}
    	
    	do
    	{
    		list.add(x%base);
    		x=x/base;
    	}while(x!=0);
        	
    }

    
	public Num() {
	
	}
	
//Helper Method to return the next	element in the list 
	static Long next(ListIterator<Long> it)
    {
    	if(it.hasNext())
    		return  (Long) it.next();
    	else
    		return 0L;
    }

// Method to add two numbers
	static Num add(Num a, Num b) {
    	long carry = 0;
    	long sum=0;
    	Num addlist= new Num();
    	Num temp=new Num();
    	ListIterator<Long> it1= a.list.listIterator();
    	 ListIterator<Long> it2= b.list.listIterator();
    
    	
    	 if(a.sign==b.sign)
    	 {	 
    		 
    	 while (it1.hasNext() || it2.hasNext() || carry>0)
    	 {
    		 sum=next(it1)+next(it2)+carry;
    		 addlist.list.add(sum%a.base);
    		 carry=sum/a.base;
    		 
    	 }
    	   addlist.sign=a.sign;
    	   return formatting(addlist) ;
    	 }
    	 else
    		 if(a.sign)
    		 {
    			 a.sign=!a.sign;
    			 temp=subtract(b, a);
    			 a.sign=!a.sign;
    		     return temp;
    		 }
    		 else
    		 {
    			 b.sign=!b.sign;
    			 temp=subtract(a, b);
    			 b.sign=!b.sign;
    		     return temp;
    		 }
    	     }
    
//Helper method  for subtract functionality	
    static Num subtractHelp(Num a, Num b)
    {
    	long borrow=a.base;
    	long sub=0;
    	Num sublist= new Num();
    	 ListIterator<Long> it1= a.list.listIterator();
    	 ListIterator<Long> it2= b.list.listIterator();
    	 boolean flag=false;
		  while (it1.hasNext() || it2.hasNext())
    	 {
			 long  temp1=next(it1);
			 long  temp2=next(it2);
			if(flag)
			{
				temp1=(temp1-1)%a.base;
			}
			if(temp1>=temp2)
			{
			 sub=temp1-temp2;
			 sublist.list.add(sub);
			 flag=false;
			 }
			else
			{
				sub=temp1-temp2+borrow;
				sublist.list.add(sub);
				flag=true;
			}
		 }
		 return formatting(sublist);
    	}
    
    // Method to calculate the subtract operation 
    static Num subtract(Num a, Num b) {
    	Num temp=new Num();
    	if(a.sign!=b.sign)
    	{
    		b.sign=!b.sign;
    		temp=add(a,b);
    		b.sign=!b.sign;
    	  return temp;
    	}
    	else
    	{
    	 if(a.compareTo(b)==1)
    	 {
                   temp=subtractHelp(a,b);
                   temp.sign=false;
                   return temp;
    	 }
    	 else if(a.compareTo(b)==-1)
    	 {
    		 temp=subtractHelp(b,a);
             temp.sign=true;
             return temp;//set the sign bit to -1
    	 }
    	 else
    	 {
    		 Num sublist=new Num(0L);
    		 return  sublist;
    	 }
    	}
    }
    
    //Helper Method to calculate the product
    static Num productHelp(Num a,Num b)
    {
   	    ListIterator<Long> it2= b.list.listIterator();
	     Num productList= new Num();
	     int counter=0;
	    while(it2.hasNext())
	    {
	    	Long carry=0L;
	       	Num temp= new Num();
	    	ListIterator<Long> it1= a.list.listIterator();
	    	long temp1=next(it2);
    		for(int i=0;i<counter;i++)
    		{
    			temp.list.add(0L);
    		}
	    	while(it1.hasNext())
	    	{
	    		long temp2=next(it1);

	    		temp.list.add((temp1*temp2 + carry)%a.base);
	    		carry=(temp1*temp2+carry)/a.base;
	    	}
	    	temp.list.add(carry);
	    	counter++;
	    	productList=add(temp,productList);
	     }
	    if(a.sign==b.sign)
	    {
	    	productList.sign=false;
	    }
	    else
	    {
	    	productList.sign=true;
	    }
    	return formatting((productList));
    }
    
    //Method to calculate the product of two numbers
    // Implement Karatsuba algorithm for excellence credit
    static Num product(Num a, Num b) {
    	if(a.compareTo(b)==1)
	     	return (productHelp(a, b)); 
	     else 
	    	 return (productHelp(b, a));
    }

    // Method to calculate the power
    static Num power(Num a, long n) {
    	if(n==0)
    	{
    		Num powerList=new Num(1L);
    		 		return powerList;
    	}
    		else if(n==1)
    		return a;
    	else
    	{
    		if(n%2==0)
    		{ 
    			return product(power(a,n/2),power(a,n/2));
    		}
    		else
    			return product(product(power(a,n/2),power(a,n/2)),a);
    	}
    	
    }
    
    /* End of Level 1 */

    /* Start of Level 2 */
 //Helper function for divide functionality
    static Num divideByTwo(Num a)
 {
	 Iterator<Long> it= a.list.descendingIterator();
		Num quolist= new Num();
	   long mod=0; 
	   long temp;
		 
	 while(it.hasNext())
	 {
		 temp=it.next();
		 quolist.list.addFirst((mod*a.base+temp)/2);
		 mod=(mod*a.base+temp)%2;
	 }
	 return formatting(quolist);
 }
 
   //Helper function for divide functionality 
 static Num binaryHelp(Num a,Num b)
 {
	   return divideByTwo(add(a, b));
 }
    
    static Num divide(Num a, Num b) {
    	Num lower=new Num(0L);
    	Num upper=a;
    	Num one =new Num(1L);
    	one.sign=false;
    	Num X=binaryHelp(lower, upper);
    	if (b.compareTo(lower)==0)
    		throw new IllegalArgumentException();
    
    	
    	while(!(((a.compareTo(product(X,b))==1)||(a.compareTo(product(X,b))==0)) && (a.compareTo(product(add(X,one),b))==-1)))
    	{	
    	if(a.compareTo(product(add(X,one),b))==1)
    	{
    		lower=X;
    		X=binaryHelp(lower,upper);
    	}
    	else if(a.compareTo(product(X, b))==-1 )
    	{
    		upper=X;
    		X=binaryHelp(lower, upper);
    	}
    	else if (a.compareTo(product(X,b))==0)
    	{
    		if(a.sign==b.sign)
        	{
        		X.sign=false;
        	}
        	else
        		X.sign=true;
    	return X;
    	}
    	else
    	{
    		if(a.sign==b.sign)
        	{
        		X.sign=false;
        	}
        	else
        		X.sign=true;
    	return add(X,one);
    	}
    	}
    	if(a.sign==b.sign)
    	{
    		X.sign=false;
    	}
    	else
    		X.sign=true;
	return X;
    }
//Method to calculate the mod function 
    static Num mod(Num a, Num b) {
   return subtract(a, product(divide(a, b), b));
    }
 //Helper function to calculate the power   
static Num powerHelp(Num a, Num n)
{
	ListIterator<Long> it2= n.list.listIterator();
	Num base=new Num(1L);
    long temp;
	 while(it2.hasNext())
	 {
		 temp=it2.next();
		 it2.remove();
		 return product(power(power(a, n),n.base),power(a, temp));
	 }
  return base;
	    
}
//Method to calculate the power of two numbers  
// Use divide and conquer
    static Num power(Num a, Num n) {
    	 ListIterator<Long> it= n.list.listIterator();
    	Num n1=new Num();
    	 while(it.hasNext())
    	 {
    		 n1.list.add(it.next());
    	 }
    	  return powerHelp(a, n1);
     }

    //Method to calculate the square root of a number
    static Num squareRoot(Num a) {
    	Num lower=new Num(0L);
    	Num upper=a;
    	Num one =new Num(1L);
    	Num X=binaryHelp(lower, upper);
    	
    	while(!((a.compareTo(product(X,X))==1) && (a.compareTo(product(add(X,one),add(X,one)))==-1)))
    	{
       	if(a.compareTo(product(add(X,one),add(X,one)))==1)
    	{
    		lower=X;
    		X=binaryHelp(lower,upper);
    	}
    	else if(a.compareTo(product(X, X))==-1)
    	{
    		upper=X;
            X=binaryHelp(lower, upper);
    	}
    	else
    	{
    		if(a.compareTo(product(add(X,one),add(X,one)))==0)
    		{
    			return add(X,one);
    		}
    		else if (a.compareTo(product(X, X))==0)
    		{
    			return X;
    		}
    		break;
    	}
    	}
	return X;
   }
    /* End of Level 2 */
    
    //Helper function for formatting  the number
    static Num formatting(Num a)
    {
    	Iterator<Long> it= a.list.descendingIterator();
    	Num formatList= new Num();
    	formatList.sign=a.sign;
    	
    	long temp=0;
    	do
    	{
    		temp = it.next();
    	}while(temp==0&&it.hasNext());
    	formatList.list.addFirst(temp);
    	while(it.hasNext())
    	{
    		 formatList.list.addFirst(it.next());
    			
    	}
    	 return formatList;
    }
 

    // Utility functions
    // compare "this" to "other": return +1 if this is greater, 0 if equal, -1 otherwise
    public int compareTo(Num other) {
     ListIterator<Long> it1= this.list.listIterator();
   	 ListIterator<Long> it2= other.list.listIterator();
   	 int greater=0;
   	 if(this.list.size()>other.list.size())
   	 {
   		 greater= 1;
   	 }
   	 else if(this.list.size()<other.list.size())
   	 {
   		 greater= -1;
   	 }
   	 else
   	 {
   		while(it1.hasNext())
      	 {
   			 long  temp1=next(it1);
			 long  temp2=next(it2);
   		     if(temp1>temp2)
   			 {
   				 greater=1;
   			 }
   			 else if(temp1<temp2)
   			 {
   				 greater=-1;
   			 }
       	 }
     }
   	return greater;
 }
    
    
    
    // Output using the format "base: elements of list ..."
    // For example, if base=100, and the number stored corresponds to 10965,
    // then the output is "100: 65 9 1"
    void printList() {
    	  ListIterator<Long> it= this.list.listIterator();
    	    System.out.print("\""+base +": ");
    	   	while(it.hasNext())
    	   	{
    	     System.out.print(it.next() + " ");
    	   	}
    	   	System.out.print("\"");
    	   	System.out.println();
    }
    @Override
    // Return number to a string in base 10
    public String toString() {
    	//convert to base10 and reverse the printorder
    			 Iterator<Long> it= this.list.descendingIterator();
    			 StringBuilder sb=new StringBuilder();
    			 if(this.sign)
    			 {
    				 sb.append("-");
    			 }
    			 while(it.hasNext())
    			 {
    			   sb.append(it.next());
    			 }
	return sb.toString();
    }

    public long base() { return base; }
}
