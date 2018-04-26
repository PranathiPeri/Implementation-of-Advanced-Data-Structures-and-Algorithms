/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/

package cs6301.g22;

import java.util.Iterator;

import cs6301.g22.SkipList.ListIterator;

public class lp5Driver {

	public static void main(String[] args){
		SkipList<Integer> sl = new SkipList<Integer>();
		Integer i = new Integer(5);
		Integer i1 = new Integer(51);
		Integer i2 = new Integer(55);
		Integer i3 = new Integer(15);
		Integer i4 = new Integer(25);
		Integer i5 = new Integer(21);
		Integer i6 = new Integer(2);
		Integer i7 = new Integer(22);
		Integer i8 = new Integer(49);
		Integer i9 = new Integer(62);
		Integer i10 = new Integer(51);
		sl.add(i);
		sl.add(i1);
		sl.add(i2);
		sl.add(i3);
		sl.add(i4);
		sl.add(i5);
		sl.add(i6);
		sl.add(i7);
		sl.add(i8);
		sl.add(i9);
		sl.add(i10);
		
		Iterator<Integer> li = sl.iterator();
		
		while(li.hasNext())
			System.out.println(li.next().intValue());
		int n = 6;
		System.out.println("Element at position "+ n +": "+sl.get(n));
			
	System.out.println("Ceiling of the Element "+sl.ceiling(i2));
	System.out.println("Floor of the Element "+sl.floor(i2));
	System.out.println("Last Element "+sl.last());
	System.out.println("First Element "+sl.first());
	
	System.out.println("Element Removed "+sl.remove(i1));
	
	sl.rebuild();
	
		
	}
	
}
