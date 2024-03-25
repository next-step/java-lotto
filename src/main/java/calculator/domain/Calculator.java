package calculator.domain;

public class Calculator {
	public int calculate(String[] input) {
		Number number = new Number(input[0]);

		for(int i = 1; i < input.length - 1; i = i + 2) {
			number = Operator.getOperatorByStr(input[i])
					.calculate(number, new Number(input[i + 1]));
		}

		return number.getNumber();
	}
}
