package game;

public class Assassin extends Monster {

	private static final double MIN_DAMAGE_MOD = 0.6;
	private static final double MAX_DAMAGE_MOD = 0.8;
	private static final double MAX_HEALTH_MOD = 0.4;
	
	public Assassin(String name, int difficultyModifier, MonsterRarity rarity)
	{
		super(name, difficultyModifier, MIN_DAMAGE_MOD, MAX_DAMAGE_MOD, MAX_HEALTH_MOD, rarity);
	}
	
	public Assassin(Warrior template)
	{
		super(template);
	}
}
