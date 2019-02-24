package game;

public class Printer {
	
	public static final String VOWELS = "aeiou";
	
	public static String getTextLine(String textBlock, int repeats)
	{
		String result = "";
		
		for (int i = 0; i < repeats; i++)
		{
			result += textBlock;
		}
		
		return result;
	}
	
	public static String centerOnLine(String text, int lineLength)
	{
		String result = "";
		int spacing = (lineLength - text.length())/2;
		result += getTextLine(" ", spacing);
		result += text;		
		
		return result;
	}
	
	public static void blankLine(int lines)
	{
		for (int i = 0; i < lines; i++)
		{
			System.out.println();
		}
	}
	
	public static String getDeterminer(String name)
	{
		if (VOWELS.indexOf(name.toLowerCase().charAt(0)) != -1) 
		{
			return "an";
		}
		
		return "a";
	}
	
	public static String toSentenceCase(String word)
	{
		String result = "";
		
		result += word.charAt(0);
		result = result.toUpperCase();
		result += word.toLowerCase().substring(1);
		
		return result;
	}
}
