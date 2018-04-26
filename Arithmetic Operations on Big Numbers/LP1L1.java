// Sample code for Level 1 driver for lp1
/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/
// Change following line to your group number
package cs6301.g22;

public class LP1L1 {
    public static void main(String[] args) {
	Num x = new Num();
	Num y = new Num(12);
	Num z = new Num(98765432123456789L);
	Num eighteen = new Num(18);
	Num nine = new Num(9);
	Num a = Num.power(z, eighteen);
	Num c = Num.power(z, nine);
	Num b = Num.squareRoot(a);
	
	
	/*Num z1 = Num.add(x, y);
	System.out.println(z1);
	
	Num z2 = Num.subtract(x, y);
	System.out.println(z2);
		
	
	Num z3 = Num.product(x, y);
	System.out.println(z3);
	
	
	Num z4 = Num.divide(x, y);
	System.out.println(z4);
	
	
	Num z5 = Num.mod(x, y);
	System.out.println(z5);
	
	Num a = Num.power(x, y);
	System.out.println(a);
	
	Num z6=Num.power(x, 10);
	System.out.println(z6);
	*/
	//Num z1 = Num.squareRoot(x);
	System.out.println(b);
	System.out.println(c);
	x.printList();
	y.printList();
	
    }
}
