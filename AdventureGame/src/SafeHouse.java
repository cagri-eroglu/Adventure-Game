
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player,"Güvenli ev");  // name i elle verdik.
	}
	
	public boolean getLocation()
	{
		player.setHealth(player.getrHealth());
		System.out.println("Ýyileþtiniz...");
		System.out.println("Þu an Güvenli Ev adlý yerdesiniz.");
		return true;
	}

}
 