package adventureGame;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println(this.getName() + " geldik...");
		System.out.println(
				player.getName() + " dikkat et ! Burada " + obsCount + " tane " + obstacle.getName() + " var.");
		battleStats();
		System.out.print("<S>ava� veya <K>a� :");
		String selCase = input.nextLine();
		selCase = selCase.toUpperCase();
		System.out.println("_____________________");
		if (selCase.equals("S")) {
			int temp= combat(obsCount);
			if (temp == 1) {
				System.out.println("Sen sava��� olarak do�mu�sun! Hepsinin can�na okudun :)");
				if(this.award.equals("Yiyecek") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setFood(true);
					System.out.println("Yeni b�lge kilidi a��ld� : Orman");
				}
				else if(this.award.equals("Odun") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setFirewood(true);
					System.out.println("Yeni b�lge kilidi a��ld� : Nehir");
				}
				else if(this.award.equals("Su") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setWater(true);
				}
				return true;
			} else if(temp == -1) {
				System.out.println("Ger�ek bir sava���y� kaybetmenin �z�nt�s�n� ya��yoruz.Huzur i�inde yat dostum :(");
				return false;
			}
		} else {
			return true;
		}
	return true;
	}

	public void battleStats() {
		System.out.println("Senin De�erlerin:");
		System.out.println("-> Sa�l�k: " + player.getHealty() + " Hasar: " + player.getTotalDamage());
		if (player.getInv().getDamage() > 0)
			System.out.println("Silah: +" + player.getInv().getDamage() + " " + player.getInv().getwName());
		if (player.getInv().getArmor() > 0)
			System.out.println("Z�rh: +" + player.getInv().getArmor() + " " + player.getInv().getaName());
		System.out.println();
		System.out.println(obstacle.getName() + " de�erleri: ");
		System.out.println("-> Sa�l�k: " + obstacle.getHealt() + " Hasar: " + obstacle.getDamage()+ " �d�l: "+ obstacle.getAward());
	}

	public void enemyStats() {
		System.out.println();
		System.out.println(obstacle.getName() + " de�erleri: ");
		System.out.println("-> Sa�l�k: " + obstacle.getHealt() + " Hasar: " + obstacle.getDamage() + " �d�l: "+ obstacle.getAward());
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Senin De�erlerin:");
		System.out.println("-> Sa�l�k: " + player.getHealty() + " Hasar: " + player.getTotalDamage());
	}

	public void afterHit() {
		if(obstacle.getHealt() > 0)
			System.out.println(obstacle.getName() + " Sa�l�k: " + obstacle.getHealt());
		else
			System.out.println("Hey lanet olas� "+ obstacle.getName() +"! Can�na okudun dostum!");
		if(player.getHealty() > 0)
			System.out.println(player.getName() + " Sa�l�k: " + player.getHealty());
		else
			System.out.println("�ld�n!");
		System.out.println(); 
	}

	private int combat(int obsCount) {
		String selCase;
		int defHealt = obstacle.getHealt();
		for (int i = 1; i <= obsCount; i++) {
			
			while (player.getHealty() > 0 && obstacle.getHealt() > 0) {
				System.out.print("<V>ur veya <K>a� :");
				selCase = input.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("Sen +"+player.getTotalDamage() +" vurdun!");
					obstacle.setHealt(obstacle.getHealt() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealt() > 0) {
						System.out.println();
						System.out.println(obstacle.getName() +" "+"-"+(obstacle.getDamage() - player.getInv().getArmor()) +" vurdu!");
						player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}

				} else {
					return 0;
				}
			}
			if (obstacle.getHealt() <= 0 && player.getHealty() > 0) {
				System.out.println("Bir " + obstacle.getName() + " �ld�rd�n");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("G�ncel Para:" + player.getMoney() + " MC");
				obstacle.setHealt(defHealt);
			} else {
				return -1;
			}
		}
		return 1;
	}
}