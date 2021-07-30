package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculation {

	private static final String SPLIT_PARAMETER = ",|:";

	public int notSpecialTextCalculate(String calculatorValue) {
		String[] result = notSpecialSplit(calculatorValue);
		List<String> characters = StringArrayToList(result);
		return calculate(characters);
	}

	public String[] notSpecialSplit(String textValue) {
		return stringToSplit(textValue, SPLIT_PARAMETER);
	}

	public List<String> StringArrayToList(String[] result) {
		List<String> characters = new ArrayList<>();
		Collections.addAll(characters, result);
		return characters;
	}

	public int calculate(List<String> characters) {
		int calculateResult = 0;
		for (String character : characters) {
			Validation.validNumberTypeCheck(character, ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
			calculateResult = calculateReturnValue(calculateResult,character);
		}
		return calculateResult;
	}

	public int calculateReturnValue(int calculateResult, String character) {
		return calculateResult + toInt(character);
	}

	public int toInt(String character) {
		Validation.validPositiveNumber(Integer.parseInt(character),ErrorMessage.NUMBER_POSITIVE_ERROR_MESSAGE);
		return Integer.parseInt(character);
	}

	public String[] stringToSplit(String inputValue, String regexp) {
		return inputValue.split(regexp);
	}

}
