
public class Scenario {

	//variables for a character
	private String name = "";
	private String item = "";
	private boolean alive = true;
	
	//initializes a scenario object
	public Scenario(String name, String item, boolean alive) {
		this.name = name;
		this.item = item;
		this.alive = alive;
	}
	
	/* Calls for scenarios given the location
	 * PreCondition: location must be given by the user
	 */
	public String chooseLocation(String location) {
		String nextLine = "";
		
		if(location.equals("window")) {
			System.out.println("The fire was upstairs and you decided to walk into the fire. You died" + "\n");
			alive = false;
			return deadScenario(alive);
		}
		else if(location.equals("basement")) {
			nextLine = basementScenario(item);
			return nextLine;
		}
		else if (location.equals("front") || location.equals("back")){
			System.out.println("You entered through the " + location + " safely and continued to save your son" + "\n");
			nextLine = doorScenarios(item);
			return nextLine;
		}
		else {
			return deadScenario(alive);
		}
	}
	
	/*Returns scenarios for basement location
	 * PreCondition: location must be basement
	 */
	public String basementScenario(String item) {
		System.out.println("Oh no! There is an ogre that lives in the basement. He is very hungry. What will happen?" + "\n");
		String nextLine = "";
		
		if(item.equals("axe")) {
			System.out.println("You used the axe to chop off your hand. Your fed it to the ogre and he let you live." + "\n");
			nextLine = survivedBasement(item);
			return nextLine;
		}
		else if (item.equals("sock")) {
			System.out.println("You fed the ogre a sock and he decides to help you find your son." + "\n");
			nextLine = survivedBasement(item);
			return nextLine;
		}
		else if(item.equals("mask")) {
			System.out.println("The ogre body slams you because your mask scared him, you died." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else if (item.equals("pizza")){
			System.out.println("You try to feed the pizza to the ogre, but he hates pizza. He eats you, and you die." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else {
			return notAnItem(item);
		}
	}
	
	/* Returns Scenarios for surviving the basement
	 * PreCondition: Location must be basement and the item must be either an axe or a sock
	 */
	public String survivedBasement(String item) {
		System.out.println("You made it out of the basement. And look! your baby is right there. Let's save him!" + "\n");
		String nextLine = "";
		
		if(item.equals("axe")) {
			System.out.println("You grab your baby, but as you are running out of the house, you drop him. "
				+ "\n"	+ "You couldn't handle the weight of them with your one hand. You both die." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else if (item.equals("sock")) {
			System.out.println("The sock you fed the ogre wasn't enough to satisfy his hunger. He eats your baby and leaves you there to grieve. You die crying." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else {
			return notAnItem(item);
		}
	}
	
	/* Returns scenarios given the location is a door
	 * PreCondition: location must be either front or back
	 */
	public String doorScenarios(String item) {
		System.out.println("and look! Your son is on the couch watching Mickey Mouse. Go and save him!" + "\n");
		String nextLine = "";
		
		if(item.equals("axe")) {
			System.out.println("Your baby is threatened by the axe you're carrying. "
				+ "\n"	+ "He decides he must fight you to the death. Your own child defeats you and you die." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else if(item.equals("mask")) {
			System.out.println("Your baby has a heart attack because the mask is scary. They die and you die." + "\n");
			alive = false;
			nextLine= deadScenario(alive);
			return nextLine;
		}
		else if (item.equals("sock")) {
			System.out.println("Your baby grabs the sock, puts it over his head and robs you. "
					+ "\n" + "He shoots you with his finger gun when you don't give him your money. You died." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else if (item.equals("pizza")) {
			System.out.println("Why'd you bring a slice of pizza when there's a fire? That was dumb. You both burn and die." + "\n");
			alive = false;
			nextLine = deadScenario(alive);
			return nextLine;
		}
		else {
			return notAnItem(item);
		}
	}
	
	/* Returns a possible ending to the game
	 * PreCondition: Character object must be alive or dead
	 */
	public String deadScenario(boolean alive) {
		if(alive == false) {
		return ("I am sorry " + name + ", you have lost. Will you like to try again. Enter y for yes, and n for no." + "\n");
		}
		else {
			return ("That wasn't a choice of entry. You win, well done " + name + "! Enter a y if you'd like to play again, or a n if not." + "\n");
		}
	}
	
	
	/* Returns a possible end to the game
	 * PreCondition: an item variable must be declared
	 */
	public String notAnItem(String item) {
		return ("Your Choice of a " + item + " was not an option. As it turns out " + name + ", you are schizophrenic. "
			+ "\n"	+ "The entire scenario was a fabrication of your imagination. You won because you can't read. Well done! Enter a y to play again, or a n to leave." + "\n");
	}
}
