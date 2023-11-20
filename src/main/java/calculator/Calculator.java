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

	private void calculate() {
		for (Sign sign : signs.signs()) {
			if (sign.isPlusSign()) {
				plus();
			}
			if (sign.isMinusSign()) {
				minus();
			}
			if (sign.isMultiplicationSign()) {
				multiplication();
			}
			if (sign.isDivisionSign()) {
				division();
			}
		}
	}

	private void divide(String input) {
		try {
			numbers.add(parseInt(input));
		} catch (NumberFormatException ne) {
			signs.add(new Sign(input));
		}
	}

	private static int parseInt(String input) {
		return Integer.parseInt(input);
	}

	private void plus() {
		result = result + numbers.poll();
	}

	private void minus() {
		result = result - numbers.poll();
	}

	private void multiplication() {
		result = result * numbers.poll();
	}

	private void division() {
		result = result / numbers.poll();
	}
}
