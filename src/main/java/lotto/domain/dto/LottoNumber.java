package lotto.domain.dto;

import lotto.utils.StringFormatter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
	public static final int LOWEST_NUMBER = 1;
	public static final int HIGHEST_NUMBER = 45;
	public static final int NUMBER_SIZE = 6;

	private List<Integer> numbers;

	LottoNumber(Integer... numbers) {
		this(Arrays.asList(numbers));
	}

	public LottoNumber(List<Integer> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);

		if (isInvalidLottoNumbers(numbers)) {
			throwIllegalException(numbers);
		}
	}

	private void throwIllegalException(List<Integer> numbers) {
		throw new IllegalArgumentException(String.format("Instantiate LottoNumber failed. " +
						"numbers must be distinct %d numbers range %d~%d : numbers=%s",
				NUMBER_SIZE,
				LOWEST_NUMBER,
				HIGHEST_NUMBER,
				StringFormatter.listToString(numbers)));
	}

	private boolean isInvalidLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
				.distinct()
				.filter(number -> LOWEST_NUMBER <= number && number <= HIGHEST_NUMBER)
				.count() != NUMBER_SIZE;
	}

	public LottoRank matchLottoNumber(LottoWinningNumber winningNumber) {
		int correctNumbers = getMatchElectedNumberCount(winningNumber);
		boolean matchBonus = this.numbers.contains(winningNumber.getBonusNumber());
		return LottoRank.getFromCorrectNumbers(correctNumbers, matchBonus);
	}

	private int getMatchElectedNumberCount(LottoWinningNumber winningNumber) {
		return (int) this.numbers.stream()
				.filter(winningNumber.getNumbers()::contains)
				.count();
	}

	public List<Integer> getNumbers() {
		return numbers;
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