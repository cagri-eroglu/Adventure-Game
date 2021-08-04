import java.util.Random;

public class Obstacle {
	private String name;
	private int damage,award,health,maxNum;
	public Obstacle(String name, int damage,  int health,int award, int maxNum) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxNum = maxNum;
	}
	
	public int Count()
	{
		Random r = new Random();
		return r.nextInt(this.maxNum)+1;
		
	}
	
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getAward() {
		return award;
	}
	public int getHealth() {
		return health;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDamange(int damage) {
		this.damage = damage;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
	

}
