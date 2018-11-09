package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoNumberGenerator {

	private static final List<Integer> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.boxed()
			.collect(Collectors.toList());

	public static List<LottoNumber> pick() {
		Collections.shuffle(numbers);
		return numbers.stream()
				.map(LottoNumber::new)
				.limit(Lotto.NUMBER_COUNT)
				.collect(Collectors.toList());
	}

	public static List<LottoNumber> parse(String number) {
		return Arrays.stream(number.split("[\\s,]+"))
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}
}
