package calculator;

import java.util.List;

public class Calculator {

	private final Expressions expressions;

	public Calculator(List<String> expressions) {
		this.expressions = new Expressions(expressions);
	}
}
