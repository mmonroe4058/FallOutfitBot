import java.util.Scanner;
import java.util.Random;

//import java.util.Random;
/*Title: ChatBot that helps indecisive users pick out shoes
 * Author: Kaitlyn Cao
 * Date: 10/10/17
 * */
public class ChatBotKaitlyn {
	
	int feelings = 0;
	private Scanner input;
	public String greetUser()
	{
		//Random r = new Random();
		//return randomGreetings[r.nextInt(randomGreetings.length)];
		System.out.println("Hey! I'm Kiki! What's your name?");
		input = new Scanner(System.in);
		String name = input.next();
		
		return "Need help picking some shoes, "+ name + "?";
	}  
	
	//private String [] randomGreetings = {"Hi", "How may I help you?", "Need help picking some shoes?"};
	
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.length() == 0)
		{
			response = "I'd love to help you. Talk to me...please?";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = ":(";
			feelings--;
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Great! What's the agenda today? Are you working out, going to work, attending an event, or just hanging with friends?";
			//feelings++;
		}
		return response;
	}

	public String determineEventType(String statement)
	{
		String response = "";
		statement = statement.trim();
		if(findKeyword(statement, "working out") >= 0)
		{
			response =  "You should wear sneakers";
		}
		if(findKeyword(statement, "event") >= 0)
		{
			response =  "You could wear either heels or flats. Which do you prefer?";
		}
		if(findKeyword(statement, "work") >= 0)
		{
			response =  "Does your work involve a lot of running around?";
		}
		if(findKeyword(statement, "friends") >= 0)
		{
			response =  "Are you going out or staying in?";
		}
		return response;
		
	}
/*	private String getRandomResponse()
	{
		Random r = new Random();
		if(feelings == 0)
		{
			return randomNeutralResponses[r.nextInt(randomNeutralResponses.length)];
		}
	}
	private String [] randomNeutralResponses = {"hmm...", "Could you repeat that?", "I like trains."};
*/
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
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
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


}
