package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculator {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";
	private static final String DEFAULT_REG_EXP = ",|:";

	private final Calculation calculation;

	private Calculator(String calculatorValue) {
		calculation = new Calculation(patternResult(PATTERN_REG_EXP,calculatorValue));
	}

	public String[] patternResult(String regExp, String calculatorValue) {
		Matcher matcher = Pattern.compile(regExp).matcher(calculatorValue);
		if (matcher.find()) {
			return stringToSplit(matcher.group(1),matcher.group(2));
		}
		return stringToSplit(DEFAULT_REG_EXP,calculatorValue);
	}

	public static Calculator createCalculator(String calculatorValue) {
		Validation.validStringEmptyCheck(calculatorValue, ErrorMessage.EMPTY_ERROR_MESSAGE);
		return new Calculator(calculatorValue);
	}

	public int calculate() {
		return calculation.calculate();
	}

	public String[] stringToSplit(String regexp, String textValue) {
		return textValue.split(regexp);
	}

}
