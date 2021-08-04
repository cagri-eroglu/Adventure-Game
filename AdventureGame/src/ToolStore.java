
public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player,"Maðaza");
		
	}
	
	public boolean getLocation() {
		System.out.println("Para : "+ getPlayer().getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zýrhlar");
		System.out.println("3. Çýkýþ");
		System.out.println("Seçiminiz : ");
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
		System.out.println("3. aðýr  -- para : 40 -- hasar : 5");
		System.out.println("4. Çýkýþ");
		System.out.println("Silah seçiniz : ");
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
			aName = "hafif zýrh";
			price = 15;
			break;
		case 2 :
			avoid = 3;
			aName = "orta zýrh ";
			price = 25;
			break;
		case 3 :
			avoid = 5;
			aName = "aðýr zýrh ";
			price = 40;
			break;
		case 4:
			System.out.println("Çýkýþ yapýlýyor..");
			break;
		default :
			System.out.println("geçersiz iþlem");
			break;

		}
		
		if(price>0) {
			if (player.getMoney()>= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()-price );
				System.out.println(aName+" satýn aldýnýz , engellenen hasar : "+ player.getInv().getArmor());
				System.out.println("Kalan para : " + player.getMoney());
			}else {
				System.out.println("para yetersiz");
			}
		}

	}
	
	public int weaponMenu() {
		System.out.println("1. tabanca  -- para : 5 -- hasar : 2");
		System.out.println("2. kýlýç  -- para : 35 -- hasar : 3");
		System.out.println("3. tüfek  -- para : 45 -- hasar : 7");
		System.out.println("4. Çýkýþ");
		System.out.println("Silah seçiniz : ");
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
			wName = "kýlýç";
			price = 35;
			break;
		case 3 :
			damage = 7;
			wName = "tüfek";
			price = 45;
			break;
		case 4:
			System.out.println("Çýkýþ yapýlýyor..");
			break;
		default :
			System.out.println("geçersiz iþlem");
			break;

		}
		
		if(price>0) {
			if (player.getMoney()>price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()-price );
				System.out.println(wName+" satýn aldýnýz , Önceki hasar : "+ player.getDamage() + " yeni hasar : " 
						+ player.getTotalDamage());
				System.out.println("Kalan para : " + player.getMoney());
			}else {
				System.out.println("para yetersiz");
			}
		}

	}

}
