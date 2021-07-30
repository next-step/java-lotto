package lottoautomatic;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private static final List<Integer> NUMBERS = new ArrayList<>();
	public Lotto() {
	}

	public void generateNumbers(LottoNumberGenerator generator) {
		if (generator.generate().size() != 6) {
			throw new IllegalStateException();
		}
		NUMBERS.addAll(generator.generate());
	}

	public List<Integer> numbers() {
		return NUMBERS;
	}


	public int match(List<Integer> lastWeekNumbers) {
		int matchedNumber = 0;
		for (Integer lastWeekNumber : lastWeekNumbers) {
			matchedNumber += sameNumber(matchedNumber, lastWeekNumber);
		}
		return matchedNumber;
	}

	private int sameNumber(int matchedNumber, Integer lastWeekNumber) {
		return NUMBERS.contains(lastWeekNumber) ? 1 : 0;
	}

}
