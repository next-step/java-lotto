package calculator.model;

import calculator.utils.Validation;

public class Character {

	private final int character;

	public Character(int character) {
		Validation.validPositiveNumber(character);
		this.character = character;
	}

	public int getCharacter() {
		return character;
	}

}
