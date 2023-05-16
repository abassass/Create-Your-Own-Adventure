import java.util.*;

public class Driver {
	public static void main (String[] args) {
	
	//initialize a scanner object	
	Scanner input = new Scanner(System.in);
	
	//variables used for the scenario object
	String name = "";
	String item = "";
	boolean alive = true;
	
	//while loop allows the user to play until choice isn't "y"
	String choice = "y";
	while(choice.equals("y")) {
		
		//collects the name of the user
		System.out.println("Hi! What is your name?" + "\n");
		name = input.next();
		
		//collects the item of the user
		System.out.println("Hi " + name + ". You wake up on your front lawn, and YOUR HOUSE IS ON FIRE. Not only that, but your child is still inside. "
				+"\n"+ "You must save him. Around you are four items: a mask, an axe, a sock, and a slice of pizza. "
					+ "\n"	+ "You can only choose one to help you on your journey. What will you choose? (type strictly sock, pizza, axe, or mask)" + "\n" );
		item = input.next();
		
		//initializes the user's scenario object
		Scenario character = new Scenario(name, item, alive);
		System.out.println("Excellent choice " + name +  "! I am sure that will be helpful on your journey." + "\n");
		
		//given the user input, the scenario object uses the location to create a story
		System.out.println(name + ", you must first choose your route into the home. Type back for the back door, type front for the front door, "
				+ "\n"+ "type basement for the basement, or type window for the upstairs window." + "\n");
		String location = input.next();
		System.out.println(character.chooseLocation(location));
		choice = input.next();
	}
	
	input.close();
	}
}
