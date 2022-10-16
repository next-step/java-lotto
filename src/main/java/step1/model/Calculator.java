package step1.model;

import step1.exception.NotFoundOperatorException;
import java.util.Arrays;

public class Calculator {

	private static final int DEFAULT_NUM = 0;
	private static final int GET_ODD_NUM = 2;
	private static final String REGEX = " ";

	public int getResult(String formula) {

		String[] tokens = formula.split(REGEX);
		int result = Integer.parseInt(tokens[DEFAULT_NUM]);

		for (int i = 1; i < tokens.length; i += GET_ODD_NUM) {
			result = calculate(isOperator(tokens[i]), result, Integer.parseInt(tokens[i + 1]));
		}

		return result;
	}

	public String isOperator(String operator) {

		String[] op = new String[]{"+", "-", "*", "/"};

		return Arrays.stream(op)
			.filter(x -> x.equals(operator)).findAny()
			.orElseThrow(() -> new NotFoundOperatorException("연산자가 존재하지 않습니다"));
	}

	private int calculate(String operator, int firstNum, int secondNum) {

		switch (operator) {
			case ("+"):
				return CalculateLogic.PLUS.calculate(firstNum, secondNum);

			case ("-"):
				return CalculateLogic.MINUS.calculate(firstNum, secondNum);

			case ("*"):
				return CalculateLogic.TIMES.calculate(firstNum, secondNum);

			case ("/"):
				return CalculateLogic.DIVIDE.calculate(firstNum, secondNum);

			default:
				return DEFAULT_NUM;
		}
	}
}
