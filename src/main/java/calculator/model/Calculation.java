package calculator.model;



public class Calculation {

	private final Characters characters;

	public Calculation(String[] inputValue) {
		characters = new Characters(inputValue);
	}

	public Calculation(Characters characters) {
		this.characters = characters;
	}

	public int calculate() {
		return characters.sumCharacters();
	}



}
