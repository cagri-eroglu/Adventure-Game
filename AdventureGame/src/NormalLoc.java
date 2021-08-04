
public abstract class NormalLoc extends Location {

	NormalLoc(Player player,String name) {
		super(player);
		this.name = name; // this.name Locationdaki name aslýnda.
		
	}

	@Override
	public boolean getLocation() {
		
		return true;
	}
	
}
