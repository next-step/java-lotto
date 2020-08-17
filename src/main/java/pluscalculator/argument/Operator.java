package pluscalculator.argument;

import java.util.function.BinaryOperator;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Operator {
	PLUS("+", (operand1, operand2) -> operand1 + operand2),
	MINUS("-", (operand1, operand2) -> operand1 - operand2),
	MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
	DIVISION("/", (operand1, operand2) -> {
		if (operand2.equals(0)) {
			throw new IllegalArgumentException("0을 제수로 사용할 수는 없습니다.");
		}
		return operand1 / operand2;
	}),
	NONE(StringUtils.EMPTY, (operand1, operand2) -> 0);


	final String sign;
	private BinaryOperator<Integer> performerGetter;

	public int calculate(Integer operand1, Integer operand2) {
		return this.performerGetter.apply(operand1, operand2);
	}

}
