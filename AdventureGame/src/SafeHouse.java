
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player,"G�venli ev");  // name i elle verdik.
	}
	
	public boolean getLocation()
	{
		player.setHealth(player.getrHealth());
		System.out.println("�yile�tiniz...");
		System.out.println("�u an G�venli Ev adl� yerdesiniz.");
		return true;
	}

}
 