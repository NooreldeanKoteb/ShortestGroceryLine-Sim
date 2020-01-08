import java.util.Queue;

//A data structure (based on a queue) to represent a grocery
//store line.

//Grocery lines can only contain people and can be compared 
//to eachother based on the number of items left to process
//in the line. The lines also have id numbers.
/**
 * @author Nooreldean Koteb
 * @version 1.0
 */
class GroceryLine extends SimpleQueue<Person> implements Comparable<GroceryLine> {
	/**
	 * This field variable saves the int id number for the grocery line
	 */
	private int id;
	/**
	 * This field variable saves the int number of items in the grocery line
	 */
	private int items;
	
	//Creates a grocery store line with a given ID.
	/**
	 * This constructor initializes the Grocery line
	 * @param id takes in id number
	 */
	public GroceryLine(int id) {
		//O(1)
		this.id = id;
	}
	
	//Returns the ID of the grocery line.
	/**
	 * This method returns the id number
	 * @return int id number
	 */
	public int getId() {
		//O(1)
		return this.id;
	}
	
	//Sums up all items for all people in the line.
	/**
	 * This method calculates number of items in the line and returns it
	 * @return int sum of items in the line
	 */
	public int itemsInLine() {
		//O(n), where n = the number of people in line
		this.items = 0;
		for (int i = 0; i < size(); i++) {
			this.items += get(i).getNumItems();
		}
		return this.items;
	}
	
	//Compare one grocery line to another based on
	//the number of items in the line and then, if
	//the two lines are tied, by their id.
	/**
	 * This method compares two lines and returns the result
	 * @return int result of compareTo
	 */
	public int compareTo(GroceryLine otherLine) {
		//O(n+m), where n = the number of people in the
		//first line and m = the number of people in the
		//second line
		if(0 ==  Integer.valueOf(this.itemsInLine()).compareTo(Integer.valueOf(otherLine.itemsInLine()))) {
			if (this.id < otherLine.id) {
				return this.id;
			}else {
				return otherLine.id;	
			}
		}
		return Integer.valueOf(this.itemsInLine()).compareTo(Integer.valueOf(otherLine.itemsInLine()));
	}
	
	//Processes (removes) one item from the first
	//person in line. If the person has no more
	//items they are removed from the line.
	/**
	 * This method processes one item from the line and removes a person if they are done
	 */
	public void processItem() {
		//O(1)
		if(this.head == null) {
		}else {
			if(get(0).done()) {
				poll();//remove() //remove(0)
			}else {
				this.get(0).removeItem();	
			}
		}
	}
	//Converts the line to a string.
	/**
	 * This method collects all the information to create a string with it
	 * @return String with the compiled line of information
	 */
	public String toString() {
		//O(n), where n = the number of people in line
		String line = Integer.toString(this.id)+":";
		for (int i = 0; i <this.size(); i++) {
			line += " Person("+Integer.toString(this.get(i).getNumItems())+")";
		}
		System.out.println(line);
		return line;
	}

	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args) {
		GroceryLine line = new GroceryLine(0);
		Person mason = new Person(10);
		Person george = new Person(20);
		
		line.offer(mason);
		line.offer(george);
		
		if (line.getId()==0 && line.itemsInLine() == 30){
			System.out.println("Yay 1");
		}
		line.processItem();
		if (line.itemsInLine() == 29 && line.peek().getNumItems()==9){
			System.out.println("Yay 2");
		}
		
		GroceryLine line2 = new GroceryLine(1);
		Person washington = new Person(40);
		line2.offer(washington);
		
		if (line.compareTo(line2)<0){
			System.out.println("Yay 3");
		}
		line.toString();
		line2.toString();
		
	}
}