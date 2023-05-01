package step1.calculator.domain;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

import java.util.stream.Collectors;

public class Operators {
	private final Deque<Operator> operators;

	public Operators(Deque<Operator> operators) {
		this.operators = operators;
	}

	public Deque<Operator> getOperators() {
		return operators;
	}

	public static Operators from(String ...strOperators) throws IllegalArgumentException {
		Deque<Operator> operators = toOperators(strOperators);

		return new Operators(operators);
	}

	private static Deque<Operator> toOperators(String[] strOperators) {
		Deque<Operator> operators = Arrays.stream(strOperators)
			.map(Operator::from)
			.collect(Collectors.toCollection(ArrayDeque::new));

		return operators;
	}

	public void add(Operator operator) {
		operators.add(operator);
	}

	public int operate(Operands operands) {
		while (!operators.isEmpty()) {
			Operator operator = operators.poll();
			Operand leftOperand = operands.poll();
			Operand rightOperand = operands.poll();

			Operand operand = operator.operate(leftOperand, rightOperand);
			operands.addFirst(operand);
		}

		return operands.poll().getOperand();
	}
}
