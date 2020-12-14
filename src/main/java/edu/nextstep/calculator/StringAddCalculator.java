package edu.nextstep.calculator;

import edu.nextstep.calculator.domain.Numbers;
import edu.nextstep.calculator.domain.Text;

public class StringAddCalculator {
	private static final int NO_ADD_RESULT = 0;

	public static int splitAndSum(String input) {
		Text text = new Text(input);
		if (text.isEmpty()) {
			return NO_ADD_RESULT;
		}
		Numbers numbers = new Numbers(text.split());
		return numbers.sumAll();
	}
}