package adventureGame;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player,"Güvenli Ev");
	}

	@Override
	public boolean getLocation() {
		player.setHealty(player.getrhealty());
		System.out.println("Þifacý gerçekten iþi biliyor.Yeniden doðmuþ gibi oldun :D");
		return true;
	}

}
