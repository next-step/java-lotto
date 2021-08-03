package lottoautomatic.domain;

import java.util.*;

public class Lotto {

	public static final int NUMBERS_SIZE_LIMIT = 6;

	private final Set<LottoNumber> numbers;

	public Lotto(Set<LottoNumber> numbers) {
		if (validateSize(numbers.size())) {
			throw new LottoNumbersSizeException();
		}
		this.numbers = numbers;
	}

	private boolean validateSize(int size) {
		return size!= NUMBERS_SIZE_LIMIT;
	}

	public Set<LottoNumber> numbers() {
		return Collections.unmodifiableSet(numbers);
	}

	public int matchingQuantityFrom(List<Integer> lastWeekNumbers) {
		int matchedCount = 0;
		for (Integer lastWeekNumber : lastWeekNumbers) {
			matchedCount += sumMatchedCount(lastWeekNumber);
		}
		return matchedCount;
	}

	private int sumMatchedCount(Integer lastWeekNumber) {
		int matchCount = 0;
		for (LottoNumber number : numbers) {
			matchCount += number.equals(new LottoNumber(lastWeekNumber)) ? 1 : 0;
		}
		return matchCount;
	}

	@Override
	public String toString() {
		return numbers().toString();
	}

}
