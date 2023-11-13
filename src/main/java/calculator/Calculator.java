package calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {

	private final Stack<String> inputs;
	private final OperatorMap map;

	public Calculator(List<String> inputs) {
		map = new OperatorMap();
		this.inputs = new Stack<>();
		for (int i = inputs.size() - 1; i >= 0; i--) {
			this.inputs.push(inputs.get(i));
		}
	}

	public int next() {
		String a = nextElement();
		String operator = nextElement();
		String b = nextElement();

		int result = map.operator(operator).calculate(toInt(a), toInt(b));
		inputs.push(Integer.toString(result));
		return result;
	}

	private String nextElement() {
		return inputs.pop();
	}

	private int toInt(String number) {
		return Integer.parseInt(number);
	}
}
