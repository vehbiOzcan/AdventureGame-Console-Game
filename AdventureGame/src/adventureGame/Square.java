package adventureGame;

public class Square extends NormalLoc {

	Square(Player player) {
		super(player, "Meydan");
	}
	
	public boolean getLocation(){
		System.out.println();
		System.out.println("�uan meydandas�n"); 
		System.out.println();
		return true;
	}
}
