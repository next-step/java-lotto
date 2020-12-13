package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumber {
	private final List<Integer> numbers;
	private static final int LOTTO_NUMBERS_SIZE = 6;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	public LottoNumber(List<Integer> numbers) {
		if (!isValidNumbers(numbers)) {
			throw new IllegalArgumentException();
		}
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public int matchCount(LottoNumber matchTargetNumber) {
		return Math.toIntExact(matchTargetNumber.numbers
			.stream()
			.filter(this::isContains)
			.count());
	}

	private boolean isContains(int number) {
		return this.numbers.contains(number);
	}

	private boolean isValidNumbers(List<Integer> numbers) {
		return this.isValidSize(numbers) && this.isValidRange(numbers) && this.isSorted(numbers);
	}

	private boolean isValidSize(List<Integer> numbers) {
		return numbers.size() == LOTTO_NUMBERS_SIZE;
	}

	private boolean isValidRange(List<Integer> numbers) {
		return numbers.stream()
			.allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
	}

	private boolean isSorted(List<Integer> numbers) {
		boolean isValid = true;
		for (int i = 1; i < numbers.size(); i++) {
			isValid = isValid && numbers.get(i) > numbers.get(i-1);
		}
		return isValid;
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}
}
