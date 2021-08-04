
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	BattleLoc(Player player,String name, Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	@Override
	public boolean getLocation() {
		int obsCount = obstacle.Count(); 
		System.out.println("�u an buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol burada  " + obsCount + " tane" + obstacle.getName() + "ya��yor");
		System.out.println("<S>ava� veya <K>a� ");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName()+" b�lgesindeki t�m d��mnlar� temizlediniz");
				if (this.award.equals("Food") && player.getInv().isFood()==false) {
					System.out.println(" Food Kazand�n�z ! ");
					player.getInv().setFood(true);
					}
				else if (this.award.equals("Water") && player.getInv().isWater()==false) {
					System.out.println(" Water Kazand�n�z ! ");
					player.getInv().setWater(true);
				}
				else if (this.award.equals("Firewood") && player.getInv().isFirewood()==false) {
					System.out.println(" Firewood Kazand�n�z ! ");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			if (player.getHealth()<=0) {
				System.out.println("�ld�n�z");
			}			
		}
		return true;
	}
	
	public boolean combat(int obsCount)
	{
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			
			while (player.getHealth()>0 && obstacle.getHealth()>0){
				System.out.println("<V>ur veya <K>a� : ");
				String selCase = scan.next();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("Siz vurdunuz ! ");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());		
					afterHit();
					if (obstacle.getHealth()>0) {
						System.out.println();
						System.out.println("Canavar size vurdu! ");
						player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
						afterHit();
					}
				}
				else {
					return false;
				}
			}
			
			if (obstacle.getHealth()<player.getHealth()) {
				System.out.println("D��man� yendiniz.");
				player.setMoney(player.getMoney()+obstacle.getDamage());
				System.out.println("G�ncel paran�z : "+ player.getMoney());
				obstacle.setHealth(defObsHealth);
			}else {
				return false;  
			}
		} 
		return true;
	}
	
	public void playerStats()
	{
		System.out.println("Oyuncu Bilgileri \n----------");
		System.out.println("Can : " + player.getHealth());
		System.out.println("Hasar : " + player.getTotalDamage());
		System.out.println("Para : " + player.getMoney());
		if (player.getInv().getDamage()>0) {
			System.out.println("Silah : "+ player.getInv().getwName());
		}
		if (player.getInv().getArmor()>0) {
			System.out.println("Armor : "+ player.getInv().getaName());
		}
	}
	
	public void enemyStats()
	{
		System.out.println(obstacle.getName() + " De�erleri\n----------- ");
		System.out.println("Can : " + obstacle.getHealth());
		System.out.println("Hasar : " + obstacle.getDamage());
		System.out.println("Para : " + obstacle.getAward());
	}
	
	public void afterHit()
	{
		System.out.println("Oyuncu can� : " + player.getHealth());
		System.out.println(obstacle.getName()+" Canavar�n can� : " + obstacle.getHealth());
	}
	
}
