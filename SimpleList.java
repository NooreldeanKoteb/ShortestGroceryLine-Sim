import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.Iterator;

//Simple linked list class based on AbstractList
//READ THE DOCUMENTATION for AbstractList for more information
//on how these methods should work and when exceptions should
//be thrown. This data structure does not allow adding null
//elements.
/**
 * @author Nooreldean Koteb
 * @version 1.0
 */
class SimpleList<T> extends AbstractList<T> {
	//Add more instance variables here...
	//private or protected only!
	/**
	 * This private field variable stores the size of the list
	 */
	private int listSize;
	/**
	 * This private field variable saves the last node in the linked list
	 */
	private DoubleNode<T> tail = null;
	//Constructor
	/**
	 * This constructor initializes a simple list
	 */
	public SimpleList() {
		//O(1)
		this.listSize = 0;
	}
	/**
	 * This method returns the size of the list
	 * @return int of size of this list
	 */
	//returns the size
	public int size(){
		//O(1)
		return this.listSize;	
	}
	//returns the value at a given index
	/**
	 * This method iterates through and returns the value
	 * @param index of the item to get
	 * @return generic value of the item it got
	 */
	public T get(int index) {
		//O(n)
		int i = 0;
		Iterator<T> itr = iterator();
		T temp = itr.next();
		while (i < index) {
			temp = itr.next();
			i++;
		}
		return temp;
	}
	
	//sets the value at a given index and returns
	//the old value
	/**
	 * This method iterates through and sets the given index to a new value
	 * @param  index of item that will be replace
	 * @param value to be replaced at index
	 * @return generic old value that was replace
	 */
	public T set(int index, T value) {
		//O(n)
		int i = 0;
		T returnValue = null;
		DoubleNode<T> node1 = head;
		while(i < index) {
			node1 = node1.next;
			i++;
			if(i == index) {
				returnValue = node1.value;
				node1.value = value;
			}
		}
		return returnValue;
	}
	
	//adds a value at a given index
	/**
	 * This method adds a new value to the list
	 * @param  index of where to add value
	 * @param  value to add at index
	 * @throws IndexOutOfBoundsException if index is larger than size of list
	 */
	public void add(int index, T value) {
		//O(n)
		//Checks If index is out of bounds
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		//New Node with value created
		DoubleNode<T> node = new DoubleNode<T>(value);
		
		//Checks If appending to last node
		if(index == size() && head != null) {//Tail
			tail.next = node;
			node.prev = tail;
			tail = node;
			}else {
		
		//Checks If first node
		if(index == 0) {
			//If first Node it will be added set to head
			if(head == null) {
				head = node;
				tail = node;//Tail
			}else {
				//If not then node is linked at the start then set to head
				node.next = head;
				head.prev = node;
				//tail = head;//Tail
				head = node;
			}
			
		//If index is not 0 then it will go through the linked list
		}else {
			
			int i = 0;
			//Two nodes to help search and insert the new node
			DoubleNode<T> node1 = head;
			DoubleNode<T> node2 = head;
			//Will go through the linked list
			while(i < index) {				
				//If new node will be inserted
				if(i == index-1 && i < size()-1 ) {
					node2 = node1.next;
					 
					node1.next = node;
					node.prev = node1;
					 
					node.next = node2;
					node2.prev = node; 
					break;
					}
				//Linked list Loop
				node1 = node1.next;
				i++;
				
				}
			}
			}
		//Increment to list size
		this.listSize++;
	}
	
	//appends a value
	/**
	 * This method adds a new value to the list by calling the add function above
	 * @param  value to add
	 */
	public boolean add(T value) {
		//O(1)
		//Calls add method, with the last index available
		add(size(), value);
		return true;
	}
	
	
	//removes the value at a given index and returns
	//the value removed
	/**
	 * This method removes a value from the list at given index
	 * @param index of the value to remove from list
	 * @throws IndexOutOfBoundsException if index is larger than size of list
	 */
	public T remove(int index) {
		//O(n)
		//Checks If index is out of bounds
		if (index > size()-1) {
			throw new IndexOutOfBoundsException();
		}
		T returnValue = null;
		//Checks If first node
		if (head == null) {
			returnValue = null;
		}
		if(index == 0) {
				//If not then node is linked at the start then set to head
				if(head.next != null) {
					head = head.next;
					returnValue = head.prev.value;
					head.prev.next = null;
					head.prev = null;
				}else {
					returnValue = head.value;
					head = null;
				}	
			//If index is not 0 then it will go through the linked list
		}else {
			int i = 0;
			//Two nodes to help search and insert the new node
			DoubleNode<T> node1 = head;
			DoubleNode<T> node2 = head;
			
			//Will go through the linked list
			while(i < index) {
				//If new node should be appended at the end
				if(i == size()-2) {
					tail = node1;
					returnValue = node1.next.value;
					
					node1.next.prev = null;
					node1.next = null;
					break;
					}
				
				//If new node will be inserted
				if(i == index-1 && i < size()-2) {
					node2 = node1.next.next;
					
					returnValue = node2.prev.value;
					
					node1.next = node2;
					node2.prev.prev =null;
					node2.prev.next = null;
					node2.prev = node1;
					break;
					}
				//Linked list Loop
				node1 = node1.next;
				i++;
				}
			}
		//update to list size
		this.listSize--;
		
		return returnValue;
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		SimpleList<Character> letters = new SimpleList<>();
		for (int i=0; i<5; i++)
			letters.add((char)(97+i*2));
			
		if (letters.size() == 5 && letters.get(0) == 'a'){
			System.out.println("Yay 1");
		}
		
		if (letters.set(1,'b') == 'c' && letters.get(1) == 'b'){
			System.out.println("Yay 2");
		}
		
		letters.add(2,'c');
		if (letters.size() == 6 && letters.get(2) == 'c' && letters.get(3)=='e'){
			System.out.println("Yay 3");
		}
		
		if (letters.remove(3)=='e' && letters.size() == 5 && letters.get(3)=='g'){
			System.out.println("Yay 4");
		}
	}
	
	//-------------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE EXCEPT TO ADD JAVADOCS
	//-------------------------------------------------------------
	
	//bad practice to have public inst. variables, but we want to test this...
	/**
	 * This field variable holds the first value in the linked list
	 */
	public DoubleNode<T> head = null;
	
	//provided doubly-linked list node class
	//bad practice to have public inst. variables,
	//in a public nested class, but we want to test this...
	/**
	 * This class creates Nodes for the linked list
	 */
	public static class DoubleNode<T> {
		public T value;
		
		public DoubleNode<T> next;
		public DoubleNode<T> prev;
		
		public DoubleNode() { }
		public DoubleNode(T value) { this.value = value; }
	}
	
	//provided toString() method
	/**
	 * This method creates a string from the list
	 */
	public String toString(){
		StringBuilder sBuilder = new StringBuilder("");
		for (T value : this){
			sBuilder.append(value);
			sBuilder.append(" ");
		}
		return sBuilder.toString();
	}
	
	//provided iterator, if your code is working, this should
	//work too...
	/**
	 * This method is an iterator that checks if the value hasnext, and switches to next value.
	 * @return generic value of the node
	 * @return boolean true or false if there is a next value
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			DoubleNode<T> current = head;
			
			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				T val = current.value;
				current = current.next;
				return val;
			}
			
			public boolean hasNext() {
				return (current != null);
			}
		};
	}
}