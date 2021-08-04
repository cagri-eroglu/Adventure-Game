import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	public void login()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("MACERA OYUNUNA HO�GELD�N�Z");
		//System.out.println("Oyuna ba�lamadan �nce isminizi giriniz : ");
		//String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCha();
		start();
		
		
		
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("==================================");
			System.out.println();
			System.out.println("Eylem ger�ekle�irmek i�in bir yer se�iniz : ");
			System.out.println("1- G�venli ev : Size ait g�venli bir mekan, d��man yok . ");
			System.out.println("2- Ma�ara : Kar��n�za zombi ��kabilir.");
			System.out.println("3- Orman : Kar��n�za vampir ��kabilir.");
			System.out.println("4- Nehir : Kar��n�za ay� ��kabilir.");
			System.out.println("5 -Ma�aza : Silah ve Z�rh alabilirsiniz.");
			System.out.print("Gitmek istedi�iniz yer : ");
			int selLoc = scan.nextInt();
			while (selLoc<0||selLoc>5) {
				System.out.println("L�tfen ge�erli bir mekan se�iniz : ");
				selLoc = scan.nextInt();
			}
			
			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2 :
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4 :
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
				break;
			}
			
			if (location.getClass().getName().equals("SafeHouse")) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("tebrikler oyunu kazand�n�z.");
					break;
				}
			}
			
			if (!location.getLocation()) {
				System.out.println("Oyun bitti");
				break;
			}
		}
	}
}
