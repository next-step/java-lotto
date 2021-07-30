package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculation {

	public int calculate(String regexp, String calculatorValue) {
		String[] result = stringToSplit(calculatorValue, regexp);
		List<String> characters = StringArrayToList(result);
		return plusCalculate(characters);
	}

	public String[] stringToSplit(String textValue, String regexp) {
		return textValue.split(regexp);
	}

	public List<String> StringArrayToList(String[] result) {
		List<String> characters = new ArrayList<>();
		Collections.addAll(characters, result);
		return characters;
	}

	public int plusCalculate(List<String> characters) {
		int result = 0;
		for (String character : characters) {
			Validation.validNumberTypeCheck(character, ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
			result = calculateReturnValue(result, character);
		}
		return result;
	}

	public int calculateReturnValue(int calculateResult, String character) {
		return calculateResult + toInt(character);
	}

	public int toInt(String character) {
		Validation.validPositiveNumber(Integer.parseInt(character), ErrorMessage.NUMBER_POSITIVE_ERROR_MESSAGE);
		return Integer.parseInt(character);
	}

}
