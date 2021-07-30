package lottoautomatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private static final int LIMIT_SIZE = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static final List<Integer> defaultNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

	public List<Integer> generate() {
		Collections.shuffle(defaultNumbers);
		return selectNumbers();
	}

	private List<Integer> selectNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LIMIT_SIZE; i++) {
			numbers.add(defaultNumbers.get(i));
		}
		return numbers;
	}

}
