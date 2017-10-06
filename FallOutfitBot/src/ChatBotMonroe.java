import java.util.Random;
import java.util.Scanner;

public class ChatBotMonroe {
	int emotion = 0;
	Scanner in = new Scanner (System.in);
	
	public String beginChat()
	{
		return "What kind of accessories are you looking for? Glasses, hats, scarves, earrings?";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		String accessory = "";
		String x = "";
		
		beginChat();
		
		if(findKeyword(statement, "glasses", 0) >= 0)
		{
			accessory = "glasses";
			response = "You said glasses. What color would you like them in?";
			x = in.nextLine();
			getAccessory("glasses", x);
		}
		
		return response;
	}
	
	public String getAccessory(String accessory, String color)
	{
		if(accessory == "glasses")
		{
			if(color == "green")
			{
				String y = "http://www.zennioptical.com/blog/wp-content/uploads/2013/01/608324.png";
				return y;
			}
		}
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
