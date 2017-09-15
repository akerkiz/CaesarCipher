import java.util.ArrayList;

public class Encrypt {
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String cipherText;
	private int key;
	
	//this will output generated cipherText
	private ArrayList<String> encryptArray = new ArrayList<String>();
	
	//this will store cipherText, convert to plainText, and then output
	private ArrayList<Decrypt> decryptArray = new ArrayList<Decrypt>(); 
	
	
	//retrieve number key from String input
	public void setNumber(String line){
		int semiColonIndex = line.indexOf(';');
		String tmp = line.substring(0, semiColonIndex);
		int number = Integer.parseInt(tmp);
		this.key = number;
	}
	
	//getter
	public int getKey(){
		return this.key;
	}
	
	//preform encryption and add new ciphertext result to encryptArray
	//as well as add new ciphertext AND key to decryptArray
	//so that we can decrypt it later if the user chooses to
	public void getCipher(String line, int number){
		
		char [] letters = this.convertStringToCharArray(line);
		plainToCipher(letters, this.getKey());
		String result = convertCharArrayToString(letters);
		this.addStringToEncryptArray(result);
		
		//create a Decrypt object, passing in current result & number into constructor
		//that way we know which object has which string/key
		Decrypt cipherString = new Decrypt(result, number);
		this.addCipherToDecryptArray(cipherString);
	}
	//replace ciphertext in decryptArray with plainText
	public void getPlain(){
		char [] letters;
		for(int i=0; i<this.decryptArray.size(); ++i){
			String cipher = this.decryptArray.get(i).getCipherText(); 
			letters = cipher.toCharArray(); 
			
			//run the decryption on ciphertexts using the keys we stored earlier
			cipherToPlain(letters, this.decryptArray.get(i).getKey());
			String result = convertCharArrayToString(letters);
			this.decryptArray.get(i).replaceCipherWithPlain(result); //replace ciphertext w/ plaintext
		}
	}
	//iterate char array and shift letters for encryption
	public void plainToCipher(char [] letters,int number){
		for(int i=0; i<letters.length; ++i){
			if(letters[i] == ' '){
				continue;
			}
			char tmp = letters[i];
			int index = Encrypt.alphabet.indexOf(tmp);
			
			//caesar cipher formula
			index = (index + number) % 26;
			tmp = Encrypt.alphabet.charAt(index);
			letters[i] = tmp;
		}
	}
	//iterate char array and shift letters for decryption
	public void cipherToPlain(char [] letters, int number){
		for(int i=0; i<letters.length; ++i){
			if(letters[i] == ' '){
				continue;
			}
			char tmp = letters[i];
			int index = Encrypt.alphabet.indexOf(tmp);
			
			//reverse caesar cipher
			index = (index - number) % 26;
			/*for some reason, the previous operation isn't producing expected result for negative numbers
			not sure of issue because the operation in method above works just fine.
			I did a quick fix by manually checking the mod result*/
			int modulus = index < 0 ? index+26 : index;
			tmp = Encrypt.alphabet.charAt(modulus);
			letters[i] = tmp;
		}
	}
	
	//parse input; convert to char array
	public char [] convertStringToCharArray(String line){
		int semiColonIndex = line.indexOf(';');
		int startIndex = semiColonIndex + 1;
		char [] letters = line.substring(startIndex, line.length()).toCharArray();
		return letters;
	}
	
	//convert cipher text chars into a string to output result
	public String convertCharArrayToString(char [] array){
		return this.cipherText = new String(array);
	}
	
	//utility methods for encryptArray
	public void addStringToEncryptArray(String line){
		this.encryptArray.add(line);
	}	
	public void printEncryptArray(){
		for(int i=0; i<this.encryptArray.size(); ++i){
			System.out.println(this.encryptArray.get(i));
		}
	}
	
	//utility methods for decryptArray
	public void addCipherToDecryptArray(Decrypt d){
		this.decryptArray.add(d);
	}
	public void printDecryptArray(){
		for(int i=0; i<this.decryptArray.size(); ++i){
			System.out.println(this.decryptArray.get(i).getPlainText());
		}
	}
}
