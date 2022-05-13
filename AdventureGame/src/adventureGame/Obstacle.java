package adventureGame;

import java.util.Random;

public class Obstacle {
	private String name;
	private int damage, award, healt, maxNumber;

	public Obstacle(String name, int damage, int healt, int award, int maxNumber) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.healt = healt;
		this.maxNumber = maxNumber;
	}

	public int count() {
		Random r = new Random();
		return r.nextInt(maxNumber) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

}
