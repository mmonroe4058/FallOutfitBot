import java.util.Random;
public class ChatBotSarwar {
	public String Start()
	{
		return "Okay, let's start with a top. Would you prefer a sweater, t-shirt, or jacket?";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if(findKeyword(statement, "jacket") >= 0)
		{
			response = "Do you need help with finding something to wear underneath that jacket?";
			if(statement.toLowerCase().equals("yes"))
			{
				response = "No problem, I got you!";
			}
			/*else
			{
				response = "Let's look for a jacket then.";
			}*/
		}
		if(findKeyword(statement, "sweater") >= 0)
		{
			response = "What color do you want to see?";
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
	public String getColor(String color)
	{
		if(color.toLowerCase().equals("blue"))
		{
			color = " ";
		}
		return color;
	}
	private String [] femaleSweaterLinks {
		"https://i.pinimg.com/236x/b3/05/56/b305560e4e7594a48228a90d0934bef8--fall-fashion-women-winter-fashion.jpg", 
		" "
		
	};
	private String [] maleSweaterLinks {
	};
	private String [] uniSweaterLinks{
	};
	
	}
}
