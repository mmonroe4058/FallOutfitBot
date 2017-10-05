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
		
		String statement = in.nextLine();
		String gender = "";
		
		if(statement.toLowerCase() == "male")
		{
			gender = "male";
		}
		else if(statement.toLowerCase() == "female")
		{
			gender = "female";
		}
		else
		{
			gender = "unisex";
		}

		
		System.out.println("Thank you. Would you like to start with tops, bottoms, shoes, or accessories?");
		statement = in.nextLine();
		
		if(statement.toLowerCase() == "tops")
		{
			ChatBotSarwar chatbot1 = new ChatBotSarwar();
			statement = in.nextLine();
		}
		/*
		if(statement.toLowerCase() == "bottoms")
		{
			ChatBotLamia chatbot2 =  new ChatBotLamia();
			statement = in.nextLine();
		}
		*/
		if(statement.toLowerCase() == "shoes")
		{
			ChatBotKaitlyn chatbot3 = new ChatBotKaitlyn();
			statement = in.nextLine();
		}
		if(statement.toLowerCase() == "accessories")
		{
			System.out.println("HECK");
			ChatBotMonroe chatbot4 = new ChatBotMonroe();
			while(!statement.equals("Bye"))
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
				
			}
			
			
		}

	}

}
