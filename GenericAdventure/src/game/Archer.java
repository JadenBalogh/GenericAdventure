package game;

public class Archer extends Monster {

	private static final double MIN_DAMAGE_MOD = 0.2;
	private static final double MAX_DAMAGE_MOD = 0.8;
	private static final double MAX_HEALTH_MOD = 0.6;
	
	public Archer(String name, int difficultyModifier, MonsterRarity rarity)
	{
		super(name, difficultyModifier, MIN_DAMAGE_MOD, MAX_DAMAGE_MOD, MAX_HEALTH_MOD, rarity);
	}
	
	public Archer(Warrior template)
	{
		super(template);
	}
}
