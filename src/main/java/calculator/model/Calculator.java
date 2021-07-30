package calculator.model;

import calculator.utils.ErrorMessage;
import calculator.utils.Validation;

public class Calculator {

	private static final String PARALLEL_TEXT = "//";
	private static final String NEW_LINE_TEXT = "\n";

	private boolean SPECIAL_TEXT_EXIST = false;

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

	public boolean getSpecialTextExist(String specialText) {
		return calculatorValue.contains(specialText);
	}

	public boolean getAllSpecialTextExist() {
		if (getSpecialTextExist(PARALLEL_TEXT) && getSpecialTextExist(NEW_LINE_TEXT)) {
			SPECIAL_TEXT_EXIST = true;
		}
		return SPECIAL_TEXT_EXIST;
	}

	public int calculate() {
		boolean specialTextExist = getAllSpecialTextExist();
		if(specialTextExist){
			return notSpecialTextCalculate();
		}
		return specialTextCalculate();
	}

	private int notSpecialTextCalculate() {
		return calculation.notSpecialTextCalculate(calculatorValue);
	}

	private int specialTextCalculate() {
		return 0;
	}


}
