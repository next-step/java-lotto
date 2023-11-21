package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
	private final Numbers numbers = new Numbers(new LinkedList<>());
	private final Signs signs = new Signs(new ArrayList<>());

	public int run(String input) {
		validate(input);
		List<String> inputs = List.of(input.split(" "));

		makeNumbers(inputs);
		makeSigns(inputs);

		return calculate(numbers.poll());
	}

	private void validate(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
		}
	}

	private void makeNumbers(List<String> inputs) {
		for (int i = 0; i < inputs.size(); i += 2) {
			numbers.add(parseInt(inputs.get(i)));
		}
	}

	private int parseInt(String input) {
		return Integer.parseInt(input);
	}

	private void makeSigns(List<String> inputs) {
		for (int i = 1; i < inputs.size(); i += 2) {
			signs.add(Sign.of(inputs.get(i)));
		}
	}

	private int calculate(int result) {
		for (Sign sign : signs.signs()) {
			result = sign.calculate(result, numbers.poll());
		}
		return result;
	}
}
