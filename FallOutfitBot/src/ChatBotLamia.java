import java.util.Random;
public class ChatBotLamia {
	
	public String starttalking()
	{
		return generateRandomResponse(randomgreetings) + "So what kind of pants are you generally interested in?";
	} 
	
	public String getresponse(String statement)
	{
		starttalking();
		String response = " ";
		String type = "";
		if((findKeyword(statement,generateRandomResponse(pant_types),0))>=0)
		{
			response = "You want " + type + ". Now can you tell me what kind of brands you would like of these types of pants?";
			
		}
		else
			{
				response = generateRandomResponse(neutralstatements);
			}
		
		
		return response;
	}
	private String generateRandomResponse(String[]s)
	{
		Random r = new Random();
		return s [r.nextInt(s.length)];
	}
	private String[] randomgreetings = {"Hey, what is up", "Howdy, how do you do?", "What's shakin","Hola,como estas"};
	private String[] pant_brands = {"Levis","Michael Kors"};
	private String[] pant_types = {"pants"};
	private String[] neutralstatements = {"Hmmm, very interesting", "Tell me more","Wow, I never thought of it like that","Get out of town"};
	
	/*public String getName(String name)
	{
		return "Nice to meet you" + name;
	}*/
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
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	/*private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}*/
	
}
