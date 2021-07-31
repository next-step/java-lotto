package calculator.model;

import calculator.utils.CalculatorUtils;
import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculator {

	private final Characters characters;

	public Calculator(String calculatorValue) {
		CalculatorUtils calculatorUtils = new CalculatorUtils(calculatorValue);
		Validation.validStringEmptyCheck(calculatorValue, ErrorMessage.EMPTY_ERROR_MESSAGE);
		characters = new Characters(calculatorUtils.createCharacters());
	}

	public int calculate() {
		return characters.getCharacters().stream().mapToInt(Character::getCharacter).sum();
	}

}
