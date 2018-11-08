package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoNumberGenerator {

	private List<Integer> numbers;

	public LottoNumberGenerator() {
		this.numbers = createNumbers();
	}

	private List<Integer> createNumbers() {
		return IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public List<Integer> pick() {
		Collections.shuffle(numbers);
		return numbers.stream()
				.limit(Lotto.NUMBER_COUNT)
				.collect(Collectors.toList());
	}

	public List<Integer> pick(String number) {
		return parseNumber(number);
	}

	private List<Integer> parseNumber(String number) {
		return Arrays.stream(number.split("[\\s,]+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

}
