/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/

package cs6301.g22;

import java.lang.reflect.Array;

// Sentinel for the minimum value
class Minimum<T> implements Comparable<T>{

	T element = null;
	@Override
	public int compareTo(T element) {
		return -1;
	}
	
	}

// Sentinel for the maximum value
class Maximum<T> implements Comparable<T>{

	T element = null;
	@Override
	public int compareTo(T element) {
		return 1;
	}
	
	}



public class SkipListEntry<T extends Comparable<?super T>>{
	T element;
	SkipListEntry<T> next[];
	
	//Constructor
	public SkipListEntry(T element,int lev){
		this.element = element;
		next = new SkipListEntry[lev];
	}
	
	//Setters and Getters
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public SkipListEntry<T>[] getNext() {
		return next;
	}

	public void setNext(SkipListEntry<T>[] next) {
		this.next = next;
	}
	
	public int level(){
		return next.length-1;
	}

	public int compareTo(T x){
		Maximum<T> max = new Maximum<T>();
		Minimum<T> min = new Minimum<T>();
		if(x == min) // Comparison with the minimum(head) value
			return 1;
		else if(x == max) // Comparison with the maximum(tail) value
			return -1;
		else if(this.element.equals(x))
			return 0;
		else if(this.element.compareTo(x) < 0)
			return -1;
		else return 1;
		
	}
	 //resizes the next[] size of specified node by 1
	
	public void resizeIndex(int level, SkipListEntry<T> node){
		if(this.level() < level){
			SkipListEntry<T> [] rebuildArray = (SkipListEntry<T>[]) Array.newInstance(SkipListEntry.class, level+1);
			System.arraycopy(this.next, 0, rebuildArray, 0, this.next.length); // copies the next array contents into the rebuildArray 
			rebuildArray[level]=node;
			this.next = rebuildArray;
		}else{
			this.next[level]=node;
		}
	}
	
}
