package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
	static final int LOWEST_NUMBER = 1;
	static final int HIGHEST_NUMBER = 45;
	static final int NUMBER_SIZE = 6;

	private List<Integer> numbers;

	LottoNumber(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;

		if (isInvalidLottoNumbers(numbers)) {
			throw new IllegalArgumentException(String.format("Instantiate LottoNumber failed. " +
					"numbers must be distinct %d numbers range %d~%d : numbers=%s", NUMBER_SIZE, LOWEST_NUMBER, HIGHEST_NUMBER, toString()));
		}
	}

	private boolean isInvalidLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
				.distinct()
				.filter(number -> LOWEST_NUMBER <= number && number <= HIGHEST_NUMBER)
				.count() != NUMBER_SIZE;
	}

	LottoRank matchLottoNumber(LottoNumber winningNumber) {
		int correctNumbers = (int) this.numbers.stream()
				.filter(winningNumber.numbers::contains)
				.count();
		return LottoRank.getFromCorrectNumbers(correctNumbers);
	}

	@Override
	public String toString() {
		return numbers.stream()
				.map(Object::toString)
				.collect(Collectors.joining(",", "[", "]"));
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