
public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player,"Ma�aza");
		
	}
	
	public boolean getLocation() {
		System.out.println("Para : "+ getPlayer().getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.println("Se�iminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2 :
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
			
		default:
			break;
		}
		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. hafif  -- para : 15 -- hasar : 1");
		System.out.println("2. orta  -- para : 25 -- hasar : 3");
		System.out.println("3. a��r  -- para : 40 -- hasar : 5");
		System.out.println("4. ��k��");
		System.out.println("Silah se�iniz : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID)
	{
		int avoid = 0,price = 0;
		String aName =null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "hafif z�rh";
			price = 15;
			break;
		case 2 :
			avoid = 3;
			aName = "orta z�rh ";
			price = 25;
			break;
		case 3 :
			avoid = 5;
			aName = "a��r z�rh ";
			price = 40;
			break;
		case 4:
			System.out.println("��k�� yap�l�yor..");
			break;
		default :
			System.out.println("ge�ersiz i�lem");
			break;

		}
		
		if(price>0) {
			if (player.getMoney()>= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()-price );
				System.out.println(aName+" sat�n ald�n�z , engellenen hasar : "+ player.getInv().getArmor());
				System.out.println("Kalan para : " + player.getMoney());
			}else {
				System.out.println("para yetersiz");
			}
		}

	}
	
	public int weaponMenu() {
		System.out.println("1. tabanca  -- para : 5 -- hasar : 2");
		System.out.println("2. k�l��  -- para : 35 -- hasar : 3");
		System.out.println("3. t�fek  -- para : 45 -- hasar : 7");
		System.out.println("4. ��k��");
		System.out.println("Silah se�iniz : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}
	
	public void buyWeapon(int itemID)
	{
		int damage = 0,price = 0;
		String wName =null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "tabanca";
			price = 5;
			break;
		case 2 :
			damage = 3;
			wName = "k�l��";
			price = 35;
			break;
		case 3 :
			damage = 7;
			wName = "t�fek";
			price = 45;
			break;
		case 4:
			System.out.println("��k�� yap�l�yor..");
			break;
		default :
			System.out.println("ge�ersiz i�lem");
			break;

		}
		
		if(price>0) {
			if (player.getMoney()>price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()-price );
				System.out.println(wName+" sat�n ald�n�z , �nceki hasar : "+ player.getDamage() + " yeni hasar : " 
						+ player.getTotalDamage());
				System.out.println("Kalan para : " + player.getMoney());
			}else {
				System.out.println("para yetersiz");
			}
		}

	}

}
