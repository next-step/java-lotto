package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {

	private final Deque<String> inputs;
	private final OperatorMap map;

	public Calculator(List<String> inputs) {
		if (validation(inputs)) {
			throw new IllegalArgumentException();
		}
		map = new OperatorMap();
		this.inputs = new ArrayDeque<>();
		for (String input : inputs) {
			this.inputs.offer(input);
		}
	}

	private boolean validation(List<String> inputs) {
		return isEmpty(inputs) || isOperator(inputs);
	}

	private boolean isEmpty(List<String> inputs) {
		return inputs == null || inputs.isEmpty() || inputs.contains(" ");
	}

	private boolean isOperator(List<String> inputs) {
		return !(inputs.contains("+") || inputs.contains("-") || inputs.contains("*") || inputs.contains("/"));
	}

	public int result() {
		while (inputs.size() != 1) {
			next();
		}
		return toInt(inputs.pop());
	}

	private void next() {
		String a = inputs.pop();
		String operator = inputs.pop();
		String b = inputs.pop();

		inputs.offerFirst(Integer.toString(map.operator(operator).calculate(toInt(a), toInt(b))));
	}

	private int toInt(String number) {
		return Integer.parseInt(number);
	}
}
