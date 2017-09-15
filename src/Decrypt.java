
public class Decrypt {
	
	private String plainText;
	private String cipherText;
	private int key;
	
	//constructor
	public Decrypt(String line, int number){
		this.cipherText = line;
		this.key = number;
	}
	
	//getters
	public String getCipherText(){
		return this.cipherText;
	}
	public String getPlainText(){
		return this.plainText;
	}
	public int getKey(){
		return this.key;
	}
	
	//remove ciphertext, add plaintext
	public void replaceCipherWithPlain(String result){
		this.cipherText = null;
		this.plainText = result;
	}
}
