package lottoautomatic.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

	public static final int NUMBERS_SIZE_LIMIT = 6;
	private final List<Integer> numbers = new ArrayList<>();

	public void generateNumbers(LottoNumberGenerator generator) {
		if (generator.generate().size() != NUMBERS_SIZE_LIMIT) {
			throw new IllegalStateException();
		}
		numbers.addAll(generator.generate());
	}

	public List<Integer> numbers() {
		return Collections.unmodifiableList(numbers);
	}

	public int matchingQuantityFrom(List<Integer> lastWeekNumbers) {
		int matchedCount = 0;
		for (Integer lastWeekNumber : lastWeekNumbers) {
			matchedCount += getMatchedCount(lastWeekNumber);
		}
		return matchedCount;
	}

	private int getMatchedCount(Integer lastWeekNumber) {
		return numbers.contains(lastWeekNumber) ? 1 : 0;
	}

	@Override
	public String toString() {
		return numbers().toString();
	}

}
