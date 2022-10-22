package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import calculator.exception.ErrorMessage;
import calculator.exception.InputNullOrBlankException;
import calculator.exception.OperandNumberFormatException;
import calculator.exception.OperatorInvalidException;

public class ExpressionArguments {
	private static final String BLANK_DELIMITER = " ";
	private final List<Operand> operands;
	private final List<Operator> operators;

	public ExpressionArguments(String expression) throws OperandNumberFormatException, OperatorInvalidException {
		if (isNullOrBlank(expression)) {
			throw new InputNullOrBlankException(ErrorMessage.ILLEGAL_ARGUMENT, expression);
		}
		final List<String> splitedExpressions = splitExpression(expression);

		this.operands = IntStream.range(0, splitedExpressions.size())
			.filter(i -> i % 2 == 0)
			.mapToObj(i -> new Operand(splitedExpressions.get(i)))
			.collect(Collectors.toList());

		this.operators = IntStream.range(0, splitedExpressions.size())
			.filter(i -> i % 2 == 1)
			.mapToObj(i -> Operator.valueOf(splitedExpressions.get(i)))
			.collect(Collectors.toList());
	}

	private boolean isNullOrBlank(String expression) {
		return expression == null || expression.isBlank();
	}

	private List<String> splitExpression(String expression) {
		return Arrays.asList(expression.split(BLANK_DELIMITER));
	}

	public Operand getFirstOperand() {
		return operands.get(0);
	}

	public int getOperatorsSize() {
		return operators.size();
	}

	public Operand getOperand(int index) {
		return operands.get(index);
	}

	public Operator getOperator(int index) {
		return operators.get(index);
	}
}
