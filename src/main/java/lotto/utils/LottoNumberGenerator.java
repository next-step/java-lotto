package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoNumberGenerator {

	private static final List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
			.boxed()
			.collect(Collectors.toList());

	public static List<Integer> pick() {
		Collections.shuffle(numbers);
		return numbers.stream()
				.limit(Lotto.NUMBER_COUNT)
				.collect(Collectors.toList());
	}

	public static List<Integer> parse(String number) {
		return Arrays.stream(number.split("[\\s,]+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}
}
