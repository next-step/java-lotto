package lotto.domain;

import lotto.exception.NumberCountException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final int PICK_COUNT = 6;
	public static final int PRICE = 1000;
	private List<LottoNumber> numbers;

	public Lotto(List<LottoNumber> numbers) {
		checkNumberCount(numbers);
		this.numbers = numbers;
	}

	public Lotto(String number) {
		String[] numbers = number.split(",");
		List<LottoNumber> lastWeekNumber = Arrays.stream(numbers)
				.map(Integer::parseInt)
				.map(LottoNumber::new)
				.collect(Collectors.toList());

		checkNumberCount(lastWeekNumber);
		this.numbers = lastWeekNumber;
	}

	public int askMatchCount(Lotto lastWeekNumbers) {
		int matchCount = 0;
		for (LottoNumber winningNumber : lastWeekNumbers.numbers) {
			matchCount = compareMatchCount(winningNumber, matchCount);
		}
		return matchCount;
	}

	private int compareMatchCount(LottoNumber winningNumber, int matchCount) {
		if (numbers.contains(winningNumber)) {
			++matchCount;
		}
		return matchCount;
	}

	private void checkNumberCount(List<LottoNumber> numbers) {
		if (numbers.size() != PICK_COUNT) {
			throw new NumberCountException();
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}