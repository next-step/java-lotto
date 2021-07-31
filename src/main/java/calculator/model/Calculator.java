package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculator {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";
	private static final String DEFAULT_REG_EXP = "[,:]";

	private final Characters characters;

	public Calculator(String calculatorValue) {
		Validation.validStringEmptyCheck(calculatorValue, ErrorMessage.EMPTY_ERROR_MESSAGE);
		characters = new Characters(patternResult(PATTERN_REG_EXP, calculatorValue));
	}

	public List<Character> patternResult(String regExp, String calculatorValue) {
		Matcher matcher = Pattern.compile(regExp).matcher(calculatorValue);
		if (matcher.find()) {
			return initCharacters(matcher.group(2).split(matcher.group(1)));
		}
		return initCharacters(calculatorValue.split(DEFAULT_REG_EXP));
	}

	public int calculate() {
		return characters.getCharacters().stream().mapToInt(Character::getCharacter).sum();
	}

	public List<Character> initCharacters(String[] characterArray) {
		List<Character> initCharacters = new ArrayList<>();
		for (String text : characterArray) {
			Character character = new Character(toInt(text));
			initCharacters.add(character);
		}
		return initCharacters;
	}

	public int toInt(String character) {
		Validation.validNumberTypeCheck(character, ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		return Integer.parseInt(character);
	}

}
