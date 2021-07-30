package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculator {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";
	private static final String DEFAULT_REG_EXP = ",|:";

	private final String calculatorValue;
	private final Calculation calculation;

	private Calculator(String calculatorValue) {
		this.calculatorValue = calculatorValue;
		calculation = new Calculation();
	}

	public static Calculator createCalculator(String calculatorValue) {
		Validation.validStringEmptyCheck(calculatorValue, ErrorMessage.EMPTY_ERROR_MESSAGE);
		return new Calculator(calculatorValue);
	}

	public int calculate() {
		Matcher matcher = Pattern.compile(PATTERN_REG_EXP).matcher(calculatorValue);
		if (matcher.find()) {
			return calculation.calculate(matcher.group(1), matcher.group(2));
		}
		return calculation.calculate(DEFAULT_REG_EXP, calculatorValue);
	}

}
