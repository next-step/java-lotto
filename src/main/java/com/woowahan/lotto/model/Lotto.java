package com.woowahan.lotto.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.lotto.constant.Message;

public class Lotto {
	public static final int LOTTO_NUMBER_LENGTH = 6;
	public static final int LOTTO_PRICE = 1000;

	private final List<LottoNo> numbers;

	private Lotto(List<LottoNo> numbers) {
		validateParameter(numbers);
		this.numbers = numbers.stream()
			.sorted(Comparator.comparing(LottoNo::getNumber))
			.collect(Collectors.toList());
	}

	private void validateParameter(List<LottoNo> numbers) {
		if (!validateLength(numbers)) {
			throw new IllegalArgumentException(Message.MSG_ERROR_LOTTO_NUMBER);
		}
	}

	private boolean validateLength(List<LottoNo> numbers) {
		return numbers != null && numbers.size() == LOTTO_NUMBER_LENGTH;
	}

	public static Lotto of(List<LottoNo> numbers) {
		return new Lotto(numbers);
	}

	public static Lotto of(LottoGenerator lottoGenerator) {
		return new Lotto(lottoGenerator.generate());
	}

	public List<LottoNo> getNumbers() {
		return numbers;
	}
}
