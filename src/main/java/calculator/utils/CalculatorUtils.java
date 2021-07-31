package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.model.Character;

public class CalculatorUtils {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";
	private static final String DEFAULT_REG_EXP = "[,:]";

	private final String[] characterArray;

	public CalculatorUtils(String calculatorValue) {
		characterArray = getPatternResult(calculatorValue);
	}

	private String[] getPatternResult(String calculatorValue) {
		Matcher matcher = Pattern.compile(PATTERN_REG_EXP).matcher(calculatorValue);
		if (matcher.find()) {
			return matcher.group(2).split(matcher.group(1));
		}
		return calculatorValue.split(DEFAULT_REG_EXP);
	}

	public List<Character> createCharacters() {
		return Arrays.stream(characterArray)
			.map(text -> new Character(toInt(text)))
			.collect(Collectors.toList());
	}

	public int toInt(String character) {
		Validation.validNumberTypeCheck(character, ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		return Integer.parseInt(character);
	}
}
