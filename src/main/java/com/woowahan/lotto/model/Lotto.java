package com.woowahan.lotto.model;

import java.util.List;

import com.woowahan.lotto.constant.Message;

public class Lotto {
	public static final int LOTTO_START_NUMBER = 1;
	public static final int LOTTO_END_NUMBER = 45;
	public static final int LOTTO_NUMBER_LENGTH = 6;

	private final List<Integer> numbers;

	private Lotto(List<Integer> numbers) {
		validateParameter(numbers);
		this.numbers = numbers;
	}

	private void validateParameter(List<Integer> numbers) {
		if (!validateLength(numbers)) {
			throw new IllegalArgumentException(Message.MSG_ERROR_LOTTO_NUMBER);
		}
		if (!validateNumbers(numbers)) {
			throw new IllegalArgumentException(Message.MSG_ERROR_LOTTO_NUMBER);
		}
	}

	private boolean validateLength(List<Integer> numbers) {
		return numbers != null && numbers.size() == LOTTO_NUMBER_LENGTH;
	}

	public static Lotto of(List<Integer> numbers) {
		return new Lotto(numbers);
	}

	private boolean validateNumbers(List<Integer> numbers) {
		return numbers.stream()
			.allMatch(num -> num >= LOTTO_START_NUMBER && num <= LOTTO_END_NUMBER);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
