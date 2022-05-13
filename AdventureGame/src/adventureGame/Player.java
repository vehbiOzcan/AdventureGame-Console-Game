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
			initalPlayer("Okçu", 7, 18, 20);
			break;

		case 3:
			initalPlayer("Þovalye", 8, 24, 5);
			break;

		default:
			initalPlayer("Samuray", 8, 24, 5);
			break;
		}
		System.out.println(getcName() + " seçildi !");
		System.out.println("Özellikler -> " + "Hasar: " + getDamage() + " Saðlýk: " + getHealty() + " Para: " + getMoney());
	}

	public int charMenu() {
		System.out.println("Lütfen bir karakter seç: ");
		System.out.println("1 - Samuray ->\t Hasar: 5 \t Saðlýk: 21 \t Para: 15");
		System.out.println("2 - Okçu    ->\t Hasar: 7 \t Saðlýk: 18 \t Para: 20");
		System.out.println("3 - Þovalye ->\t Hasar: 8 \t Saðlýk: 24 \t Para: 5");
		System.out.print("Karakter Seçimi: ");
		int charID = input.nextInt();

		while (charID < 1 || charID > 3) {
			System.out.print("Heey " + getName() + ","	+ " buradakiler onlarý beðenmediðini düþünecek ! Lütfen geçerli bir giriþ yap: ");
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
