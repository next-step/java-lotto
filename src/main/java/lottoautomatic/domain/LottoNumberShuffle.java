package lottoautomatic.domain;

import java.util.*;

public class LottoNumberShuffle implements LottoNumberGenerator {

	private static final int NUMBERS_RANGE_START = 0;
	private static final int NUMBERS_RANGE_END = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static final List<Integer> defaultNumbers = new ArrayList<>();

	static {
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			defaultNumbers.add(i);
		}
	}

	@Override
	public Set<LottoNumber> generate() {
		Collections.shuffle(defaultNumbers);
		return selectNumbers();
	}

	private Set<LottoNumber> selectNumbers() {
		Set<LottoNumber> numbers = new TreeSet<>();
		for (int i = NUMBERS_RANGE_START; i < NUMBERS_RANGE_END; i++) {
			numbers.add(new LottoNumber(defaultNumbers.get(i)));
		}
		return numbers;
	}

}
