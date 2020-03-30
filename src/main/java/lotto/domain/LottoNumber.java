package lotto.domain;

import lotto.dto.LottoNumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class LottoNumber {
	public static final int NUMBER_SIZE = 6;

	private List<LottoNo> numbers;

	LottoNumber(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	LottoNumber(List<Integer> numbers) {
		this.numbers =
				Collections.unmodifiableList(numbers
						.stream()
						.map(LottoNo::getInstance)
						.collect(Collectors.toList()));

		if (isInvalidLottoNumbers()) {
			throwIllegalException();
		}
	}

	private void throwIllegalException() {
		throw new IllegalArgumentException(String.format("Instantiate LottoNumber failed. " +
						"numbers must be distinct count %d : numbers=%s",
				NUMBER_SIZE,
				toString()));
	}

	private boolean isInvalidLottoNumbers() {
		return numbers.stream()
				.distinct()
				.count() != NUMBER_SIZE;
	}

	boolean containsNumber(LottoNo bonusNumber) {
		return this.numbers.contains(bonusNumber);
	}

	int countContainsNumbers(LottoNumber lottoNumber) {
		return (int) this.numbers.stream()
				.filter(lottoNumber::containsNumber)
				.count();
	}

	LottoNumbers getLottoNumbers() {
		return new LottoNumbers(numbers.stream()
				.map(LottoNo::getLottoNo)
				.collect(Collectors.toList()));
	}

	@Override
	public String toString() {
		return "LottoNumber{" +
				"numbers=" + numbers +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return numbers.equals(that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}