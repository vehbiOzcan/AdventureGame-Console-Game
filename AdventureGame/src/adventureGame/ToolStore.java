package adventureGame;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Market");
	}

	@Override
	public boolean getLocation() {
		System.out.println("Para: " + getPlayer().getMoney());
		System.out.println("1- Silahlar");
		System.out.println("2- Zýrhlar");
		System.out.println("3- Çýkýþ");
		System.out.print("Seç: ");
		int selTool = input.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = wheaponMenu();
			buyWheapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		case 3:
			System.out.println("Marketten ayrýldýn.");
			break;
		default:
			System.out.println("Ne arýyorsan o burada yok !..");
			break;
		}
		return true;
	}

	public int wheaponMenu() {
		System.out.println("1- Katana..... \t <Para: 25 Hasar : 2>");
		System.out.println("2- Baretta 9mm \t <Para: 35 Hasar: 4>");
		System.out.println("3- M4A1 tüfek. \t <Para:45 Hasar:10>");
		System.out.println("4- Geri dön");
		System.out.print("Seçimin: ");
		int selWheapon = input.nextInt();
		return selWheapon;
	}

	public void buyWheapon(int selItemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (selItemID) {
		case 1:
			wName = "Katana";
			damage = 2;
			price = 20;
			break;
		case 2:
			wName = "Baretta";
			damage = 4;
			price = 35;
			break;
		case 3:
			wName = "M4A1";
			damage = 10;
			price = 45;
			break;
		case 4:
			System.out.println("Marketten ayrýldýn.");
			break;
		default:
			break;
		}
		if (price > 0) {

			if (player.getMoney() >= price) {
				if (!wName.equals(player.getInv().getwName())) {
					player.getInv().setDamage(damage);
					player.getInv().setwName(wName);
					player.setMoney(player.getMoney() - price);
					System.out.println(wName + " " + price + " MonsterCoin'e envantere eklendi.");
					System.out.println("Önceki Hasar:" + player.getDamage() + " Yeni Hasar:" + player.getTotalDamage()+ " Kalan MC:" + player.getMoney());
				} else
					System.out.println("2. sine gerek yok zaten bir " + wName + "'e sahipsin");
			} 
			else {
				System.out.println(wName + " almak için paran yetersiz. Biraz daha çalýþmalýsýn");
			}
		}

	}
	
	public int armorMenu() {
		System.out.println("1- Zincir Zýrh \t <Para:15 Koruma:2>");
		System.out.println("2- Çelik Zýrh. \t <Para:25 Koruma:3>");
		System.out.println("3- Altýn Zýrh. \t <Para:35 Koruma:4>");
		System.out.println("4- Geri dön");
		System.out.print("Seçimin: ");
		int selArmorID = input.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int selItemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (selItemID) {
		case 1:
			aName = "Zincir Zýrh";
			avoid = 1;
			price = 15;
			break;
		case 2:
			aName = "Çelik Zýrh";
			avoid= 2;
			price = 25;
			break;
		case 3:
			aName = "Altýn Zýrh";
			avoid = 3;
			price = 35;
			break;
		case 4:
			System.out.println("Marketten ayrýldýn.");
			break;
		default:
			break;
		}
		if (price > 0) {

			if (player.getMoney() >= price) {
				if (!aName.equals(player.getInv().getaName())) {
					player.getInv().setArmor(avoid);
					player.getInv().setaName(aName);
					player.setMoney(player.getMoney() - price);
					System.out.println(aName + " " + price + " MonsterCoin'e envantere eklendi.");
					System.out.println(" Koruma:" + player.getInv().getArmor()+ " Kalan MC:" + player.getMoney());
				} else
					System.out.println("Opss üst üste giyemezsin :) zaten bir " + aName + "'e sahipsin");
			} 
			else {
				System.out.println(aName + " almak için paran yetersiz. Biraz daha çalýþmalýsýn");
			}
		}

	}

}
