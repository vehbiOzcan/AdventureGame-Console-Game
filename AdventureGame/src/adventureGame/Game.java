package adventureGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;

	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.print("Oyuna baþlamadan önce isminiz giriniz: ");
		String playerName = input.nextLine();
		System.out.println("Macera Oyununa Hoþgeldin " + playerName + " !");
		player = new Player(playerName);
		player.selectChar();
		start();
	}
	
	public void start() {
		while (true) {
			System.out.println();
			System.out.println("==========================================");
			System.out.println();
			System.out.println("1 - Güvenli Ev");
			System.out.println("2 - Market");
			System.out.println("3 - Maðara");
			System.out.println("4 - Orman");
			System.out.println("5 - Nehir");
			System.out.println("6 - Meydan");
			System.out.println("7 - Çýkýþ");
			System.out.print("Nereye gitmek istiyorsun :");
			Scanner input = new Scanner(System.in);
			int selectLoc = input.nextInt();
			System.out.println();
			while (selectLoc < 1 || selectLoc > 7) {
				System.out.print("Böyle bir yeri daha önce hiç duymadým.Bildiðim bir yere gidebiliriz: ");
				selectLoc = input.nextInt();
			}
			System.out.println("=========================================");
			switch (selectLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new ToolStore(player);
				break;
			case 3:
				location = new Cave(player);
				break;
			case 4:
				if (player.getInv().isFood())
					location = new Forest(player);
				else
					System.out.println("Orman Kilitli\nÖnce maðaradan Yiyecek itemini toplamalýsýn.");
				break;
			case 5:
				if (player.getInv().isFood() && player.getInv().isFirewood())
					location = new River(player);
				else
					System.out.println("Nehir Kilitli\nÖnce maðaradan 'Yiyecek' itemini ve Ormandan 'Odun' itemini toplamalýsýn.");
				break;
			case 6:
				location = new Square(player);
				break;
			case 7:
				System.out.println(player.getName() + " senin gibi bir savaþçýyý tanýmak onurdu. Umarým bir daha görüþürüz...");
				break;
			default:
				location = new SafeHouse(player);
				break;
			}
			if (selectLoc == 7) {
				break;
			}
			if(location != null) {
				String selCase ;
				if(location.getName().equals("Meydan")) {
					if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
						System.out.println("Buradaki iþin bitti. Artýk buralardan gidebilirsin yada buralarý korumaya devam edebilirsin.");
						System.out.print("<G>it veya <Koru> :");
						selCase = input.next();
						selCase = selCase.toUpperCase();
						if (selCase.equals("G")) {
							System.out.println("Sen bir kahramansýn, seni tanýmak güzeldi " + player.getName() + "...");
							System.out.println("Oyunu kazandýn !");
							break;
						}
					}
				}
			
			
				if (!location.getLocation()) {
					
					System.out.println("Oyun bitti");
					break;
				}
			}
		}
	}
}
