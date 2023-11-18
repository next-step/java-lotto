package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {
	Stack<Integer> numberStack = new Stack<>();
	Stack<Sign> signStack = new Stack<>();
	List<String> inputList = new ArrayList<>();

	public int run(String input) {
		validate(input);
		inputList = List.of(input.split(" "));

		pushEachStack();
		calculate();

		return numberStack.pop();
	}

	private void validate(String input) {
		if (input == null || input.isBlank()){
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
			numberStack.push(parseInt(inputList.get(i)));
		}
		if (i % 2 != 0) {
			signStack.push(new Sign(inputList.get(i)));
		}
	}

	private void calculate() {
		while (!signStack.isEmpty()) {
			pushNumberStack(signStack.pop());
		}
	}

	private void pushNumberStack(Sign sign) {
		if (sign.isPlusSign()) {
			numberStack.push(numberStack.pop() + numberStack.pop());
		}
		if (sign.isMinusSign()) {
			numberStack.push(numberStack.pop() - numberStack.pop());
		}
		if (sign.isMultiplicationSign()) {
			numberStack.push(numberStack.pop() * numberStack.pop());
		}
		if (sign.isDivisionSign()) {
			numberStack.push(numberStack.pop() / numberStack.pop());
		}
	}

	private static int parseInt(String input) {
		return Integer.parseInt(input);
	}
}
