import java.lang.reflect.Array;
import java.util.Random;
public class ChatBotLamia {
	String name = "";
	String type = " ";
	String brand = " ";
	//String publictype = "";
	//String publicbrand = "";
	public String returnname()
	{
		return name;
	}
	public String askname()
	{
		return generateRandomResponse(randomgreetings) + ". This is chatbot Lamia.  What is your name?";
	}
	public String getname(String statement)
	{
		
		name = statement;
		
		return "Nice to meet you " + name;
		
		
	}
	/*public String returnbrand(String statement)
	{
		brand = statement;
		return "You want " + type + " of brand name " + brand;
	}*/
	public String starttalking()
	{
		return  " So what kind of pants are you generally interested in? Examples include jeans, pants, trousers, etc";
	} 
	
	
	public String getresponse(String statement)
	{
		
		String response = " ";
		if(statement.equals(" "))
		{
			response = "please, say something :C\n";
		}
		else
		{
			if((findKeyword(statement,SearchArray(pant_types,statement),0))>=0)
			{
				type = SearchArray(pant_types,statement);
				//type = SearchArray(pant_types,statement);
				String s = "You want " + type + ". Now can you tell me what kind of brand you would like of these types of pants?Examples include Levis, Calvin Klein,etc.\n";
				response = s;
				//returnbrand(statement);
				
			}
		}
				
				
					
				  response = generateRandomResponse(neutralstatements)+"\n";
				
		
		
		
		return response;
	}
	
	private String generateRandomResponse(String[]s)
	{
		Random r = new Random();
		return s [r.nextInt(s.length)];
	}
	private String[] randomgreetings = {"Hey, what is up", "Howdy, how do you do?", "What's shakin","Hola,como estas"};
	private String[] pant_brands = {"Levis","Michael Kors"};
	private String[] pant_types = {"trousers","pants","jeans","skirts"};
	private String[] neutralstatements = {"Hmmm, very interesting", "Tell me more","Wow, I never thought of it like that","Get out of town"};
	
	/*public String getName(String name)
	{
		return "Nice to meet you" + name;
	}*/
	@SuppressWarnings("unused")
	private int findKeywordinArray(String statement,String[]goal)
	{
		int counter = -1;
		String phrase = statement.trim().toLowerCase();
		for(int j = 0;j<phrase.length();j++)
		{
		for(int i = 0;i<goal.length-1;i++)
		{
			if(goal[i].length()<=phrase.length())
			{
			if(phrase.substring(j, j+goal[i].length()-1).equals(goal[i]))
			{
				counter++;
				
			}
			}
		}
		}
		
		// The only change to incorporate the startPos is in
		// the line below
		return counter;
	}
	private String SearchArray(String array[],String keyword)
	{
		keyword = keyword.trim().toLowerCase();
		
		for(int i = 0;i<array.length;i++)
		{
			if(findKeyword(keyword,array[i],0)>=0)
			{
				return array[i];
			}
		}
		return "";
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
