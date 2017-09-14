import java.util.ArrayList;

public class Encrypt {
	
	private String plainText;
	private String cipherText;
	private ArrayList<String> array = new ArrayList<String>();
	private ArrayList<Decrypt> cipherArray = new ArrayList<Decrypt>(); 
	private int number;
	
	//utility methods to build cipher text
	
	//retrieve shift number from String input
	//setter
	public void setNumber(String line){
		int semiColonIndex = line.indexOf(';');
		String tmp = line.substring(0, semiColonIndex);
		int number = Integer.parseInt(tmp);
		
		this.number = number;
	}
	
	//getter
	public int getNumber(){
		return this.number;
	}
	
	//convert pure input string to char array
	//use for loop to swap original letters for their new shifted letters
	public void getCipher(String line, int number){
		
		char [] letters = this.convertStringToCharArray(line);
		plainToCipher(letters, this.getNumber());
		String result = convertCharArrayToString(letters);
		
		//create a Decrypt object, and store in an arrayList
		//so that we can access this List when user chooses to decrypt
		Decrypt cipherString = new Decrypt(result, number);
		this.addCipherToArrayList(cipherString);
		
		
		this.addStringtoArrayList(result);
	}
	
	public void getPlain(int number){
		char [] letters;
		for(int i=0; i<this.array.size(); ++i){
			this.plainText = this.array.get(i);
			letters = this.plainText.toCharArray();
		}
	}
	
	public void plainToCipher(char [] letters,int number){
		for(int i=0; i<letters.length; ++i){
			if(letters[i] == ' '){
				continue;
			}
			char tmp = letters[i];
			int index = CaesarCipher.alphabet.indexOf(tmp);
			
			//caesar cipher formula
			index = (index + number) % 26;
			tmp = CaesarCipher.alphabet.charAt(index);
			letters[i] = tmp;
		}
	}
	public void cipherToPlain(char [] letters, int number){
		
	}
	
	//extract pure plain text as well as ciphertext(for decryption); convert to char array
	public char [] convertStringToCharArray(String line){
		//plaintext
		int semiColonIndex = line.indexOf(';');
		int startIndex = semiColonIndex + 1;
		char [] letters = line.substring(startIndex, line.length()).toCharArray();
		return letters;
	}
	
	//convert cipher text chars into a string to output result
	public String convertCharArrayToString(char [] array){
		return this.cipherText = new String(array);
	}
	
	//the purpose of this arrayList is to hold all of our ciphertext strings
	//so that if user chooses to decrypt strings
	//then all of these strings will be convereted back to plaintext
	//and the plaintext strings will permanently replace the ciphertext
	//
	public void addStringtoArrayList(String line){
		this.array.add(line);
	}
	public void addCipherToArrayList(Decrypt d){
		this.cipherArray.add(d);
	}
	
	public void printArrayList(){
		for(int i=0; i<this.array.size(); ++i){
			System.out.println(this.array.get(i));
		}
	}
	
	//temporary
	public void printCipherArrayList(){
		for(int i=0; i<this.cipherArray.size(); ++i){
			System.out.println(this.cipherArray.get(i).getCipherText());
		}
	}
}
