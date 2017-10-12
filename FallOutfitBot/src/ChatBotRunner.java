import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author 
 * @version October 2017
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{

		System.out.println ("Welcome to Fall Outfit Bot, a bot that recommends you fall themed outfits based on your preferences. Are you looking for male, female, or unisex clothes?");
		Scanner in = new Scanner (System.in);
		
		String gender = "";
		String statement = in.nextLine();
		
		
		if(statement.toLowerCase().equals("male"))
		{
			gender = "male";
		}
		else if(statement.toLowerCase().equals("female"))
		{
			gender = "female";
		}
		else
		{
			gender = "unisex";
		}


		
		System.out.println("You chose " + gender +". Would you like to start with tops, bottoms, shoes, or accessories?");
		statement = in.nextLine();
		
		if(statement.toLowerCase().equals("tops"))
		{
			ChatBotSarwar chatbot1 = new ChatBotSarwar();
			
			statement = in.nextLine();
		}
		
		if(statement.toLowerCase().equals("bottoms"))
		{
			ChatBotLamia chatbot2 =  new ChatBotLamia();
			//statement = in.nextLine();
			
			while(!statement.equals("Bye"))
			{
				//statement=in.nextLine();
				System.out.println(chatbot2.askname());
				statement=in.nextLine();
				System.out.println(chatbot2.getname(statement));
				System.out.println(chatbot2.starttalking());
				statement = in.nextLine();
				System.out.print(chatbot2.getresponse(statement));
				statement=in.nextLine();
				
				
				
			}
			System.out.print("Farewell thee " + chatbot2.returnname());
		}
		
		if(statement.toLowerCase().equals("shoes"))
		{
			ChatBotKaitlyn chatbot3 = new ChatBotKaitlyn();
			System.out.println(chatbot3.greetUser());
			while(!statement.equals("Bye"))
			{
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
				System.out.println(chatbot3.determineEventType(statement));
				statement = in.next();	
			}			
		}
		if(statement.toLowerCase().equals("accessories"))
		{
			ChatBotMonroe chatbot4 = new ChatBotMonroe();
			while(!statement.equals("Bye"))
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
				
			}
			
			
		}

	}
	

}
