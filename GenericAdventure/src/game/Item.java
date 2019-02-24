package game;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int MONSTER_FOCUS_MULTIPLIER = 4;
	
	private String name;
	private ClassType classRestriction;
	private int minDamage;
	private int maxDamage;
	private int critChance;
	private int health;
	private int fleeChance;
	private String monsterFocus;
	private ItemValue value;
	
	public Item(String name, ClassType classRestriction, int minDamage, int maxDamage, 
			int critChance, int health, int fleeChance, String monsterFocus, ItemValue value)
	{
		setName(name);
		setClassRestriction(classRestriction);
		setMinDamage(minDamage);
		setMaxDamage(maxDamage);
		setCritChance(critChance);
		setHealth(health);
		setFleeChance(fleeChance);
		setMonsterFocus(monsterFocus);
		setValue(value);
	}
	
	public Item(Item template)
	{
		setName(template.name);
		setClassRestriction(template.classRestriction);
		setMinDamage(template.minDamage);
		setMaxDamage(template.maxDamage);
		setCritChance(template.critChance);
		setHealth(template.health);
		setFleeChance(template.fleeChance);
		setMonsterFocus(template.monsterFocus);
		setValue(template.value);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassType getClassRestriction() {
		return classRestriction;
	}

	public void setClassRestriction(ClassType classRestriction) {
		this.classRestriction = classRestriction;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getFleeChance() {
		return fleeChance;
	}

	public void setFleeChance(int fleeChance) {
		this.fleeChance = fleeChance;
	}

	public String getMonsterFocus() {
		return monsterFocus;
	}

	public void setMonsterFocus(String monsterFocus) {
		this.monsterFocus = monsterFocus;
	}

	public ItemValue getValue() {
		return value;
	}

	public void setValue(ItemValue value) {
		this.value = value;
	}
	
	public int getMonsterFocusMultiplier() {
		return MONSTER_FOCUS_MULTIPLIER;
	}

	public boolean isRestricted(ClassType classType)
	{
		switch (classType)
		{
			case MELEE : 
				if (getClassRestriction() == ClassType.MELEE || getClassRestriction() == ClassType.ANY) 
					return false; 
				else 
					return true;
			case RANGED : 
				if (getClassRestriction() == ClassType.RANGED || getClassRestriction() == ClassType.ANY) 
					return false; 
				else 
					return true;
			case CASTER : 
				if (getClassRestriction() == ClassType.CASTER || getClassRestriction() == ClassType.ANY) 
					return false; 
				else 
					return true;
			case SPECIALIST : 
				return false;
			default: 
				return true;
		}
	}
	
	public void printItemInfo()
	{
		String result = "\t";
		result += getName() + " ";
		result += "[Class: " + Printer.toSentenceCase(getClassRestriction().toString()) + "] (";
		result += getMinDamage() != 0 ? "Minimum Damage [" + getMinDamage() + "]" : "";
		result += (getMinDamage() != 0 && getMaxDamage() != 0) ? ", " : "";
		result += getMaxDamage() != 0 ? "Maximum Damage [" + getMaxDamage() + "]" : "";
		result += ((getMaxDamage() != 0 || getMinDamage() != 0) && getCritChance() != 0) ? ", " : "";
		result += getCritChance() != 0 ? "Critical Chance [" + getCritChance() + "]" : "";
		result += ((getCritChance() != 0 || getMaxDamage() != 0 || getMinDamage() != 0) && getHealth() != 0) ? ", " : "";
		result += getHealth() != 0 ? "Health [" + getHealth() + "]" : "";
		result += ((getHealth() != 0 || getCritChance() != 0 || getMaxDamage() != 0 || getMinDamage() != 0) && getFleeChance() != 0) ? ", " : "";
		result += getFleeChance() != 0 ? "Flee Chance [" + getFleeChance() + "%]" : "";
		result += ((getFleeChance() != 0 || getHealth() != 0 || getCritChance() != 0 || getMaxDamage() != 0 || getMinDamage() != 0) && getMonsterFocus() != null) ? ", " : "";
		result += getMonsterFocus() != null ? "" + getMonsterFocusMultiplier() + "x power against " + Printer.toSentenceCase(getMonsterFocus()) + " types" : "";
		result += ")";
		System.out.println(result);
	}
}
