import java.util.Random;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;

public class ChatBotMonroe {
	int emotion = 0;
	Scanner in = new Scanner (System.in);
	String accessory = "";
	int beginSearch = 0;
	String[] colorArray = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "black", "gray", "white"};
	String[] accessoryArray = {"glasses", "hats", "scarves", "earrings"};
	
	public String getResponse(String statement)
	{
		String response = "";
			
		/*
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
		*/
		
		if(statement.length() == 0)
		{
			return response = "Did you say something?";
		}
		
		if(findKeyword(statement, "accessories", 0) >= 0)
		{
			return response = "What kind of accessories would you like? We are currently more familiar with glasses, hats, scarves, and earrings.";
		}
		
		for(int x = 0; x < accessoryArray.length; x++)
		{
			if(findKeyword(accessoryArray[x], statement.toLowerCase(), 0) >= 0)
			{
				accessory = accessoryArray[x];
				return response = "You said " + accessory.toLowerCase() + ". " + "What color would you like them in?";
			}
			else
			{
				response = "Sorry, what accessory was that?";
			}
		}
		
		for(int x = 0; x < colorArray.length; x++)
		{
			if(findKeyword(colorArray[x], statement.toLowerCase(), 0) >= 0)
			{
				beginSearch = 1;
				return response = "You would like " + statement + " " + accessory.toLowerCase() + " " + "correct?";			
			}
			else
			{
				response = "Sorry, what color was that?";
			}
		}
		
		if(beginSearch == 1)
		{
			return response = "wee woo";
		}
		
		
		return response;
		
		
	}
	
	
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
