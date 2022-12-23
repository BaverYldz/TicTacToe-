import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] tablo = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printtablo(tablo);
		
		while (true) {
			oyuncusirasi(tablo, scanner);
			if (oyunbittimi(tablo)){
				break;
			}
			printtablo(tablo);
			
			bilgisayarsirasi(tablo);
			if (oyunbittimi(tablo)){
				break;
			}
			printtablo(tablo);
		}
		scanner.close();
	}


	private static boolean oyunbittimi(char[][] tablo) {
		
		if (oyuncukazandimi(tablo, 'X')) {	
			printtablo(tablo);
			System.out.println("Kazandınız!");
			return true;
		}
		
		if (oyuncukazandimi(tablo, 'O')) {	
			printtablo(tablo);
			System.out.println("Kaybettiniz!");
			return true;
		}
		
		for (int i = 0; i < tablo.length; i++) {
			for (int j = 0; j < tablo[i].length; j++) {
				if (tablo[i][j] == ' ') {
					return false;
				}
			}
		}
		printtablo(tablo);
		System.out.println("Oyun berabere bitti!");
		return true;
	}


	private static boolean oyuncukazandimi(char[][] tablo, char sembol) {
		if ((tablo[0][0] == sembol && tablo [0][1] == sembol && tablo [0][2] == sembol) ||
			(tablo[1][0] == sembol && tablo [1][1] == sembol && tablo [1][2] == sembol) ||
			(tablo[2][0] == sembol && tablo [2][1] == sembol && tablo [2][2] == sembol) ||
			
			(tablo[0][0] == sembol && tablo [1][0] == sembol && tablo [2][0] == sembol) ||
			(tablo[0][1] == sembol && tablo [1][1] == sembol && tablo [2][1] == sembol) ||
			(tablo[0][2] == sembol && tablo [1][2] == sembol && tablo [2][2] == sembol) ||
			
			(tablo[0][0] == sembol && tablo [1][1] == sembol && tablo [2][2] == sembol) ||
			(tablo[0][2] == sembol && tablo [1][1] == sembol && tablo [2][0] == sembol) ) {
			return true;
		}
		return false;
	}


	private static void bilgisayarsirasi(char[][] tablo) {
		Random rand = new Random();
		int bilgisayarhamlesi;
		while (true) {
			bilgisayarhamlesi = rand.nextInt(9) + 1;
			if (gecerlihamlemi(tablo, Integer.toString(bilgisayarhamlesi))) {
				break;
			}
		}
		System.out.println("Bilgisayarın tercihi " + bilgisayarhamlesi);
		hamleyeri(tablo, Integer.toString(bilgisayarhamlesi), 'O');
	}


	private static boolean gecerlihamlemi (char[][] tablo, String pozisyon) {
		switch(pozisyon) {
			case "1":
				return (tablo[0][0] == ' ');
			case "2":
				return (tablo[0][1] == ' ');
			case "3":
				return (tablo[0][2] == ' ');
			case "4":
				return (tablo[1][0] == ' ');
			case "5":
				return (tablo[1][1] == ' ');
			case "6":
				return (tablo[1][2] == ' ');
			case "7":
				return (tablo[2][0] == ' ');
			case "8":
				return (tablo[2][1] == ' ');
			case "9":
				return (tablo[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void oyuncusirasi(char[][] tablo, Scanner scanner) {
		String oyuncugirdisi;
		while (true) {
			System.out.println("Hangi kutucuğa hamle yapmak istersiniz? (1-9)");
			oyuncugirdisi = scanner.nextLine();
			if (gecerlihamlemi(tablo, oyuncugirdisi)){
				break;
			} else {
				System.out.println(oyuncugirdisi + " geçerli bir hamle değil.");
			}
		}
		hamleyeri(tablo, oyuncugirdisi, 'X');
	}


	private static void hamleyeri(char[][] tablo, String pozisyon, char sembol) {
		switch(pozisyon) {
			case "1":
				tablo[0][0] = sembol;
				break;
			case "2":
				tablo[0][1] = sembol;
				break;
			case "3":
				tablo[0][2] = sembol;
				break;
			case "4":
				tablo[1][0] = sembol;
				break;
			case "5":
				tablo[1][1] = sembol;
				break;
			case "6":
				tablo[1][2] = sembol;
				break;
			case "7":
				tablo[2][0] = sembol;
				break;
			case "8":
				tablo[2][1] = sembol;
				break;
			case "9":
				tablo[2][2] = sembol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	
	private static void printtablo(char[][] tablo) {
		System.out.println(tablo[0][0] + "|" +  tablo[0][1] + "|" +  tablo[0][2] );
		System.out.println("-+-+-");
		System.out.println(tablo[1][0] + "|" +  tablo[1][1] + "|" +  tablo[1][2] );
		System.out.println("-+-+-");
		System.out.println(tablo[2][0] + "|" +  tablo[2][1] + "|" +  tablo[2][2] );
	}
	
}
  