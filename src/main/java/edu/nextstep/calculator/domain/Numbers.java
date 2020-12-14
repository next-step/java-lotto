package edu.nextstep.calculator.domain;

public class Numbers {
	private final Number[] numbers;

	public Numbers(String[] textSplitResult) {
		numbers = new Number[textSplitResult.length];
		for (int i = 0; i < textSplitResult.length; i++) {
			numbers[i] = Number.createFromString(textSplitResult[i]);
		}
	}

	public int sumAll() {
		Number result = Number.createFromInteger(0);
		for (Number number : numbers) {
			result = result.sum(number);
		}
		return result.getValue();
	}
}