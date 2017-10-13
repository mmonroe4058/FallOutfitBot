import java.util.Random;
import java.util.Scanner;
public class ChatBotSarwar {
	public String start()
	{
		return "Okay, let's start with a top. Would you prefer a sweater, t-shirt, or jacket?";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.length() == 0)
		{
			response = "Say something, are you still there?";
		}
		else if(findKeyword(statement, "jacket") >= 0)
		{
			response = "Do you need help with finding something to wear underneath that jacket?";
			Scanner in = new Scanner (System.in);
			statement = in.nextLine();
			jacketHelp(statement);
			/*else
			{
				response = "Let's look for a jacket then.";
			}*/
		}
		else if(findKeyword(statement, "sweater") >= 0)
		{
			response = "Sweaters are cool! What color do you want to see?";
			Scanner in = new Scanner (System.in);
			getColor(statement);
		}
		else if(findKeyword(statement, "t-shirt") >= 0)
		{
			response = "T-shirt it is. What color do you want to see?";
		}
		return response;
		
	}
	private int findKeyword(String statement, String goal,int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);
		
		while (psn >= 0)
		{
			
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

			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) 
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	public String jacketHelp(String statement)
	{
		String response = "";
		Scanner in = new Scanner (System.in);
		statement = in.nextLine();
		if(statement.toLowerCase().equals("yes"))
		{
			response = "No problem, I got you!";
		}
		else
		{
			response = "Alright then.";
		}
		return response;
	}
	public String getColor(String statement)
	{
		String result = "";
		if(findKeyword(statement, "blue") >= 0)
		{
			result += "blue";
		}
		return result;
	}
	String [] colors = { "red", "orange", "yellow", "green", "blue", "purple", "pink", "black", "brown", "gray", "white"};
	
	/*private String [] femaleSweaterLinks {
		"https://i.pinimg.com/236x/b3/05/56/b305560e4e7594a48228a90d0934bef8--fall-fashion-women-winter-fashion.jpg", 
		" "
		
	};
	private String [] maleSweaterLinks {
	};
	private String [] uniSweaterLinks{
	};
	
	}*/
}
