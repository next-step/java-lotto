package lottoautomatic.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private final List<Integer> numbers = new ArrayList<>();

	public void generateNumbers(LottoNumberGenerator generator) {
		if (generator.generate().size() != 6) {
			throw new IllegalStateException();
		}
		numbers.addAll(generator.generate());
	}

	public List<Integer> numbers() {
		return numbers;
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
