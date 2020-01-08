import java.util.NoSuchElementException;
import java.util.Date; //for testing

//priority queue where the minimum item has the highest priority
/**
 * @author Nooreldean Koteb
 * @version 1.0
 */
class PriorityQueue<T extends Comparable<T>> extends SimpleQueue<T> {
	//updates an item that's already in the queue
	//NOTE: This should update the exact item in memory, 
	//not just any "equal" item (in other words, you 
	//should use == here and not .equals())
	/**
	 * This method updates a given item's spot in the list
	 * @param item that will be updated
	 * @throws NoSuchElementException if the item doesn't exist
	 */
	public void update(T item) 	{
		//O(n)
		boolean excep = true;
		int index = 0;
		int newIndex =0;
		//throws NoSuchElementException if item is not
		//in the queue	
		for(int i = 0; i < size(); i++) {
			if((this.get(i)==item)) {
				excep = false;
				index = i;
				}
			}
		if(excep) {
			throw new NoSuchElementException();
			}

		for(int i = 0; i < size()-1; i++) {
			if(get(i).compareTo(get(index)) > 0) {
					newIndex = i;
					break;
				
			}
		}
		if(get(newIndex).compareTo(get(index)) > 0) {
			T replace = remove(index);
			add(newIndex, replace);
		}
	}
	
	//You may need to override some other methods from SimpleQueue!
	
	//Restriction 1: all methods from SimpleQueue should still work
	//(as in, if you add(), the value should be added, if you call 
	//size() it should return the correct value, etc.). However, 
	//remove/poll will remove the _minimum_ value from the queue;
	//element/peek will return the _minimum_ value from the queue.
	
	//Restriction 2: element() and peek() must still both be O(1)
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		PriorityQueue<Date> values = new PriorityQueue<>();
		Date[] dates = new Date[5];
		for (int i=5; i>=1; i--){
			dates[i-1] = new Date(86400000*i);
			values.add(dates[i-1]);
		}
		
		for(Date d : values) {
			System.out.println(d);
		}

		dates[3].setTime(0);
		values.update(dates[3]);
		
		System.out.println();
		for(Date d : values) {
			System.out.println(d);
		}
		
		if(values.peek().equals(dates[3])) {
			System.out.println("\nYay 1");
		}
	}
}