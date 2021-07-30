package lottoautomatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberShuffle implements LottoNumberGenerator {

	private static final int NUMBERS_RANGE_START = 0;
	private static final int NUMBERS_RANGE_END = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final List<Integer> defaultNumbers = initDefaultNumbers();

	private static List<Integer> initDefaultNumbers() {
		List<Integer> defaultNumbers = new ArrayList<>();
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			defaultNumbers.add(i);
		}
		return defaultNumbers;
	}

	@Override
	public List<Integer> generate() {
		Collections.shuffle(defaultNumbers);
		return selectNumbers();
	}

	private List<Integer> selectNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = NUMBERS_RANGE_START; i < NUMBERS_RANGE_END; i++) {
			numbers.add(defaultNumbers.get(i));
		}
		return sortNumbers(numbers);
	}

	private List<Integer> sortNumbers(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}


}
