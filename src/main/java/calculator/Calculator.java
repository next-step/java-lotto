package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
	private final Numbers numbers = new Numbers(new LinkedList<>());
	private final Signs signs = new Signs(new ArrayList<>());

	private List<String> inputs = new ArrayList<>();
	private int result = 0;

	public int run(String input) {
		validate(input);
		inputs = List.of(input.split(" "));

		ready();
		calculate();

		return result;
	}

	private void validate(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
		}
	}

	private void ready() {
		for (String input : inputs) {
			divide(input);
		}
		result = numbers.poll();
	}

	private void divide(String input) {
		try {
			numbers.add(parseInt(input));
		} catch (NumberFormatException ne) {
			signs.add(Sign.of(input));
		}
	}

	private void calculate() {
		for (Sign sign : signs.signs()) {
			result = sign.calculate(result, numbers.poll());
		}
	}

	private static int parseInt(String input) {
		return Integer.parseInt(input);
	}
}
