package calculator.model;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Character {

	private final int character;

	public Character(int character) {
		Validation.validPositiveNumber(character, ErrorMessage.NUMBER_POSITIVE_ERROR_MESSAGE);
		this.character = character;
	}

	public int getCharacter(){
		return character;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Character character1 = (Character)o;
		return getCharacter() == character1.getCharacter();
	}

}
