import java.util.Scanner;

public class Player {
	private int damage,health,money,rHealth;
	private String name,cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public int getTotalDamage()
	{
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public void selectCha() {
		switch(chaMenu())
		{
		case 1:
			initPlayer("Samuray",5,21,15);
			break;
		
		case 2:
			initPlayer("Ok�u",7,18,20);
			break;
			
		case 3:
			initPlayer("�ovalye",8,25,5);
			break;
		default:
			initPlayer("Samuray",5,21,15);
			break;	
		}
		System.out.println("Karakter :" + getcName() + " \tHasar : " +getDamage() + " sa�l�k : " + getHealth()+ " para:" + getMoney());
	}
	public int chaMenu() {
		System.out.println("L�tfen bir karakter se�iniz : ");
		System.out.println("1- Samuray \t Hasar : 5 \t Sa�l�k : 21 \t Para : 15");
		System.out.println("2- Ok�u \t Hasar : 7 \t Sa�l�k : 18 \t Para : 20");
		System.out.println("3- �ovalye \t Hasar : 8 \t Sa�l�k : 24 \t Para : 5");
		System.out.println("Se�iminiz : ");
		int chaID = scan.nextInt();
		while (chaID <	1 || chaID >3) {
			System.out.println("L�tfen ge�erli bir karakter giriniz : ");
			chaID = scan.nextInt();
		}
		
		return chaID;

	}
	
	public void initPlayer(String cName, int dmg,int hlth,int mny)
	{
		setcName(cName);
		setDamage(dmg);
		setHealth(hlth);
		setMoney(mny);
		setrHealth(hlth);
	}
	
	public int getDamage() {
		return damage;
	}
	public int getHealth() {
		return health;
	}
	public int getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	public String getcName() {
		return cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}	
}
