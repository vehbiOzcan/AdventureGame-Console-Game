package adventureGame;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player,"G�venli Ev");
	}

	@Override
	public boolean getLocation() {
		player.setHealty(player.getrhealty());
		System.out.println("�ifac� ger�ekten i�i biliyor.Yeniden do�mu� gibi oldun :D");
		return true;
	}

}
