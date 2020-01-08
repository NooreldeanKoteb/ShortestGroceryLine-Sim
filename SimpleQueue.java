import java.util.Queue;
import java.util.NoSuchElementException;

//Class for a simple queue based on SimpleList
//The "front" of the queue should be the front of
//the list.

//READ THE DOCUMENTATION for the Queue interface for more information
//on how these methods should work and when exceptions should
//be thrown. This data structure does not allow adding null.

//DO NOT re-implement nodes in this class... remember how
//inheritance works in Java and make use of that!
/**
 * @author Nooreldean Koteb
 * @version 1.0
 */
class SimpleQueue<T> extends SimpleList<T> implements Queue<T> {
	/**
	 * This method adds a value to the list
	 * @param item value to add to list
	 * @return boolean true after adding to the list
	 */
	public boolean add(T item) {
		//O(1)
			add(size(),item);
		return true;
	}
	/**
	 * This method adds a value to the list
	 * @param item value to add to list
	 * @return boolean true after adding to the list
	 */
	public boolean offer(T item) {
		//O(1)
			add(item);
		return true;
	}
	/**
	 * This method remove a value from the list
	 * @throws NoSuchElementException if list doesnt exist
	 * @return removed value
	 */
	public T remove() {
		//O(1)
		if (head == null) {
			throw new NoSuchElementException();
		}else {
			return remove(0);
		}
	}
	/**
	 * This method remove a value from the list
	 * @return null if list is empty
	 * @return removed value
	 */
	public T poll() {
		//O(1)
		if (head == null) {
			return null;
		}else {
			return remove(0);
		}
	}
	/**
	 * This method gets the head node value
	 * @throws NoSuchElementException if list doesn't exist
	 * @return value of head
	 */
	public T element() {
		//O(1)
		if (head == null) {
			throw new NoSuchElementException();
		}else {
			return get(0);
		}
	}
	/**
	 * This method gets the head node value
	 * @return null if list doesn't exist
	 * @return value of head
	 */
	public T peek() {
		//O(1)
		if (head == null) {
			return null;
		}else {
			return get(0);
		}
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		SimpleQueue<Integer> nums = new SimpleQueue<>();
		
		nums.offer(2);
		nums.offer(3);
		nums.offer(5);
		
		if (nums.peek() == 2 && nums.size()==3){
			System.out.println("Yay 1");
		}
		
		if (nums.poll() == 2 && nums.poll() == 3 
			&& nums.poll() == 5 && nums.poll() == null){
			System.out.println("Yay 2");			
		}
	}
}