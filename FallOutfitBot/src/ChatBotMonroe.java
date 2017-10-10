import java.util.Random;
import java.util.Scanner;

public class ChatBotMonroe {
	int emotion = 0;
	Scanner in = new Scanner (System.in);
	String accessory = "";
	
	
	public String getResponse(String statement)
	{
		String response = "";
		
		

		
		/*if(x == 7); 
		{
			response = "What kind of accessories are you looking for? Glasses, hats, scarves, earrings, necklaces?";
		}*/
		
		if(findKeyword(statement, "glasses", 0) >= 0)
		{
			accessory = "glasses";
			response = "You said glasses. What color would you like them in?";
		}
		else if(findKeyword(statement, "hats", 0) >= 0)
		{
			accessory = "hats";
			response = "You said hats. What color would you like them in?";
		}
		else if(findKeyword(statement, "scarves", 0) >= 0)
		{
			accessory = "scarves";
			response = "You said scarves. What color would you like them in?";
		}
		else if(findKeyword(statement, "earrings", 0) >= 0)
		{
			accessory = "earrings";
			response = "You said earrings. What color would you like them in?";
		}
		else
		{
			response = "Sorry, what accessory was that?";
		}
		
		
		if(findKeyword(statement, "green", 0) >= 0)
		{
			if(accessory == "glasses")
			{
				response = "You would like" + "green" + accessory + "correct?";
			}
			else if(accessory.toLowerCase().equals("hats"))
			{
				response = "You would like" + "green" + accessory + "correct?";
			}
			else if(accessory.toLowerCase().equals("scarves"))
			{
				response = "You would like" + "green" + accessory + "correct?";
			}
			else if(accessory.toLowerCase().equals("earrings"))
			{
				response = "You would like" + "green" + accessory + "correct?";
			}
			else
			{
				response = "Sorry, what color was that?";
			}
				
			
		}
		
		if(statement.length() == 0)
		{
			response = "Did you say something?";
		}
		
		return response;
		
	}
	
	/*private String getAccessory(String accessory, String color)
	{
		if(accessory == "glasses")
		{
			
			if(color == "red")
			{
				return accessory + color + "?";
			}
			
			if(color == "green")
			{
				return accessory + color + "?";
			}
			
			if(color == "blue")
			{
				return accessory + color + "?";
			}
			
			if(color == "yellow")
			{
				return accessory + color + "?";
			}
			
			if(color == "purple")
			{
				return accessory + color + "?";
			}
			
			if(color == "pink")
			{
				return accessory + color + "?";
			}
		}
		
		if(accessory == "earrings")
		{
			if(color == "red")
			{
				return accessory + color + "?";
			}
			
			if(color == "green")
			{
				return accessory + color + "?";
			}
			
			if(color == "blue")
			{
				return accessory + color + "?";
			}
			
			if(color == "yellow")
			{
				return accessory + color + "?";
			}
			
			if(color == "purple")
			{
				return accessory + color + "?";
			}
			
			if(color == "pink")
			{
				return accessory + color + "?";
			}
		}
		
		if(accessory == "necklaces")
		{
			if(color == "green")
			{
				return color;
			}
		}
		
		if(accessory == "hats")
		{
			if(color == "green")
			{
				return color;
			}
		}
		
		if(accessory == "scarves")
		{
			if(color == "green")
			{
				return color;
			}
		}
		return color;
	} */
	
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
}
