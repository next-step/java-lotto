package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	Numbers numbers = new Numbers(new Stack<>());
	Signs signs = new Signs(new Stack<>());
	List<String> inputList = new ArrayList<>();

	public int run(String input) {
		validate(input);
		inputList = List.of(input.split(" "));

		pushEachStack();
		calculate();

		return numbers.pop();
	}

	private void validate(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
		}
	}

	private void pushEachStack() {
		for (int i = inputList.size() - 1; i >= 0; i--) {
			pushByCondition(i);
		}
	}

	private void pushByCondition(int i) {
		if (i % 2 == 0) {
			numbers.push(parseInt(inputList.get(i)));
		}
		if (i % 2 != 0) {
			signs.push(new Sign(inputList.get(i)));
		}
	}

	private void calculate() {
		while (numbers.size() > 1) {
			numbers.pushBySign(signs.pop());
		}
	}

	private static int parseInt(String input) {
		return Integer.parseInt(input);
	}
}
