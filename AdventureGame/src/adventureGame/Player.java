package adventureGame;

import java.util.Scanner;

public class Player {
	private int damage, healty, money, rHealty,armor;
	private String name, cName;
	private Inventory inv = new Inventory();
	Scanner input = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
	}

	public void selectChar() {
		switch (charMenu()) {

		case 1:
			initalPlayer("Samuray", 5, 21, 15);
			break;

		case 2:
			initalPlayer("Ok�u", 7, 18, 20);
			break;

		case 3:
			initalPlayer("�ovalye", 8, 24, 5);
			break;

		default:
			initalPlayer("Samuray", 8, 24, 5);
			break;
		}
		System.out.println(getcName() + " se�ildi !");
		System.out.println("�zellikler -> " + "Hasar: " + getDamage() + " Sa�l�k: " + getHealty() + " Para: " + getMoney());
	}

	public int charMenu() {
		System.out.println("L�tfen bir karakter se�: ");
		System.out.println("1 - Samuray ->\t Hasar: 5 \t Sa�l�k: 21 \t Para: 15");
		System.out.println("2 - Ok�u    ->\t Hasar: 7 \t Sa�l�k: 18 \t Para: 20");
		System.out.println("3 - �ovalye ->\t Hasar: 8 \t Sa�l�k: 24 \t Para: 5");
		System.out.print("Karakter Se�imi: ");
		int charID = input.nextInt();

		while (charID < 1 || charID > 3) {
			System.out.print("Heey " + getName() + ","	+ " buradakiler onlar� be�enmedi�ini d���necek ! L�tfen ge�erli bir giri� yap: ");
			charID = input.nextInt();
		}
		return charID;
	}

	public void initalPlayer(String cName, int damage, int healty, int money) {
		setcName(cName);
		setDamage(damage);
		setHealty(healty);
		setMoney(money);
		setrHealty(healty);
	}
	
	public int getTotalDamage() {
		return this.damage + this.getInv().getDamage(); 
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public int getrhealty() {
		return rHealty;
	}

	public void setrHealty(int rhealty) {
		this.rHealty = rhealty;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
