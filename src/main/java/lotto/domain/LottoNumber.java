package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
	private List<Integer> numbers;

	LottoNumber(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;

		if (isInvalidLottoNumbers(numbers)) {
			throw new IllegalArgumentException(String.format("Instantiate LottoNumber failed. " +
					"numbers must be distinct 6 numbers range 1~45 : numbers=%s", toString()));
		}
	}

	private boolean isInvalidLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
				.distinct()
				.filter(number -> 0 < number && number < 46)
				.count() != 6;
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