import java.io.*;

public class CaesarCipher {
	
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {	
		try{
			InputStream plainText = new FileInputStream("src/plain.txt");
			BufferedReader read = new BufferedReader(new InputStreamReader(plainText));
			
			String line = null;
			Encrypt b = new Encrypt();
			
			while((line = read.readLine()) != null){
				if(line.equals("exit")){
					break;
				}
				
				b.setNumber(line);
				b.getCipher(line, b.getNumber());
				
			}
			b.printArrayList();
			b.printCipherArrayList();
			
		} 
		catch(Exception e){
			System.err.println("Error: Target File Cannot Be Read");
		}	
	}

}
