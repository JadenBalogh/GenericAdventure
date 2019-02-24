package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GenericAdventure {
	
	/*new PlayerClass(Name, 
	 		Description,
			ClassType, 
			MinDamage, MinDamageLevelRate, 
			MaxDamage, MaxDamageLevelRate, 
			CritChance, CritChanceLevelRate, 
			Health, HealthLevelRate, 
			FleeChance, FleeChanceLevelRate)
	*/
	public static PlayerClass[] playerClasses = {
		new PlayerClass("Knight", 
				"A well-rounded melee class without any particular weaknesses.", 
				ClassType.MELEE, 
				3, 0.5, 
				6, 0.75, 
				5, 0,
				24, 6, 
				40, 0),
		new PlayerClass("Brute", 
				"A hard-to-kill melee class with lower damage.", 
				ClassType.MELEE, 
				2, 0.25, 
				4, 0.5, 
				5, 0,
				40, 10, 
				35, 0),
		new PlayerClass("Barbarian", 
				"A heavy-hitting melee who struggles to leave a fight.", 
				ClassType.MELEE, 
				4, 0.75,
				10, 1.25, 
				5, 0,
				20, 4, 
				10, 0),
		new PlayerClass("Ninja",
				"A melee class with exceptional skill for exploiting enemy weaknesses.",
				ClassType.MELEE,
				3, 0.5,
				6, 1,
				20, 2,
				16, 2,
				60, 0),
		new PlayerClass("Sharpshooter", 
				"A ranged class which always hits for maximum damage.", 
				ClassType.RANGED, 
				6, 0.6, 
				6, 0.6, 
				0, 0, 
				18, 3, 
				40, 0),
		new PlayerClass("Wizard", 
				"A low-health caster class with very random damage.", 
				ClassType.CASTER, 
				1, 0, 
				12, 3, 
				10, 0,
				14, 1.25, 
				50, 0),
		new PlayerClass("Illusionist",
				"A deceptive caster who almost always escapes a fight.",
				ClassType.CASTER,
				3, 0.25,
				5, 0.5,
				5, 0, 
				14, 2,
				90, 0.5),
		new PlayerClass("Scrapper", 
				"A specialist class which starts off weak, but grows power much faster than other classes.", 
				ClassType.SPECIALIST, 
				2, 1.5, 
				5, 2.5, 
				5, 0, 
				16, 2, 
				70, 0),
		new PlayerClass("Mechanic", 
				"A specialist class which gains double benefit from items.", 
				ClassType.SPECIALIST, 
				3, 0.25, 
				6, 0.5, 
				5, 0, 
				18, 3, 
				40, 0),
//		new PlayerClass("Fading Spirit", 
//				"A specialist class which starts out very powerful and loses power every level.", 
//				ClassType.SPECIALIST, 
//				18, -1, 
//				26, -1.5, 
//				5, 0, 
//				90, -5, 
//				0, 6)
//		new PlayerClass("TestBoi", "YEET", ClassType.SPECIALIST, 100, 50, 200, 100, 1000, 100, 100, 0)
	};
	
	//new Monster(Name, MinDamage, MaxDamage, Health, MonsterRarity) 
	//Difficulty Rating (Trivial 1-4) | (Easy 5-6) | (Normal 7-8) | (Hard 9-12) | (Very Hard 13-20) | (Extreme 21-30) | (Impossible 31+)
	public static Monster[] monsters = {
		new Warrior("Common Rabble", 4, MonsterRarity.COMMON),
		new Archer("Goblin Scout", 4, MonsterRarity.COMMON),
		new Warrior("Kobold", 4, MonsterRarity.COMMON),
		new Warrior("Coyote", 5, MonsterRarity.COMMON),
		new Archer("Goblin Slinger", 5, MonsterRarity.COMMON),
		new Assassin("Goblin Thief", 5, MonsterRarity.COMMON),
		new Warrior("Wolf", 5, MonsterRarity.COMMON), 
		new Wizard("Unskilled Mage", 5, MonsterRarity.COMMON), 
		new Warrior("Goblin Warrior", 6, MonsterRarity.COMMON),
		new Warrior("Skeletal Minion", 6, MonsterRarity.COMMON),
		new Tank("Zombie Minion", 6, MonsterRarity.COMMON),
		new Archer("Bandit Archer", 7, MonsterRarity.COMMON),
		new Wizard("Bandit Spellcaster", 7, MonsterRarity.COMMON),
		new Warrior("Zombie Swordsman", 7, MonsterRarity.COMMON),
		new Wizard("Zombie Wizard", 7, MonsterRarity.COMMON),
		new Warrior("Skeletal Blade", 8, MonsterRarity.COMMON),
		new Assassin("Bandit Rogue", 8, MonsterRarity.COMMON), 
		new Warrior("Bandit Warrior", 8, MonsterRarity.COMMON),
		new Tank("Skeletal Shieldbearer", 9, MonsterRarity.COMMON),
		new Tank("Zombie Brute", 9, MonsterRarity.COMMON),
		new Wizard("Skeletal Mage", 10, MonsterRarity.COMMON),
		
		new Warrior("Spider", 2, MonsterRarity.UNCOMMON),
		new Warrior("Bat", 3, MonsterRarity.UNCOMMON), 
		new Warrior("Rat", 3, MonsterRarity.UNCOMMON),
		new Assassin("Snake", 4, MonsterRarity.UNCOMMON),
		new Warrior("Fox", 4, MonsterRarity.UNCOMMON), 
		new Warrior("Swarm of Bees", 4, MonsterRarity.UNCOMMON),
		new Warrior("Giant Rat", 5, MonsterRarity.UNCOMMON), 
		new Warrior("Giant Spider", 6, MonsterRarity.UNCOMMON),
		new Warrior("Animated Club", 6, MonsterRarity.UNCOMMON),
		new Wizard("Average Mage", 7, MonsterRarity.UNCOMMON),
		new Warrior("Lion", 7, MonsterRarity.UNCOMMON), 
		new Archer("Elven Shadowstalker", 7, MonsterRarity.UNCOMMON),
		new Warrior("Ghoul", 8, MonsterRarity.UNCOMMON),
		new Warrior("Goblin Leader", 8, MonsterRarity.UNCOMMON), 
		new Tank("Dark Necromancer", 8, MonsterRarity.UNCOMMON),
		new Archer("Gnoll Scout", 8, MonsterRarity.UNCOMMON),
		new Warrior("Dark Conjurer", 10, MonsterRarity.UNCOMMON),
		new Monster("Elite Crossbowman", 10, 0.6, 0.4, 0.6, MonsterRarity.UNCOMMON),
		new Warrior("Gnoll Warrior", 10, MonsterRarity.UNCOMMON),
		new Archer("Gnoll Archer", 10, MonsterRarity.UNCOMMON),
		new Wizard("Elven Enchanter", 10, MonsterRarity.UNCOMMON),
		new Archer("Elven Archer", 11, MonsterRarity.UNCOMMON),
		new Warrior("Elven Swordmaster", 11, MonsterRarity.UNCOMMON),
		new Wizard("Elite Spellslinger", 11, MonsterRarity.UNCOMMON),
		new Warrior("Elite Soldier", 11, MonsterRarity.UNCOMMON),
		new Warrior("Troll", 12, MonsterRarity.UNCOMMON),
		new Wizard("Dark Evoker", 12, MonsterRarity.UNCOMMON), 
		new Warrior("Monstrous Crab", 12, MonsterRarity.UNCOMMON),
		new Wizard("Elven Druid", 13, MonsterRarity.UNCOMMON),
		new Warrior("Gnoll Berserker", 13, MonsterRarity.UNCOMMON),

		new Warrior("Hawk", 4, MonsterRarity.RARE),
		new Assassin("Fire Rat", 6, MonsterRarity.RARE),
		new Warrior("Oozing Slime", 7, MonsterRarity.RARE), 
		new Warrior("Bear", 9, MonsterRarity.RARE),
		new Tank("Animated Shield", 9, MonsterRarity.RARE),
		new Wizard("Adept Mage", 10, MonsterRarity.RARE),
		new Warrior("Death Knight", 10, MonsterRarity.RARE),
		new Archer("Fire Spirit", 10, MonsterRarity.RARE), 
		new Archer("Ice Spirit", 10, MonsterRarity.RARE), 
		new Archer("Rock Spirit", 10, MonsterRarity.RARE), 
		new Archer("Storm Spirit", 10, MonsterRarity.RARE), 
		new Tank("Ogre", 11, MonsterRarity.RARE),
		new Warrior("Animated Sword", 11, MonsterRarity.RARE),
		new Archer("Animated Bow", 11, MonsterRarity.RARE),
		new Warrior("Gnoll Tactician", 12, MonsterRarity.RARE), 
		new Warrior("Bandit Chief", 13, MonsterRarity.RARE),
		new Warrior("Cave Troll", 13, MonsterRarity.RARE), 
		new Assassin("Elite Assassin", 13, MonsterRarity.RARE),
		new Tank("Elite Guardian", 13, MonsterRarity.RARE), 
		new Warrior("Giant Skeleton", 14, MonsterRarity.RARE),
		new Warrior("Elite Warlord", 14, MonsterRarity.RARE),
		new Wizard("Animated Spellbook", 15, MonsterRarity.RARE),
		new Archer("Fire Drake", 16, MonsterRarity.RARE),
		new Warrior("Hill Giant", 16, MonsterRarity.RARE), 
		new Warrior("Griffin", 17, MonsterRarity.RARE),
		new Tank("Shieldback Turtle", 17, MonsterRarity.RARE),
		new Wizard("Giant Seer", 18, MonsterRarity.RARE),

		new Warrior("Gushing Ooze", 12, MonsterRarity.BOSS), 
		new Archer("Goblin-Slinger", 13, MonsterRarity.BOSS),
		new Warrior("Gnoll Spear-Chief", 16, MonsterRarity.BOSS),
		new Warrior("Young Dragon", 16, MonsterRarity.BOSS), 
		new Warrior("Acid-Spewing Slime", 17, MonsterRarity.BOSS),
		new Wizard("Master Mage", 18, MonsterRarity.BOSS), 
		new Warrior("Elite Vanquisher", 19, MonsterRarity.BOSS), 
		new Warrior("Fire Giant", 22, MonsterRarity.BOSS), 
		new Tank("Rock Giant", 23, MonsterRarity.BOSS),  
		new Assassin("Black Dragon", 24, MonsterRarity.BOSS),
		new Archer("Blue Dragon", 24, MonsterRarity.BOSS), 
		new Warrior("Red Dragon", 24, MonsterRarity.BOSS), 
		new Tank("White Dragon", 24, MonsterRarity.BOSS),
		new Warrior("Cyclops", 25, MonsterRarity.BOSS),
		
		new Wizard("Archmagi", 24, MonsterRarity.MEGABOSS),
		new Warrior("Kraken", 25, MonsterRarity.MEGABOSS),
		new Warrior("Hydra", 27, MonsterRarity.MEGABOSS), 
		new Warrior("Storm Titan", 28, MonsterRarity.MEGABOSS),
		new Assassin("Ancient Black Dragon", 30, MonsterRarity.MEGABOSS), 
		new Archer("Ancient Blue Dragon", 30, MonsterRarity.MEGABOSS),
		new Warrior("Ancient Red Dragon", 30, MonsterRarity.MEGABOSS),
		new Tank("Ancient White Dragon", 30, MonsterRarity.MEGABOSS)
	};
	
	//new Item(Name, ClassRestriction, MinDamage, MaxDamage, CritChance, Health, FleeChance, MonsterFocus, ItemValue)
	public static Item[] items = {
		new Item("Broken Sword", ClassType.MELEE, -1, 1, 0, 0, 0, null, ItemValue.VERY_LOW),
		new Item("Rusty Sword", ClassType.MELEE, -1, 2, 0, 0, 0, null, ItemValue.LOW),
		new Item("Standard Sword", ClassType.MELEE, 0, 2, 0, 0, 0, null, ItemValue.MODERATE),
		new Item("Exquisite Sword", ClassType.MELEE, 0, 3, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Enchanted Sword", ClassType.MELEE, 1, 4, 0, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Epic Sword", ClassType.MELEE, 2, 6, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Hammer of Crushing Weight", ClassType.MELEE, 3, 3, 0, 0, -5, null, ItemValue.HIGH),
		new Item("Soul Dagger", ClassType.MELEE, 0, 10, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Light Shield", ClassType.MELEE, 0, 0, 0, 6, 0, null, ItemValue.MODERATE),
		new Item("Heavy Shield", ClassType.MELEE, 0, 0, 0, 10, 0, null, ItemValue.HIGH),
		new Item("Tower Shield", ClassType.MELEE, 0, 0, 0, 16, -5, null, ItemValue.VERY_HIGH),
		new Item("Spiked Shield", ClassType.MELEE, 1, 2, 0, 4, 0, null, ItemValue.HIGH),
		new Item("Fortress Shield", ClassType.MELEE, 0, 0, 0, 24, -10, null, ItemValue.EPIC),
		new Item("Lightning Spear", ClassType.MELEE, 3, 3, 0, 0, 5, "water", ItemValue.VERY_HIGH),
		new Item("Green Blade", ClassType.MELEE, 1, 1, 0, 0, 0, "goblin", ItemValue.LOW),
		
		new Item("Broken Staff", ClassType.CASTER, -1, 1, 0, 0, 0, null, ItemValue.VERY_LOW),
		new Item("Moldy Staff", ClassType.CASTER, -1, 2, 0, 0, 0, null, ItemValue.LOW),
		new Item("Standard Staff", ClassType.CASTER, 0, 2, 0, 0, 0, null, ItemValue.MODERATE),
		new Item("Exquisite Staff", ClassType.CASTER, 0, 3, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Enchanted Staff", ClassType.CASTER, 1, 4, 0, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Epic Staff", ClassType.CASTER, 2, 6, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Necromantic Staff", ClassType.CASTER, 1, 1, 0, 6, 0, null, ItemValue.HIGH),
		new Item("Wand of Sparks", ClassType.CASTER, 1, 1, 0, 0, 0, null, ItemValue.LOW),
		new Item("Wand of Light", ClassType.CASTER, 1, 2, 0, 0, 0, null, ItemValue.MODERATE),
		new Item("Wand of Fireball", ClassType.CASTER, 2, 3, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Wand of Lightning", ClassType.CASTER, 2, 4, 0, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Wand of Destruction", ClassType.CASTER, 0, 10, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Talisman of Ice", ClassType.CASTER, 1, 2, 0, 0, 0, "fire", ItemValue.HIGH),
		new Item("Talisman of Fire", ClassType.CASTER, 1, 2, 0, 0, 0, "ice", ItemValue.HIGH),
		new Item("Staff of Restoration", ClassType.CASTER, 0, 1, 0, 8, 0, null, ItemValue.HIGH),
		new Item("Rod of Perfection", ClassType.CASTER, 100, 0, 0, 0, 0, null, ItemValue.EPIC),
		
		new Item("Broken Bow", ClassType.RANGED, -1, 1, 0, 0, 0, null, ItemValue.VERY_LOW),
		new Item("Rotten Bow", ClassType.RANGED, -1, 2, 0, 0, 0, null, ItemValue.LOW),
		new Item("Standard Bow", ClassType.RANGED, 0, 2, 0, 0, 0, null, ItemValue.MODERATE),
		new Item("Exquisite Bow", ClassType.RANGED, 0, 3, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Enchanted Bow", ClassType.RANGED, 1, 4, 0, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Epic Bow", ClassType.RANGED, 2, 6, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Scout's Shortbow", ClassType.RANGED, 1, 0, 0, 0, 5, null, ItemValue.MODERATE),
		new Item("Light Crossbow", ClassType.RANGED, 2, 2, 0, 0, -5, null, ItemValue.MODERATE), 
		new Item("Heavy Crossbow", ClassType.RANGED, 1, 3, 0, 0, -5, null, ItemValue.MODERATE),
		new Item("Repeating Light Crossbow", ClassType.RANGED, 2, 4, 0, 0, -5, null, ItemValue.VERY_HIGH),
		new Item("Repeating Heavy Crossbow", ClassType.RANGED, 1, 5, 0, 0, -5, null, ItemValue.VERY_HIGH),
		
		new Item("Shock Stick", ClassType.SPECIALIST, 0, 2, 0, 0, 0, null, ItemValue.LOW),
		new Item("Scrap Launcher", ClassType.SPECIALIST, 0, 3, 0, 0, 0, null, ItemValue.MODERATE),
		new Item("Hand Cannon", ClassType.SPECIALIST, 0, 4, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Shock Bolter", ClassType.SPECIALIST, 0, 6, 0, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Plasma Launcher", ClassType.SPECIALIST, 4, 6, 0, 0, 0, null, ItemValue.EPIC),
		new Item("Lousy Toolkit", ClassType.SPECIALIST, 0, 1, 0, 4, 0, null, ItemValue.LOW),
		new Item("Average Toolkit", ClassType.SPECIALIST, 1, 1, 0, 4, 0, null, ItemValue.MODERATE),
		new Item("Refined Toolkit", ClassType.SPECIALIST, 1, 1, 0, 6, 5, null, ItemValue.HIGH),
		new Item("Enchanted Toolkit", ClassType.SPECIALIST, 2, 2, 0, 6, 5, null, ItemValue.VERY_HIGH),
		new Item("Infinite Toolkit", ClassType.SPECIALIST, 3, 3, 0, 8, 10, null, ItemValue.EPIC),
		
		new Item("Stone of Frailty", ClassType.ANY, 0, 1, 0, -2, 0, null, ItemValue.VERY_LOW),
		new Item("Gem of Good Luck", ClassType.ANY, 0, 0, 3, 0, 0, null, ItemValue.LOW),
		new Item("Gem of Excellent Luck", ClassType.ANY, 0, 0, 6, 0, 0, null, ItemValue.HIGH),
		new Item("Four-Leaf Clover", ClassType.ANY, 0, 0, 10, 0, 0, null, ItemValue.VERY_HIGH),
		new Item("Ring of Minor Defense", ClassType.ANY, 0, 0, 0, 2, 0, null, ItemValue.LOW),
		new Item("Ring of Moderate Defense", ClassType.ANY, 0, 0, 0, 5, 0, null, ItemValue.MODERATE),
		new Item("Ring of Major Defense", ClassType.ANY, 0, 0, 0, 8, 0, null, ItemValue.HIGH),
		new Item("Ring of Ultimate Defense", ClassType.ANY, 0, 0, 0, 12, 0, null, ItemValue.VERY_HIGH),
		new Item("Helm of Accuracy", ClassType.ANY, 1, 0, 0, 0, 0, null, ItemValue.LOW),
		new Item("Greater Helm of Accuracy", ClassType.ANY, 3, 0, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Helm of Strength", ClassType.ANY, 0, 1, 0, 0, 0, null, ItemValue.LOW),
		new Item("Greater Helm of Strength", ClassType.ANY, 0, 3, 0, 0, 0, null, ItemValue.HIGH),
		new Item("Boots of Speed", ClassType.ANY, 0, 0, 0, 0, 5, null, ItemValue.MODERATE),
		new Item("Greater Boots of Speed", ClassType.ANY, 0, 0, 0, 0, 10, null, ItemValue.HIGH),
		new Item("Coward's Cloak", ClassType.ANY, 0, 0, 0, -5, 20, null, ItemValue.VERY_HIGH),
		new Item("Perfect Weighted Dice", ClassType.ANY, 0, 0, 20, 0, 0, null, ItemValue.EPIC),
		new Item("Angel's Wings", ClassType.ANY, 0, 0, 0, 10, 20, null, ItemValue.EPIC),
		new Item("Demon's Wings", ClassType.ANY, 2, 2, 0, 20, -5, null, ItemValue.EPIC),
		new Item("Dragon's Bane", ClassType.ANY, 5, 5, 0, 0, 0, "dragon", ItemValue.EPIC)
	};
	
	//new Location(Name, LocationDifficulty)
	public static Location[] locations = {
		new Location("Dark Cave", LocationDifficulty.NORMAL),
		new Location("Abandoned Mineshaft", LocationDifficulty.NORMAL),
		new Location("Spooky Mansion", LocationDifficulty.NORMAL),
		new Location("Lava Field", LocationDifficulty.HARD),
		new Location("Cloud Castle", LocationDifficulty.BOSS),
		new Location("Summoning Circle", LocationDifficulty.HARD),
		new Location("Mage's Chambers", LocationDifficulty.NORMAL),
		new Location("Wizard's Spire", LocationDifficulty.HARD),
		new Location("Grassy Field", LocationDifficulty.EASY),
		new Location("Stinky Swamp", LocationDifficulty.NORMAL),
		new Location("Small Village", LocationDifficulty.EASY),
		new Location("Slimy Sewer", LocationDifficulty.EASY),
		new Location("Dangerous Dungeon", LocationDifficulty.NORMAL),
		new Location("Dilapidated Pirate Ship", LocationDifficulty.NORMAL),
		new Location("Rocky Chasm", LocationDifficulty.HARD),
		new Location("Endless Abyss", LocationDifficulty.BOSS),
		new Location("Snowy Mountaintop", LocationDifficulty.HARD),
		new Location("Evil Lair", LocationDifficulty.HARD),
		new Location("Shimmering Spring", LocationDifficulty.EASY),
		new Location("Volcanic Expanse", LocationDifficulty.HARD),
		new Location("Creepy Cemetary", LocationDifficulty.NORMAL),
		new Location("Deepwater Trench", LocationDifficulty.HARD),
		new Location("Rolling Hills", LocationDifficulty.EASY),
		new Location("Vast Lake", LocationDifficulty.NORMAL)
	};
	
	private PlayerClass player;
	private static Scanner scanner = new Scanner( System.in );
	
	public static void main(String[] args) {
		
		GenericAdventure game = new GenericAdventure();
		game.startGame();
	}
	
	public void startGame()
	{
		System.out.println("Initializing...");
		deleteCheckpoints();
		getTextInput("Press enter to start! ");
		Printer.blankLine(1);
		
		player = loadGame();
		boolean isLoaded = false;
		if (player != null)
		{
			System.out.println("Game has detected a save file: Level " + player.getLevel() + " " + player.getName() + ".");
			String loadResponse = getTextInput("Would you like to load this character? (*y/n): ");
			Printer.blankLine(1);
			
			if (!loadResponse.toLowerCase().equals("n"))
			{
				isLoaded = true;
			}
		}
		
		boolean hasCheckpoint = false;
		
		while (true)
		{
			if (!isLoaded)
			{
				boolean isCheckpointUsed = false;
				if (hasCheckpoint)
				{
					player = loadLastCheckpoint();
					
					String checkpointResponse = getTextInput("Press 'y' to load the last checkpoint, or 'n' to restart (*y/n): ");
					Printer.blankLine(1);
					
					if (!checkpointResponse.toLowerCase().equals("n"))
					{
						isCheckpointUsed = true;
						System.out.println("Your class is: " + player.getName());
						System.out.println("Class description: " + player.getDescription());
						player.printCharacterInfo();
						Printer.blankLine(1);
					}
				}
				
				if (!isCheckpointUsed)
				{
					System.out.println("Game Started: Choose your class!");
					
					boolean isClassChosen = false;
					while (!isClassChosen)
					{
						player = new PlayerClass(chooseClass());

						Printer.blankLine(1);
						System.out.println("Your class is: " + player.getName());
						System.out.println("Class description: " + player.getDescription());
						player.printCharacterInfo();
						Printer.blankLine(1);
						
						String classResponse = getTextInput("Press 'Enter' to choose this class, or 'c' to choose a different one: ");
						Printer.blankLine(1);
						
						if (!classResponse.toLowerCase().equals("c"))
						{
							isClassChosen = true;
							System.out.println(player.getName() + " selected.");
							Printer.blankLine(1);
						}
					}	
				}
			}

			boolean isAlive = true;

			addCheckpoint(player);
			hasCheckpoint = true;
			
			while (isAlive)
			{
				boolean isReady = false;
				
				while (!isReady)
				{
					String readyResponse = getTextInput("Press 'y' to go on an adventure, 'c' to view your character, or 's' to save your progress (*y/c/s): ");

					if (readyResponse.toLowerCase().equals("c"))
					{
						Printer.blankLine(1);
						player.printCharacterInfo();
						System.out.println("Your class is: " + player.getName());
						Printer.blankLine(1);
					}
					else if (readyResponse.toLowerCase().equals("s"))
					{
						Printer.blankLine(1);
						saveGame(player);
						Printer.blankLine(1);
					}
					else
					{
						isReady = true;
					}
				}
	
				isAlive = startAdventure(player);
				
				Printer.blankLine(3);
			}
			
			if (!player.isMaxLevel())
			{
				Printer.blankLine(1);
				System.out.println("You have died!");

				Printer.blankLine(1);
				System.out.println("|> " + Printer.getTextLine("!", 31) + " <|");
				System.out.println(Printer.getTextLine(" ", 10) + "Your final stats:");
				
				player.printCharacterInfo();

				System.out.println("|> " + Printer.getTextLine("!", 31) + " <|");
				
				Printer.blankLine(3);
			}
			
			isLoaded = false;
			saveGame(null);
			
			getTextInput("Press enter to play again! ");
		}
	}
	
	public boolean startAdventure(PlayerClass player)
	{
		Printer.blankLine(1);
		System.out.println("Adventure Started!");
		System.out.println(Printer.getTextLine("~", 30));
		
		boolean isComplete = false;
		
		Monster monster = new Monster(getRandomMonster(player));

		Location location = new Location(getRandomLocation(player));
		
		monster.scaleStats(location.getDifficultyModifier());
		
		Printer.blankLine(1);
		System.out.println("You are in " + Printer.getDeterminer(location.name) + " " + location.name
				+ ", fighting " + Printer.getDeterminer(monster.getName()) + " " + monster.getName() + "!"
				+ " [Difficulty: " + monster.getRelativeDifficulty(player) + "]");
		
		player.restoreHealth();
		
		if (player.getItem() != null)
		{
			int itemHealth = player.getItem().getHealth();
			
			if (player.getItem().getMonsterFocus() != null && monster.getName().toLowerCase().contains(player.getItem().getMonsterFocus()))
			{
				itemHealth *= player.getItem().getMonsterFocusMultiplier();
			}

			player.setCurrentHealth(player.getCurrentHealth() + itemHealth);
		}
		
		while (!isComplete)
		{
			Printer.blankLine(1);
			String action = getTextInput("\tWhich action do you take? (*attack/flee) ");

			if (action.toLowerCase().equals("flee") || action.toLowerCase().equals("f"))
			{
				isComplete = flee(player, monster);
			}
			else
			{
				isComplete = attack(player, monster);
			}
			
			if (!isComplete)
			{
				boolean isAlive = monsterTurn(player, monster);
				
				if (!isAlive)
				{
					return false;
				}
			}
		}
		
		Printer.blankLine(1);
		System.out.println("Adventure Completed!");
		System.out.println(Printer.getTextLine("~", 30));
		
		player.restoreHealth();
		
		if (player.isMaxLevel())
		{
			System.out.println("Congratulations! You won the game! Final Stats:");
			Printer.blankLine(1);
			player.printCharacterInfo();
			
			return false;
		}
		
		return true;
	}
	
	public boolean attack(PlayerClass player, Monster monster)
	{
		Printer.blankLine(1);
		System.out.println("\tYou attack " + monster.getName() + ":");

		Random rand = new Random();
		
		int minDamage = player.getMinDamage();
		int maxDamage = player.getMaxDamage();
		int critChance = player.getCritChance();
		
		if (player.getItem() != null)
		{
			int itemMinDamage = player.getItem().getMinDamage();
			int itemMaxDamage = player.getItem().getMaxDamage();
			int itemCritChance = player.getItem().getCritChance();

			if (player.getItem().getMonsterFocus() != null && monster.getName().toLowerCase().contains(player.getItem().getMonsterFocus()))
			{
				itemMinDamage *= player.getItem().getMonsterFocusMultiplier();
				itemMaxDamage *= player.getItem().getMonsterFocusMultiplier();
				itemCritChance *= player.getItem().getMonsterFocusMultiplier();
			}
		
			minDamage = (player.getMinDamage() + itemMinDamage) >= 1 ? (player.getMinDamage() + itemMinDamage) : 1;
			maxDamage = (player.getMaxDamage() + itemMaxDamage) >= 1 ? (player.getMaxDamage() + itemMaxDamage) : 1;
			critChance = (player.getCritChance() + itemCritChance) >= 0 ? (player.getCritChance() + itemCritChance) : 0;
		}
		
		minDamage = (minDamage > maxDamage) ? maxDamage : minDamage;
		int randDamage = rand.nextInt((maxDamage - minDamage) + 1) + minDamage;
		
		int critRoll = rand.nextInt(100) + 1;
		if (critChance >= critRoll)
		{
			System.out.println("\t|> You critically hit!");
			randDamage += rand.nextInt((maxDamage - minDamage) + 1) + minDamage;
		}
		
		monster.takeDamage(randDamage);
		
		System.out.println("\t|> You hit " + monster.getName() + " for " + randDamage + " points of damage!");
		
		if (monster.getCurrentHealth() <= 0)
		{
			System.out.println("\t|> " + monster.getName() + " has health 0/" + monster.getMaxHealth() + ".");
			System.out.println("\t|> " + monster.getName() + " was slain!");
			
			Item template = getRandomItem(monster.getItemLevel());
			
			if (template != null)
			{
				Item item = new Item(template);
				
				Printer.blankLine(1);
				System.out.println("\t" + monster.getName() + " dropped " + item.getName() + ":");
				item.printItemInfo();
				
				pickItem(player, item);
			}
			
			Printer.blankLine(1);
			int experience = monster.getDifficultyModifier();
			if (monster.getDifficultyModifier() > (int)(player.getLevel()*1.5) + 4)
			{
				experience *= 10;
			}
			else if (monster.getDifficultyModifier() > player.getLevel())
			{
				experience *= 5;
			}
			
			System.out.println("\tYou earned " + experience + " experience points!");
			
			player.addExperience(experience);
		}
		else
		{
			System.out.println("\t|> " + monster.getName() + " has health " + monster.getCurrentHealth() + "/" + monster.getMaxHealth() + ".");
		}
		
		return monster.getCurrentHealth() <= 0;
	}
	
	public boolean flee(PlayerClass player, Monster monster)
	{
		Printer.blankLine(1);
		System.out.println("\tYou attempt to flee...");
		
		Random rand = new Random();
		int roll = rand.nextInt(100) + 1;
		
		int fleeChance = player.getFleeChance();
		
		if (player.getItem() != null)
		{
			int itemFleeChance = player.getItem().getFleeChance();
			
			if (player.getItem().getMonsterFocus() != null && monster.getName().toLowerCase().contains(player.getItem().getMonsterFocus()))
			{
				itemFleeChance *= player.getItem().getMonsterFocusMultiplier();
			}
			
			fleeChance = Math.max(0, Math.min(100, fleeChance + itemFleeChance));
		}
		
		if (fleeChance >= roll)
		{
			System.out.println("\t|> You managed to escape!");
		}
		else
		{
			System.out.println("\t|> You failed to escape!");
		}
		
		return fleeChance >= roll;
	}
	
	public boolean monsterTurn(PlayerClass player, Monster monster)
	{
		Printer.blankLine(1);
		System.out.println("\t" + monster.getName() + " attacks you:");
		
		Random rand = new Random();
		int randDamage = rand.nextInt((monster.getMaxDamage() - monster.getMinDamage()) + 1) + monster.getMinDamage();
		player.takeDamage(randDamage, monster);
		
		if (player.getCurrentHealth() > 0)
		{
			System.out.println("\t|> You have health " + player.getCurrentHealth() + "/" + player.getHealth() + ".");
			Printer.blankLine(1);
		}
		
		return player.getCurrentHealth() > 0;
	}
	
	public Monster getRandomMonster(PlayerClass player)
	{
		Random rand = new Random();
		int roll = rand.nextInt(100);
		
		MonsterRarity rarity = MonsterRarity.COMMON;
		
		if (player.getLevel() < 3)
		{
			if (roll < 70)
				rarity = MonsterRarity.COMMON;
			else if (roll < 100)
				rarity = MonsterRarity.UNCOMMON;
		}
		else if (player.getLevel() < 5)
		{
			if (roll < 45)
				rarity = MonsterRarity.COMMON;
			else if (roll < 85)
				rarity = MonsterRarity.UNCOMMON;
			else if (roll < 100)
				rarity = MonsterRarity.RARE;
		}
		else if (player.getLevel() < 8)
		{
			if (roll < 35)
				rarity = MonsterRarity.COMMON;
			else if (roll < 75)
				rarity = MonsterRarity.UNCOMMON;
			else if (roll < 95)
				rarity = MonsterRarity.RARE;
			else if (roll < 100)
				rarity = MonsterRarity.BOSS;
		}
		else if (player.getLevel() < 10)
		{
			if (roll < 15)
				rarity = MonsterRarity.COMMON;
			else if (roll < 45)
				rarity = MonsterRarity.UNCOMMON;
			else if (roll < 90)
				rarity = MonsterRarity.RARE;
			else if (roll < 99)
				rarity = MonsterRarity.BOSS;
			else if (roll < 100)
				rarity = MonsterRarity.MEGABOSS;
		}
		else if (player.getLevel() < 15)
		{
			if (roll < 5)
				rarity = MonsterRarity.COMMON;
			else if (roll < 25)
				rarity = MonsterRarity.UNCOMMON;
			else if (roll < 80)
				rarity = MonsterRarity.RARE;
			else if (roll < 98)
				rarity = MonsterRarity.BOSS;
			else if (roll < 100)
				rarity = MonsterRarity.MEGABOSS;
		}
		else 
		{
			if (roll < 10)
				rarity = MonsterRarity.UNCOMMON;
			else if (roll < 60)
				rarity = MonsterRarity.RARE;
			else if (roll < 95)
				rarity = MonsterRarity.BOSS;
			else if (roll < 100)
				rarity = MonsterRarity.MEGABOSS;
		}
		
		ArrayList<Monster> possibleMonsters = new ArrayList<Monster>();
		
		for (int i = 0; i < monsters.length; i++)
		{
			if (monsters[i].getRarity() == rarity)
			{
				if (player.getLevel() != 1 
				 &&	monsters[i].getDifficultyModifier() >= player.getLevel() - 3
				 && monsters[i].getDifficultyModifier() <= (int)(player.getLevel()*1.5) + 8)
					possibleMonsters.add(monsters[i]);
				else if (player.getLevel() == 1
				 && monsters[i].getDifficultyModifier() >= 1
				 && monsters[i].getDifficultyModifier() <= 6)
					possibleMonsters.add(monsters[i]);
			}
		}

		int randomMonsterIndex = rand.nextInt(possibleMonsters.size());
		
		return possibleMonsters.get(randomMonsterIndex);
	}
	
	public Location getRandomLocation(PlayerClass player)
	{
		Random rand = new Random();
		int roll = rand.nextInt(100);

		LocationDifficulty difficulty = LocationDifficulty.EASY;
		
		if (player.getLevel() < 4)
		{
			if (roll < 50)
				difficulty = LocationDifficulty.EASY;
			else if (roll < 100)
				difficulty = LocationDifficulty.NORMAL;
		}
		else if (player.getLevel() < 8)
		{
			if (roll < 30)
				difficulty = LocationDifficulty.EASY;
			else if (roll < 70)
				difficulty = LocationDifficulty.NORMAL;
			else if (roll < 100)
				difficulty = LocationDifficulty.HARD;
		}
		else if (player.getLevel() < 12)
		{
			if (roll < 20)
				difficulty = LocationDifficulty.EASY;
			else if (roll < 50)
				difficulty = LocationDifficulty.NORMAL;
			else if (roll < 80)
				difficulty = LocationDifficulty.HARD;
			else if (roll < 100)
				difficulty = LocationDifficulty.BOSS;
		}
		else
		{
			if (roll < 10)
				difficulty = LocationDifficulty.EASY;
			else if (roll < 40)
				difficulty = LocationDifficulty.NORMAL;
			else if (roll < 75)
				difficulty = LocationDifficulty.HARD;
			else if (roll < 100)
				difficulty = LocationDifficulty.BOSS;
		}
		
		ArrayList<Location> possibleLocations = new ArrayList<Location>();
		
		for (int i = 0; i < locations.length; i++)
		{
			if (locations[i].difficulty == difficulty)
			{
				possibleLocations.add(locations[i]);
			}
		}
		
		int randomLocationIndex = rand.nextInt(possibleLocations.size());

		return possibleLocations.get(randomLocationIndex);
	}
	
	public Item getRandomItem(MonsterItemLevel difficulty)
	{
		Random rand = new Random();
		int roll = rand.nextInt(100);
		
		ItemValue value = null;
		
		if (difficulty == MonsterItemLevel.EASY) //difficultyModifier <= 6
		{
			if (roll < 25)
				value = ItemValue.VERY_LOW;
			else if (roll < 40)
				value = ItemValue.LOW;
			else if (roll < 45)
				value = ItemValue.MODERATE;
		}
		else if (difficulty == MonsterItemLevel.NORMAL) //difficultyModifier <= 12
		{
			if (roll < 5)
				value = ItemValue.VERY_LOW;
			else if (roll < 15)
				value = ItemValue.LOW;
			else if (roll < 45)
				value = ItemValue.MODERATE;
			else if (roll < 50)
				value = ItemValue.HIGH;
		}
		else if (difficulty == MonsterItemLevel.HARD) //difficulty <= 18
		{
			if (roll < 5)
				value = ItemValue.LOW;
			else if (roll < 15)
				value = ItemValue.MODERATE;
			else if (roll < 45)
				value = ItemValue.HIGH;
			else if (roll < 50)
				value = ItemValue.VERY_HIGH;
		}
		else if (difficulty == MonsterItemLevel.BOSS) //difficultyModifier <= 30
		{
			if (roll < 5)
				value = ItemValue.MODERATE;
			else if (roll < 15)
				value = ItemValue.HIGH;
			else if (roll < 50)
				value = ItemValue.VERY_HIGH;
			else if (roll < 60)
				value = ItemValue.EPIC;
		}
		else //difficultyModifier > 30
		{
			if (roll < 10)
				value = ItemValue.HIGH;
			else if (roll < 40)
				value = ItemValue.VERY_HIGH;
			else if (roll < 80)
				value = ItemValue.EPIC;
		}
		
		if (value != null)
		{
			ArrayList<Item> possibleItems = new ArrayList<Item>();
			
			for (int i = 0; i < items.length; i++)
			{
				if (items[i].getValue() == value)
				{
					possibleItems.add(items[i]);
				}
			}
			
			int randomItemIndex = rand.nextInt(possibleItems.size());
			
			return possibleItems.get(randomItemIndex);
		}
		
		return null;
	}
	
	public void pickItem(PlayerClass player, Item item)
	{
		boolean hasChosen = false;
		
		while (!hasChosen)
		{
			if (player.getItem() != null)
			{
				Printer.blankLine(1);
				System.out.println("\tYour current item is " + player.getItem().getName() + ":");
				player.getItem().printItemInfo();
			}
			
			boolean isItemBetter = true;
			String itemResponse = "";
			
			Printer.blankLine(1);
			
			if (player.getItem() != null && item.getValue().ordinal() <= player.getItem().getValue().ordinal())
			{
				isItemBetter = false;
				itemResponse = getTextInput("\tDo you wish to take the item? (y/*n): ");
			}
			else
			{
				itemResponse = getTextInput("\tDo you wish to take the item? (*y/n): ");
			}
			
			if ((!itemResponse.toLowerCase().equals("n") && isItemBetter) || (itemResponse.toLowerCase().equals("y") && !isItemBetter))
			{
				Printer.blankLine(1);
				
				if (item.isRestricted(player.getClassType()))
				{
					System.out.println("\tYour class cannot use this item.");
					hasChosen = true;
				}
				else if (player.getItem() != null && item.getValue().ordinal() <= player.getItem().getValue().ordinal())
				{
					itemResponse = getTextInput("\tAre you sure you want to replace " + player.getItem().getName() + " with " + item.getName() + "? (*y/n): ");
					
					if (!itemResponse.toLowerCase().equals("n"))
					{
						System.out.println("\tYou equip " + item.getName() + ".");
						player.equipItem(item);
						hasChosen = true;
					}
				}
				else
				{
					System.out.println("\tYou equip " + item.getName() + ".");
					player.equipItem(item);
					hasChosen = true;
				}
			}
			else
			{
				Printer.blankLine(1);
				System.out.println("\tYou leave the item.");
				hasChosen = true;
			}
		}
	}
	
	public PlayerClass chooseClass()
	{
		String message = "";
		
		for (int i = 0; i < playerClasses.length; i++)
		{
			if (i > 0) message += "\n";
			message += "Type " + i + " for " + playerClasses[i].getName();
		}
		
		message += "\nPlease enter the number of your desired class: ";
				
		int index = getIntInput(message);
		
		while (index >= playerClasses.length || index < 0)
		{
			System.out.println("Please choose a valid class number!");
			index = getIntInput(message);
		}
		
		return playerClasses[index];
	}
	
	public static void saveGame(PlayerClass player)
	{
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));)
		{
			out.writeObject(player);
			if (player != null)
				System.out.println("Your progress has been saved.");
		}
		catch(IOException e)
		{
			System.out.println("Failed to save.");
		}
	}
	
	public static PlayerClass loadGame()
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.dat"));)
		{
			return (PlayerClass) in.readObject();
		}
		catch(FileNotFoundException e)
		{
			return null;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Failed to load: Class not found or not serializable.");
			return null;
		}
		catch(IOException e)
		{
			System.out.println("Failed to load: No valid save file found.");
			return null;
		}
	}
	
	public static void addCheckpoint(PlayerClass player)
	{
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("checkpoint" + player.getLevel() + ".dat"));)
		{
			out.writeObject(player);
		}
		catch(IOException e)
		{
			System.out.println("Failed to add checkpoint.");
		}
	}
	
	public static void deleteCheckpoints()
	{
		File cp = new File("checkpoint1.dat");
		int index = 2;
		while (cp.exists())
		{
			cp.delete();
			cp = new File("checkpoint" + index + ".dat");
			index++;
		}
	}
	
	private static int getLastCheckpointIndex()
	{
		int index = 1;
		File cp = new File("checkpoint" + index + ".dat");
		while (cp.exists())
		{
			index++;
			cp = new File("checkpoint" + index + ".dat");
		}
		return index - 1;
	}
	
	public static PlayerClass loadLastCheckpoint()
	{
		int index = getLastCheckpointIndex();
		if (index != 1)
		{
			File oldCheckpoint = new File("checkpoint" + index + ".dat");
			oldCheckpoint.delete();
			index--;
		}
		File lastCheckpoint = new File("checkpoint" + index + ".dat");
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(lastCheckpoint));)
		{
			return (PlayerClass) in.readObject();
		}
		catch(FileNotFoundException e)
		{
			return null;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Failed to load: Class not found or not serializable.");
			return null;
		}
		catch(IOException e)
		{
			System.out.println("Failed to load: No valid save file found.");
			return null;
		}
		finally
		{
			lastCheckpoint.delete();
		}
	}
	
	public static String getTextInput(String message)
	{
		System.out.print(message);
		
		String result = scanner.nextLine();
		
		return result;
	}
	
	public static int getIntInput(String message)
	{
		System.out.print(message);
		
		int result = -1;
		
		while (result == -1)
		{
			try
			{
				result = scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				Printer.blankLine(1);
				System.out.println("Invalid Input.");
				System.out.print(message);
			}
			finally
			{
				scanner.nextLine();
			}
		}
		
		return result;
	}

}
