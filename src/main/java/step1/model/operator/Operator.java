package step1.model.operator;

import java.util.List;

import step1.exception.BadRequestException;
import step1.model.number.Number;

public class Operator {
	private static final List<String> OPERATORS = List.of(new String[] {"+", "-", "*", "/"});
	private final String operator;

	public Operator(String operator) {
		checkOperator(operator);
		this.operator = operator;
	}

	public void checkOperator(String operator) {
		if (OPERATORS.contains(operator)) {
			return;
		}
		throw new BadRequestException("연산자로 변환가능한 문자열이 아닙니다.");
	}

	public void operate(int a, Number number) {
		switch (this.operator) {
			case "+":
				number.plus(a);
				return;
			case "-":
				number.minus(a);
				return;
			case "*":
				number.multiply(a);
				return;
			case "/":
				number.divide(a);
		}
	}
}
