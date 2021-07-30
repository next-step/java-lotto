package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Characters {

	private final List<Character> characters = new ArrayList<>();

	public Characters(String[] characterArray) {
		for (String text : characterArray) {
			Validation.validNumberTypeCheck(text, ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
			Character character = new Character(toInt(text));
			characters.add(character);
		}
	}

	public Characters(Character... characterArray) {
		characters.addAll(Arrays.asList(characterArray));
	}

	public int toInt(String character) {
		return Integer.parseInt(character);
	}

	public int sumCharacters() {
		return characters.stream().mapToInt(Character::getCharacter).sum();
	}
}
