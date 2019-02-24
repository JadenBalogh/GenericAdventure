package game;

public class Monster
{
	protected static final int MIN_DAMAGE_BASE = 1;
	protected static final int MAX_DAMAGE_BASE = 1;
	protected static final int MAX_HEALTH_BASE = 8;
	protected static final double MIN_DAMAGE_MOD_VALUE = 1;
	protected static final double MAX_DAMAGE_MOD_VALUE = 1.5;
	protected static final double MAX_HEALTH_MOD_VALUE = 4;
	
	private String name;

	private int difficultyModifier;
	private MonsterRarity rarity;
	
	private int minDamage;
	private double minDamageMod;
	
	private int maxDamage;
	private double maxDamageMod;

	private int currentHealth;
	private int maxHealth;
	private double maxHealthMod;
	
	public Monster(String name, int difficultyModifier, double minDamageMod, double maxDamageMod, double maxHealthMod, MonsterRarity rarity)
	{
		setName(name);
		setRarity(rarity);
		setDifficultyModifier(difficultyModifier);
		setMinDamageMod(minDamageMod);
		setMaxDamageMod(maxDamageMod);
		setMaxHealthMod(maxHealthMod);
		initialize(minDamageMod, maxDamageMod, maxHealthMod);
	}
	
	public Monster(Monster template)
	{
		setName(template.name);
		setRarity(template.rarity);
		setDifficultyModifier(template.difficultyModifier);
		setMinDamageMod(template.minDamageMod);
		setMaxDamageMod(template.maxDamageMod);
		setMaxHealthMod(template.maxHealthMod);
		initialize(template.minDamageMod, template.maxDamageMod, template.maxHealthMod);
	}
	
	private void initialize(double minDamageMod, double maxDamageMod, double maxHealthMod)
	{
		int diff = getDifficultyModifier();
		setMinDamage(MIN_DAMAGE_BASE+(int)(diff*minDamageMod*MIN_DAMAGE_MOD_VALUE));
		setMaxDamage(MAX_DAMAGE_BASE+(int)(diff*maxDamageMod*MAX_DAMAGE_MOD_VALUE));
		setMaxHealth(MAX_HEALTH_BASE+(int)(diff*maxHealthMod*MAX_HEALTH_MOD_VALUE));
		setCurrentHealth(getMaxHealth());
		
		/*System.out.println("Name: " + name);
		System.out.println("MinDam: " + minDamage);
		System.out.println("MaxDam: " + maxDamage);
		System.out.println("MaxHP: " + maxHealth);
		System.out.println("DM: " + difficultyModifier);
		System.out.println("MinDamMod: " + minDamageMod);
		System.out.println("MaxDamMod: " + maxDamageMod);
		System.out.println("MaxHPMod: " + maxHealthMod);
		Printer.blankLine(1);*/
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}
	
	public double getMinDamageMod() {
		return minDamageMod;
	}
	
	public void setMinDamageMod(double minDamageMod) {
		this.minDamageMod = minDamageMod;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
	
	public double getMaxDamageMod() {
		return maxDamageMod;
	}
	
	public void setMaxDamageMod(double maxDamageMod) {
		this.maxDamageMod = maxDamageMod;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public double getMaxHealthMod() {
		return maxHealthMod;
	}
	
	public void setMaxHealthMod(double maxHealthMod) {
		this.maxHealthMod = maxHealthMod;
	}

	public MonsterRarity getRarity() {
		return rarity;
	}

	public void setRarity(MonsterRarity rarity) {
		this.rarity = rarity;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getDifficultyModifier() {
		return difficultyModifier;
	}
	
	public void setDifficultyModifier(int difficultyModifier) {
		this.difficultyModifier = difficultyModifier;
	}
	
	public String getRelativeDifficulty(PlayerClass player)
	{
		int diff = getDifficultyModifier();
		int level = (player.getLevel() >= 3) ? player.getLevel() : 3;
		
		if (diff > level + 12)
			return "Impossible";
		if (diff > level + 9)
			return "Extremely Hard";
		if (diff > level + 6)
			return "Very Hard";
		if (diff > level + 4)
			return "Hard";
		if (diff > level + 2)
			return "Normal";
		if (diff > level)
			return "Easy";
		else
			return "Trivial";
	}

	public void scaleStats(double scale)
	{
		setDifficultyModifier((int)(getDifficultyModifier()*scale));
		initialize(minDamageMod, maxDamageMod, maxHealthMod);
	}
	
	public void takeDamage(int damage)
	{
		setCurrentHealth(currentHealth-damage);
	}
	
	public MonsterItemLevel getItemLevel()
	{
		if (difficultyModifier <= 6)
		{
			return MonsterItemLevel.EASY;
		}
		else if (difficultyModifier <= 12)
		{
			return MonsterItemLevel.NORMAL;
		}
		else if (difficultyModifier <= 18)
		{
			return MonsterItemLevel.HARD;
		}
		else if (difficultyModifier <= 24)
		{
			return MonsterItemLevel.BOSS;
		}
		else
		{
			return MonsterItemLevel.MEGABOSS;
		}
	}
}