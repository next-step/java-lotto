package calculator.model;

import java.util.List;

import calculator.utils.RegexComposer;
import calculator.utils.Validation;

public class Calculator {
	
	public Characters createCharacters(String calculatorValue) {
		Validation.validStringEmptyCheck(calculatorValue);
		List<Character> characters = RegexComposer.createCharacters(calculatorValue);
		return new Characters(characters);
	}

	public int calculate(Characters characters) {
		return characters.getCharacters().stream().mapToInt(Character::getCharacter).sum();
	}
}
