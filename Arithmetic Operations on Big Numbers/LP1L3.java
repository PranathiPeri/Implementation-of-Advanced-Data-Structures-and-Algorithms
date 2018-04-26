// Starter code for Level 3 driver for lp1
/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/
// Change following line to your group number
package cs6301.g22;
import cs6301.g22.Num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;

public class LP1L3 {

       public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	LP1L3 x = new LP1L3();
	HashMap<String,String> h=new HashMap<String,String>(); 
	Stack <Num> stack= new Stack<>();
	ArrayList<String> al = new ArrayList<String>();
	Num rs=new Num();
	while(in.hasNext()) {
	   // To store variables
		String word = in.nextLine();
	    if(word.equals(";"))
	    {
	    	break;
	    }
	     
      String[] result = word.split("\\s+");
	        
        Pattern p = Pattern.compile("0|([1-9][0-9]*)");
	    Matcher m = p.matcher(result[2]);
	    if (m.find())
	    		{
	                      h.put(result[0],result[2]);
	                      al.add(result[2]);
	    		}
	    else
	    {
	    	
	    	for(int i=2; i<(result.length);i++)
	    	{
	    		if(isOperator(result[i]))
	    		{
	    			if(result[i].equals("+"))
	    			{
	    			Num a= stack.pop();
	    			Num b= stack.pop();
	 
	    			stack.push((Num.add(b,a)));
	    			
	    		    }
	    			else if(result[i].equals("-"))
	    			{
	    				Num a= stack.pop();
		    			Num b= stack.pop();
		    			stack.push((Num.subtract(b,a)));
		    		}
	    			else if(result[i].equals("*"))
	    			{Num a= stack.pop();
	    			Num b= stack.pop();
	    			stack.push((Num.product(b,a)));
	    		    }
	    			else if(result[i].equals("/"))
	    			{Num a= stack.pop();
	    			Num b= stack.pop();
	    			stack.push((Num.divide(b,a)));
	    		    }
	    			else if(result[i].equals("%"))
	    			{Num a= stack.pop();
	    			Num b= stack.pop();
	    			stack.push((Num.mod(b,a)));
	    		    }
	    			else if(result[i].equals("^"))
	    			{
	    			Num a= stack.pop();
	    			Num b= stack.pop();
	    			stack.push((Num.power(b,a)));
	    		    }
	    			else if(result[i].equals("|"))
	    			{
	    			Num a= stack.pop();
	    			stack.push((Num.squareRoot(a)));
	    		    }
	    		}
	    		else if(result[i].equals(";"))
	    		{
	    			 rs= stack.pop();
	    			h.put(result[0],rs.toString());
	    			al.add(rs.toString());
	    		}
	    		else
	    		{
	    		 Num operand= new Num(h.get(result[i]));
	    		 stack.add(operand);
	    		
	    		}
	      }
	    	
	    	}
	   
	   	}
	 for (int i = 0; i < al.size(); i++) {
            System.out.println( al.get(i));
	 }
	rs.printList();
    
       }
       public static  boolean isOperator(String c) {
	    	return ( (c.equals("+")) || (c.equals("-")) ||(c.equals("*")) || (c.equals("/"))||(c.equals("%"))||(c.equals("^"))||(c.equals("|")) );
	    	}  

}
