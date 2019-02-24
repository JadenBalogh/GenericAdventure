package game;

public class Wizard extends Monster {

	private static final double MIN_DAMAGE_MOD = 0.1;
	private static final double MAX_DAMAGE_MOD = 1.2;
	private static final double MAX_HEALTH_MOD = 0.3;
	
	public Wizard(String name, int difficultyModifier, MonsterRarity rarity)
	{
		super(name, difficultyModifier, MIN_DAMAGE_MOD, MAX_DAMAGE_MOD, MAX_HEALTH_MOD, rarity);
	}
	
	public Wizard(Warrior template)
	{
		super(template);
	}
}
