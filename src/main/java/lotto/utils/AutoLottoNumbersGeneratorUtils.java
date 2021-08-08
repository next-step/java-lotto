package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumbersGeneratorUtils {

	private static final List<Integer> numbers = IntStream.range(1, 46)
														.boxed()
														.collect(Collectors.toList());

	private AutoLottoNumbersGeneratorUtils() {

	}

	public static List<Integer> generateRandomNumbers(int size) {
		Collections.shuffle(numbers);

		return numbers.stream()
			.limit(size)
			.sorted()
			.collect(Collectors.toList());
	}
}
