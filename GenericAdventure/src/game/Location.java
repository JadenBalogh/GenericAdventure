package game;

public class Location
{
	public String name;
	public LocationDifficulty difficulty;
	
	public Location(String name, LocationDifficulty difficulty)
	{
		this.name = name;
		this.difficulty = difficulty;
	}
	
	public Location(Location template)
	{
		name = template.name;
		difficulty = template.difficulty;
	}
	
	public double getDifficultyModifier()
	{
		switch (difficulty)
		{
			case EASY: return 0.75;
			case NORMAL: return 1.0;
			case HARD: return 1.25;
			case BOSS: return 1.5;
		}
		
		return 1.0;
	}
}