import java.io.*;
import java.util.Scanner;

//plain.txt is located in src
//plain.txt contains original input (from canvas)

public class CaesarCipher {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to Little Caesars! (no we dont serve pizza)");
		System.out.println("Choose a number from the following options:");
		System.out.println("1) Run Encryption/Decryption (plain.txt required in /src)");
		System.out.println("9) Exit");
		
		
		while(true){
			int choice = keyboard.nextInt();
			switch(choice){
				case 1:
					try{
						InputStream plainText = new FileInputStream("src/plain.txt");
						BufferedReader read = new BufferedReader(new InputStreamReader(plainText));
						
						String line = null;
						Encrypt e = new Encrypt();
						
						while((line = read.readLine()) != null){
							if(line.equals("exit")){
								break;
							}
							e.setNumber(line);
							e.getCipher(line, e.getKey());
						}
						
						read.close();
						System.out.println("---ENCRYPTION---");
						e.printEncryptArray();
					
						System.out.println("---Encryption has successfully terminated---");
						System.out.println("\n");
						
						
						e.getPlain();
						System.out.println("---DECRYPTION---");
						e.printDecryptArray();
						System.out.println("---Decryption has successfully terminated---");
						System.out.println();
						
					} 
					catch(Exception e){
						System.err.println("Error: Target File Cannot Be Read");
					}
					
					System.out.println("Choose a number from the following options:");
					System.out.println("1) Run Encryption/Decryption (plain.txt required in /src)");
					System.out.println("9) Exit");
					
				break;
			case 9:
				System.out.println("SYSTEM TERMINATED");
				System.exit(0);
			default:
				System.out.println("***Invalid choice***");
				System.out.println("Choose a number from the following options:");
				System.out.println("1) Run Encryption/Decryption (plain.txt required)");
				System.out.println("9) Exit");
			}
		}			
	}
}
