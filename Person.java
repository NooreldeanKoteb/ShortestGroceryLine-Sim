//class representing a person and their cart
/**
 * @author Nooreldean Koteb
 * @version 1.0
 */
class Person {
	//Add more instance variables here...
	//private or protected only!
	/**
	 * This field variable stores how many items the person has
	 */
	private int items;
	
	//Sets up a person with a given number of items.
	/**
	 * This constructor initializes the number of items the person has.
	 * @param numItems - The number of items to give to the person (int)
	 * @throws IllegalArgumentException if invalid number of items is given
	 */
	public Person(int numItems) {
		//O(1)
		//throws an IllegalArgumentException if numItems is
		//invalid (the person has less than one item)
		if (numItems < 1) {
			throw new IllegalArgumentException("Invalid number of items");
		}else {
			this.items = numItems;
		}
	}
	
	//Gets how many items the person still has.
	/**
	 * This method returns the current amount of items a person has.
	 * @return an Int of The amount of items a person has.
	 */
	public int getNumItems() {
		//O(1)
		return this.items;
	}
	
	//Removes one item from this person (i.e. "checks out"
	//one item from this person.
	/**
	 * This method removes 1 item from the amount of items the person has.
	 */
	public void removeItem() {
		//O(1)
		this.items--;
	}
	
	//Indicates whether or not this person has any more
	//items left to "check out".
	/**
	 * This method checks if the person has any more items.
	 * @return true or false based on if the person has checked out all his items.
	 */
	public boolean done() {
		//O(1)
		if(this.items == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		Person mason = new Person(2);
		if (mason.getNumItems() == 2 && !mason.done()){
			System.out.println("Yay 1");
		}
		
		mason.removeItem();
		boolean ok = (mason.getNumItems() == 1);
		mason.removeItem();
		if ( ok && mason.done()){
			System.out.println("Yay 2");
		}
	}
	
	//-------------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE EXCEPT TO ADD JAVADOCS
	//-------------------------------------------------------------
	
	//provided toString() method
	/**
	 * This method returns Person(with number of items)
	 * @return String person + number of items
	 */
	public String toString() {
		return "Person("+getNumItems()+")";
	}
}