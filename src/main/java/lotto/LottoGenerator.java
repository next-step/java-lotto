package lotto;

import static java.util.stream.Collectors.*;
import static lotto.LottoNumber.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {

	public static final int REQUIRED_COUNT = 6;

	private static final String DELIMITER = "\\,";

	private static final List<LottoNumber> LOTTO_NUMBER_POOL;

	static {
		LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
			.mapToObj(LottoNumber::valueOf)
			.collect(toList());
	}

	public static synchronized Lotto randomNumbers() {
		Collections.shuffle(LOTTO_NUMBER_POOL);
		return new Lotto(LOTTO_NUMBER_POOL.stream()
			.limit(REQUIRED_COUNT)
			.collect(toSet()));
	}

	public static Lotto customNumbers(String text) {
		String[] split = text.split(DELIMITER);
		return new Lotto(Stream.of(split)
			.map(LottoNumber::valueOf)
			.collect(toSet()));
	}
}
