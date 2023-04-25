package calculator.domain;

import java.util.ArrayList;
import java.util.List;

import calculator.Calculator;

public class Expression {
	private final List<Integer> numbers = new ArrayList<>();;
	private final List<Calculator> operators = new ArrayList<>();

	public Expression(String[] tokens) {
		for (int i = 0; i < tokens.length; i++) {
			separation(tokens, i);
		}
	}

	private void separation(String[] tokens, int index){
		if (index % 2 == 0) {
			numbers.add(Integer.parseInt(tokens[index]));
			return;
		}

		operators.add(Calculator.from(tokens[index]));
	}

	public int calculate() {
		int result = numbers.get(0);
		for (int i = 0; i < operators.size(); i++) {
			result = operators.get(i).apply(result, numbers.get(i + 1));
		}
		return result;
	}

}
