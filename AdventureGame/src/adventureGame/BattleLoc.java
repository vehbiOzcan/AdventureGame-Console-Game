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
		System.out.print("<S>avaþ veya <K>aç :");
		String selCase = input.nextLine();
		selCase = selCase.toUpperCase();
		System.out.println("_____________________");
		if (selCase.equals("S")) {
			int temp= combat(obsCount);
			if (temp == 1) {
				System.out.println("Sen savaþçý olarak doðmuþsun! Hepsinin canýna okudun :)");
				if(this.award.equals("Yiyecek") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setFood(true);
					System.out.println("Yeni bölge kilidi açýldý : Orman");
				}
				else if(this.award.equals("Odun") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setFirewood(true);
					System.out.println("Yeni bölge kilidi açýldý : Nehir");
				}
				else if(this.award.equals("Su") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Buldun!");
					player.getInv().setWater(true);
				}
				return true;
			} else if(temp == -1) {
				System.out.println("Gerçek bir savaþçýyý kaybetmenin üzüntüsünü yaþýyoruz.Huzur içinde yat dostum :(");
				return false;
			}
		} else {
			return true;
		}
	return true;
	}

	public void battleStats() {
		System.out.println("Senin Deðerlerin:");
		System.out.println("-> Saðlýk: " + player.getHealty() + " Hasar: " + player.getTotalDamage());
		if (player.getInv().getDamage() > 0)
			System.out.println("Silah: +" + player.getInv().getDamage() + " " + player.getInv().getwName());
		if (player.getInv().getArmor() > 0)
			System.out.println("Zýrh: +" + player.getInv().getArmor() + " " + player.getInv().getaName());
		System.out.println();
		System.out.println(obstacle.getName() + " deðerleri: ");
		System.out.println("-> Saðlýk: " + obstacle.getHealt() + " Hasar: " + obstacle.getDamage()+ " Ödül: "+ obstacle.getAward());
	}

	public void enemyStats() {
		System.out.println();
		System.out.println(obstacle.getName() + " deðerleri: ");
		System.out.println("-> Saðlýk: " + obstacle.getHealt() + " Hasar: " + obstacle.getDamage() + " Ödül: "+ obstacle.getAward());
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Senin Deðerlerin:");
		System.out.println("-> Saðlýk: " + player.getHealty() + " Hasar: " + player.getTotalDamage());
	}

	public void afterHit() {
		if(obstacle.getHealt() > 0)
			System.out.println(obstacle.getName() + " Saðlýk: " + obstacle.getHealt());
		else
			System.out.println("Hey lanet olasý "+ obstacle.getName() +"! Canýna okudun dostum!");
		if(player.getHealty() > 0)
			System.out.println(player.getName() + " Saðlýk: " + player.getHealty());
		else
			System.out.println("Öldün!");
		System.out.println(); 
	}

	private int combat(int obsCount) {
		String selCase;
		int defHealt = obstacle.getHealt();
		for (int i = 1; i <= obsCount; i++) {
			
			while (player.getHealty() > 0 && obstacle.getHealt() > 0) {
				System.out.print("<V>ur veya <K>aç :");
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
				System.out.println("Bir " + obstacle.getName() + " öldürdün");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Güncel Para:" + player.getMoney() + " MC");
				obstacle.setHealt(defHealt);
			} else {
				return -1;
			}
		}
		return 1;
	}
}