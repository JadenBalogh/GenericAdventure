package game;

public class Tank extends Monster {
	
	private static final double MIN_DAMAGE_MOD = 0.1;
	private static final double MAX_DAMAGE_MOD = 0.4;
	private static final double MAX_HEALTH_MOD = 1.2;
	
	public Tank(String name, int difficultyModifier, MonsterRarity rarity)
	{
		super(name, difficultyModifier, MIN_DAMAGE_MOD, MAX_DAMAGE_MOD, MAX_HEALTH_MOD, rarity);
	}
	
	public Tank(Tank template)
	{
		super(template);
	}
}
