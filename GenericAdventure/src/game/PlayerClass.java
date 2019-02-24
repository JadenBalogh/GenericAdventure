package game;

import java.io.Serializable;

public class PlayerClass implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static final int MAX_LEVEL = 16;
	
	private String name;
	private String description;
	private ClassType classType;
	private Item item;
	
	private int level = 1;
	private int experience = 0;
	private int totalExperience;
	private int lastTotalExperienceNeeded;
	
	private int minDamage;
	private double actualMinDamage;
	private double minDamageLevelRate;
	
	private int maxDamage;
	private double actualMaxDamage;
	private double maxDamageLevelRate;
	
	private int critChance;
	private double actualCritChance;
	private double critChanceLevelRate;
	
	private int currentHealth;
	private int health;
	private double actualHealth;
	private double healthLevelRate;
	
	private int fleeChance;
	private double actualFleeChance;
	private double fleeChanceLevelRate;
	
	public PlayerClass(String name, String description, ClassType classType, int minDamage, double minDamageLevelRate, 
			int maxDamage, double maxDamageLevelRate, int critChance, double critChanceLevelRate,
			int health, double healthLevelRate, int fleeChance, double fleeChanceLevelRate)
	{
		setName(name);
		setDescription(description);
		setClassType(classType);
		
		setMinDamage(minDamage);
		setActualMinDamage(minDamage);
		setMinDamageLevelRate(minDamageLevelRate);
		
		setMaxDamage(maxDamage);
		setActualMaxDamage(maxDamage);
		setMaxDamageLevelRate(maxDamageLevelRate);
		
		setCritChance(critChance);
		setActualCritChance(critChance);
		setCritChanceLevelRate(critChanceLevelRate);
		
		setCurrentHealth(health);
		setHealth(health);
		setActualHealth(health);
		setHealthLevelRate(healthLevelRate);
		
		setFleeChance(fleeChance);
		setActualFleeChance(fleeChance);
		setFleeChanceLevelRate(fleeChanceLevelRate);
	}
	
	public PlayerClass(PlayerClass template)
	{
		setName(template.name);
		setDescription(template.description);
		setClassType(template.classType);
		
		setMinDamage(template.minDamage);
		setActualMinDamage(template.minDamage);
		setMinDamageLevelRate(template.minDamageLevelRate);
		
		setMaxDamage(template.maxDamage);
		setActualMaxDamage(template.maxDamage);
		setMaxDamageLevelRate(template.maxDamageLevelRate);
		
		setCritChance(template.critChance);
		setActualCritChance(template.critChance);
		setCritChanceLevelRate(template.critChanceLevelRate);
		
		setCurrentHealth(template.health);
		setHealth(template.health);
		setActualHealth(template.health);
		setHealthLevelRate(template.healthLevelRate);
		
		setFleeChance(template.fleeChance);
		setActualFleeChance(template.fleeChance);
		setFleeChanceLevelRate(template.fleeChanceLevelRate);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isMaxLevel() {
		return getLevel() == MAX_LEVEL;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public int getTotalExperience()	{
		return totalExperience;
	}
	
	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	private int getExperienceNeeded() {
		double levelCurve = Math.log10(level);
		
		return (int) Math.round((100 * Math.pow(level, levelCurve)));
	}
	
	public int getTotalExperienceNeeded() {
		return lastTotalExperienceNeeded + getExperienceNeeded();
	}

	public int getLastTotalExperienceNeeded() {
		return lastTotalExperienceNeeded;
	}

	public void setLastTotalExperienceNeeded(int lastTotalExperienceNeeded) {
		this.lastTotalExperienceNeeded = lastTotalExperienceNeeded;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public double getActualMinDamage() {
		return actualMinDamage;
	}

	public void setActualMinDamage(double actualMinDamage) {
		this.actualMinDamage = actualMinDamage;
	}

	public double getMinDamageLevelRate() {
		return minDamageLevelRate;
	}

	public void setMinDamageLevelRate(double minDamageLevelRate) {
		this.minDamageLevelRate = minDamageLevelRate;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public double getActualMaxDamage() {
		return actualMaxDamage;
	}

	public void setActualMaxDamage(double actualMaxDamage) {
		this.actualMaxDamage = actualMaxDamage;
	}

	public double getMaxDamageLevelRate() {
		return maxDamageLevelRate;
	}

	public void setMaxDamageLevelRate(double maxDamageLevelRate) {
		this.maxDamageLevelRate = maxDamageLevelRate;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	public double getActualCritChance() {
		return actualCritChance;
	}

	public void setActualCritChance(double actualCritChance) {
		this.actualCritChance = actualCritChance;
	}

	public double getCritChanceLevelRate() {
		return critChanceLevelRate;
	}

	public void setCritChanceLevelRate(double critChanceLevelRate) {
		this.critChanceLevelRate = critChanceLevelRate;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
		if (this.currentHealth < 0)
			this.currentHealth = 0;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getActualHealth() {
		return actualHealth;
	}

	public void setActualHealth(double actualHealth) {
		this.actualHealth = actualHealth;
	}

	public double getHealthLevelRate() {
		return healthLevelRate;
	}

	public void setHealthLevelRate(double healthLevelRate) {
		this.healthLevelRate = healthLevelRate;
	}

	public int getFleeChance() {
		return fleeChance;
	}

	public void setFleeChance(int fleeChance) {
		this.fleeChance = fleeChance;
	}

	public double getActualFleeChance() {
		return actualFleeChance;
	}

	public void setActualFleeChance(double actualFleeChance) {
		this.actualFleeChance = actualFleeChance;
	}

	public double getFleeChanceLevelRate() {
		return fleeChanceLevelRate;
	}

	public void setFleeChanceLevelRate(double fleeChanceLevelRate) {
		this.fleeChanceLevelRate = fleeChanceLevelRate;
	}

	public void equipItem(Item item)
	{
		if (getName().equals("Mechanic"))
		{
			if (item.getMinDamage() > 0)
				item.setMinDamage(item.getMinDamage() * 2);
			if (item.getMaxDamage() > 0)
				item.setMaxDamage(item.getMaxDamage() * 2);
			if (item.getCritChance() > 0)
				item.setCritChance(item.getCritChance() * 2);
			if (item.getHealth() > 0)
				item.setHealth(item.getHealth() * 2);
			if (item.getFleeChance() > 0)
				item.setFleeChance(item.getFleeChance() * 2);
		}
		
		setItem(item);
	}
	
	public void takeDamage(int damage, Monster monster)
	{
		setCurrentHealth(getCurrentHealth() - damage);
		
		System.out.println("\t|> You took " + damage + " points of damage from " + monster.getName() + "!");
	}
	
	public void restoreHealth()
	{
		setCurrentHealth(getHealth());
	}

	public void addExperience(int experience, boolean isExtra)
	{
		if (!isExtra)
		{
			setTotalExperience(getTotalExperience() + experience);
		}
		
		setExperience(getExperience() + experience);
		
		int experienceNeeded = getExperienceNeeded();
		if (getExperience() >= experienceNeeded)
		{
			if (isMaxLevel())
			{
				Printer.blankLine(1);
				setTotalExperience(getTotalExperienceNeeded());
				System.out.println("Total Experience: " + getTotalExperience() + "/" + getTotalExperience());
				
				return;
			}

			setLastTotalExperienceNeeded(getLastTotalExperienceNeeded() + experienceNeeded);

			levelUp();
			
			int extraExperience = getExperience() - experienceNeeded;
			setExperience(0);
			addExperience(extraExperience, true);
		}
		else
		{
			Printer.blankLine(1);
			System.out.println("Total Experience: " + getTotalExperience() + "/" + getTotalExperienceNeeded());
		}
	}
	
	public void addExperience(int experience)
	{
		addExperience(experience, false);
	}
	
	private void levelUp()
	{
		setLevel(level + 1);
		
		int prevMinDamage = getMinDamage();
		int prevMaxDamage = getMaxDamage();
		int prevCritChance = getCritChance();
		int prevHealth = getHealth();
		int prevFleeChance = getFleeChance();
		
		setActualMinDamage(getActualMinDamage() + getMinDamageLevelRate());
		setActualMaxDamage(getActualMaxDamage() + getMaxDamageLevelRate());
		setActualCritChance(getActualCritChance() + getCritChanceLevelRate());
		setActualHealth(getActualHealth() + getHealthLevelRate());
		setActualFleeChance(getActualFleeChance() + getFleeChanceLevelRate());
		
		setMinDamage((int) getActualMinDamage());
		setMaxDamage((int) getActualMaxDamage());
		setCritChance((int) getActualCritChance());
		setHealth((int) getActualHealth());
		setFleeChance((int) getActualFleeChance());
		
 		restoreHealth();
		
		Printer.blankLine(1);
		String header = "|> " + Printer.getTextLine("!", 31) + " <|";
		System.out.println(header);
		System.out.println(Printer.centerOnLine("You leveled up!", header.length()));
		
		if (getMinDamage() - prevMinDamage > 0) 
			System.out.println("\tYou gained " + (getMinDamage() - prevMinDamage) + " Minimum Damage.");
		if (getMaxDamage() - prevMaxDamage > 0) 
			System.out.println("\tYou gained " + (getMaxDamage() - prevMaxDamage) + " Maximum Damage.");
		if (getCritChance() - prevCritChance > 0) 
			System.out.println("\tYou gained " + (getCritChance() - prevCritChance) + " Critical Chance.");
		if (getHealth() - prevHealth > 0) 
			System.out.println("\tYou gained " + (getHealth() - prevHealth) + " Health.");
		if (getFleeChance() - prevFleeChance > 0) 
			System.out.println("\tYou gained " + (getFleeChance() - prevFleeChance) + " Flee Chance.");
		
		Printer.blankLine(1);
		printCharacterInfo();
		System.out.println(header);
		Printer.blankLine(1);
		
		GenericAdventure.saveGame(PlayerClass.this);
		GenericAdventure.addCheckpoint(PlayerClass.this);
	}

	public void printCharacterInfo()
	{
		System.out.println("\tLevel: " + getLevel() + " " + getName());
		
		if (getItem() != null)
		{
			System.out.println("\tExperience: " + getTotalExperience() + "/" + getTotalExperienceNeeded());
			System.out.println("\tHealth: " + getCurrentHealth() + "/" + getHealth() + "[" + getItem().getHealth() + "]");
			System.out.println("\tDamage: " + getMinDamage() + "[" + getItem().getMinDamage() + "]" + " to " + getMaxDamage() + "[" + getItem().getMaxDamage() + "]");
			System.out.println("\tCritical Hit Chance: " + getCritChance() + "%[" + getItem().getCritChance() + "%]");
			System.out.println("\tChance to flee: " + getFleeChance() + "%[" + getItem().getFleeChance() + "%]");
			Printer.blankLine(1);
			getItem().printItemInfo();
		}
		else
		{
			System.out.println("\tExperience: " + getTotalExperience() + "/" + getTotalExperienceNeeded());
			System.out.println("\tHealth: " + getCurrentHealth() + "/" + getHealth());
			System.out.println("\tDamage: " + getMinDamage() + " to " + getMaxDamage());
			System.out.println("\tCritical Hit Chance: " + getCritChance() + "%");
			System.out.println("\tChance to flee: " + getFleeChance() + "%");
		}
	}
}