package lotto.domain;

import lotto.dto.LottoNumbers;
import lotto.utils.StringFormatter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class LottoNumber {
	public static final int LOWEST_NUMBER = 1;
	public static final int HIGHEST_NUMBER = 45;
	public static final int NUMBER_SIZE = 6;

	private List<Integer> numbers;

	LottoNumber(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	LottoNumber(List<Integer> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);

		if (isInvalidLottoNumbers()) {
			throwIllegalException();
		}
	}

	private void throwIllegalException() {
		throw new IllegalArgumentException(String.format("Instantiate LottoNumber failed. " +
						"numbers must be distinct %d numbers range %d~%d : numbers=%s",
				NUMBER_SIZE,
				LOWEST_NUMBER,
				HIGHEST_NUMBER,
				this.toString()));
	}

	private boolean isInvalidLottoNumbers() {
		return numbers.stream()
				.distinct()
				.filter(number -> LOWEST_NUMBER <= number && number <= HIGHEST_NUMBER)
				.count() != NUMBER_SIZE;
	}

	boolean containsNumber(int bonusNumber) {
		return this.numbers.contains(bonusNumber);
	}

	int countContainsNumbers(LottoNumber lottoNumber) {
		return (int) this.numbers.stream()
				.filter(lottoNumber::containsNumber)
				.count();
	}

	LottoNumbers getLottoNumbers() {
		return new LottoNumbers(numbers);
	}

	@Override
	public String toString() {
		return StringFormatter.listToString(numbers);
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