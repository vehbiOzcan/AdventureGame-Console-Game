package adventureGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;

	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.print("Oyuna ba�lamadan �nce isminiz giriniz: ");
		String playerName = input.nextLine();
		System.out.println("Macera Oyununa Ho�geldin " + playerName + " !");
		player = new Player(playerName);
		player.selectChar();
		start();
	}
	
	public void start() {
		while (true) {
			System.out.println();
			System.out.println("==========================================");
			System.out.println();
			System.out.println("1 - G�venli Ev");
			System.out.println("2 - Market");
			System.out.println("3 - Ma�ara");
			System.out.println("4 - Orman");
			System.out.println("5 - Nehir");
			System.out.println("6 - Meydan");
			System.out.println("7 - ��k��");
			System.out.print("Nereye gitmek istiyorsun :");
			Scanner input = new Scanner(System.in);
			int selectLoc = input.nextInt();
			System.out.println();
			while (selectLoc < 1 || selectLoc > 7) {
				System.out.print("B�yle bir yeri daha �nce hi� duymad�m.Bildi�im bir yere gidebiliriz: ");
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
					System.out.println("Orman Kilitli\n�nce ma�aradan Yiyecek itemini toplamal�s�n.");
				break;
			case 5:
				if (player.getInv().isFood() && player.getInv().isFirewood())
					location = new River(player);
				else
					System.out.println("Nehir Kilitli\n�nce ma�aradan 'Yiyecek' itemini ve Ormandan 'Odun' itemini toplamal�s�n.");
				break;
			case 6:
				location = new Square(player);
				break;
			case 7:
				System.out.println(player.getName() + " senin gibi bir sava���y� tan�mak onurdu. Umar�m bir daha g�r���r�z...");
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
						System.out.println("Buradaki i�in bitti. Art�k buralardan gidebilirsin yada buralar� korumaya devam edebilirsin.");
						System.out.print("<G>it veya <Koru> :");
						selCase = input.next();
						selCase = selCase.toUpperCase();
						if (selCase.equals("G")) {
							System.out.println("Sen bir kahramans�n, seni tan�mak g�zeldi " + player.getName() + "...");
							System.out.println("Oyunu kazand�n !");
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
