
public class Decrypt {

	private String cipherText;
	private int key;
	
	//constructor
	public Decrypt(String line, int number){
		this.cipherText = line;
		this.key = number;
	}
	
	public String getCipherText(){
		return this.cipherText;
	}
}
