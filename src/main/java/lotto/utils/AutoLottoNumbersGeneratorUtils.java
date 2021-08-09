package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumbersGeneratorUtils {

	private static final int LOTTO_NUMBERS_LENGTH = 6;
	private static final List<Integer> numbers = IntStream.range(1, 46)
														.boxed()
														.collect(Collectors.toList());

	private AutoLottoNumbersGeneratorUtils() {

	}

	public static List<Integer> generateRandomNumbers() {
		Collections.shuffle(numbers);

		return numbers.stream()
			.limit(LOTTO_NUMBERS_LENGTH)
			.sorted()
			.collect(Collectors.toList());
	}
}
