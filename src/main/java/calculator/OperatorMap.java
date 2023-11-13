package calculator;

import calculator.operator.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {

	private final Map<String, Operator> operator;

	public OperatorMap() {
		this.operator = new HashMap<>();
		this.operator.put("+", new Plus());
		this.operator.put("-", new Minus());
		this.operator.put("*", new Multiply());
		this.operator.put("/", new Divide());
	}

	public Operator operator(String operator) {
		return this.operator.get(operator);
	}
}
