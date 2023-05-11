package step1.calculator.domain.operator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class OperatorFactory {
	public static final String NOT_OPERATOR_MESSAGE = "사칙연산 기호가 아닙니다.";

	private static final List<Operator> OPERATORS = List.of(
		AdditionOperator.create(),
		SubtractionOperator.create(),
		MultiplicationOperator.create(),
		DivisionOperator.create()
	);

	public static boolean isOperator(String operator) {
		return OPERATORS.stream()
			.anyMatch(o -> o.isSameSymbol(operator));
	}

	public static Operator create(String symbol) {
		Operator operator = OPERATORS.stream()
			.filter(o -> o.isSameSymbol(symbol))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_OPERATOR_MESSAGE + ": " + symbol));

		return operator;
	}
}
