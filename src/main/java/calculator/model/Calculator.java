package calculator.model;

import calculator.utils.CalculatorUtils;

public class Calculator {

	private final Characters characters;

	public Calculator(String calculatorValue) {
		characters = new Characters(CalculatorUtils.createCharacters(calculatorValue));
	}

	public int calculate() {
		return characters.getCharacters().stream().mapToInt(Character::getCharacter).sum();
	}

}
