/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/

package cs6301.g22;

import java.util.Iterator;
import java.util.Random;

public class SkipList<T extends Comparable<? super T>> {
    
	SkipListEntry<T> head;
	SkipListEntry<T> tail;
	
	int maxLevel = 0;
	int size = 2;
	
    Maximum<T> max = new Maximum<T>();
    Minimum<T> min = new Minimum<T>();
	
	public SkipList() {
		head = new SkipListEntry<T>((T) min,32);
		tail = new SkipListEntry<T>((T) max,32);
		
		for(int i=0; i<32;i++){
			head.next[i] = tail;
		}
		
    }
	
	public class ListIterator<T extends Comparable<? super T>> implements Iterator<T> {
	    private SkipListEntry<T> itNode; // current node
	    
		public ListIterator(SkipListEntry<T> head) {
			this.itNode=head;
		}
		
		public boolean hasNext() {
			return itNode.getNext()[0].element!= max; //reached the tail
		}

		public T next() {
			itNode=itNode.getNext()[0];
			return itNode.getElement();
		}
	}

    // Add x to list. If x already exists, replace it. Returns true if new node is added to list
    public boolean add(T x) {
    	SkipListEntry<T>[] prev = find(x);
    	if(prev[0].next[0].element.equals(x))
    		return false;
    	int lev = chooseLevel(maxLevel);
    	//System.out.println("lev is"+lev);
    		SkipListEntry<T> n = new SkipListEntry<T>(x,lev);
    		for(int i = 0; i < lev; i++){
    		   n.next[i] = prev[i].next[i];
    			prev[i].next[i] = n;
    		}
    		size++;
            return true;	
    	}
	
    

    // Find smallest element that is greater or equal to x
    public T ceiling(T x) {
    	SkipListEntry<T>[] prev = find(x);
    	SkipListEntry<T> n = prev[0].next[0];
	return (T) n.element;
    }

    // Does list contain x?
    public boolean contains(T x) {
    	SkipListEntry<T>[] prev = new SkipListEntry[maxLevel];
    	prev = find(x);
     return prev[0].next[0].element.equals(x)? true : false;
    }
    
    private int chooseLevel(int lev){
    	int level = 0;
    	int mask = (1 << maxLevel) - 1;
    	Random rand = new Random();
		level = Integer.numberOfTrailingZeros(rand.nextInt() & mask);
		if(level > maxLevel)
			return maxLevel+1;
		else
			return level;
    }
    
    private SkipListEntry<T>[]  find(T x){
    	SkipListEntry<T> p = head;
    	SkipListEntry<T>[] prev = new SkipListEntry[size];
    	for(int i = maxLevel;i>=0;i--){
    		while(p.next[i].element.compareTo(x) < 0)
    			p = p.next[i];
    		prev[i] = p;
    	}
 	return prev;
    }

    // Return first element of list
    public T first() {
     return (T)head.next[0].element;
    }

    // Find largest element that is less than or equal to x
    public T floor(T x) {
    	SkipListEntry<T>[] prev = find(x);
    	SkipListEntry<T> n = prev[0];
    	if(!n.next[0].element.equals(x))
	        return (T) n.element;
    	else
    		return (T) n.next[0].element;
	}

    // Return element at index n of list.  First element is at index 0.
    public T get(int n) {
    	ListIterator<T> itr = (ListIterator<T>) iterator();
    	T element =null;
		if(isEmpty()){
			return null;
		}else{
			if(size()>=n){
				for(int i=0; i<=n; i++){
					if(itr.hasNext()){
						element = itr.next();
					}else{
						break;
					}
				}
			}
		}
		return element;
	
    }

    // Is the list empty?
    public boolean isEmpty() {
    	if(size == 2)
	       return true;
    	else
    		return false;
    }

    // Iterate through the elements of list in sorted order
    public Iterator<T> iterator() {
    	ListIterator<T> listIterator = new ListIterator<T>(head);
		return listIterator;
	
    }

    // Return last element of list
    public T last() {
    	if(isEmpty()){
			return null;
		}else{
			SkipListEntry<T> p = head; // p points to the head of skip list
			for (int level = head.level(); level >= 0; level--) {
				while (p.getNext()[level] != null && p.getNext()[level].getNext()[0]!= null) {
					p = p.getNext()[level];
				}
			}
			return (T) p.getElement();
		}
    	
    }

    // Reorganize the elements of the list into a perfect skip list
    public void rebuild() {
    	int size = size();
		int height = (int) (Math.log(size) / Math.log(2));
		SkipListEntry<T> p = head;
		SkipListEntry<T> [] node;
		for(int i=1;i<=height;i++){
			p=head;
			while(p.getNext()!=null && p.getNext()[0]!=null & p.getNext()[i-1]!=null){
				node=p.getNext()[i-1].getNext();
				if(node[0]==null){
					p.resizeIndex(i, p.getNext()[i-1]);
				}else{
					p.resizeIndex(i, node[i-1]);
				}
				p=p.getNext()[i];
			}
		}
	
    }

    // Remove x from list.  Removed element is returned. Return null if x not in list
    public T remove(T x) {
    	SkipListEntry<T>[] prev = find(x);
    	SkipListEntry<T> n = prev[0].next[0];
    	if(!n.element.equals(x))
    		    return null;
    	  else{
    		for(int i= 0;i<=maxLevel;i++){
    			if(prev[i].next[i].equals(n))
    				prev[i].next[i] = n.next[i];
    			else 
    				break;
    		}
    		size--;
        	return (T) n.element;
        	
    		}
    }

    // Return the number of elements in the list
    public int size() {
	return size-2;
    }

    
}

