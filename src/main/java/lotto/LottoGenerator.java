package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_LIMIT_NUMBER = 46;

	private static final int REQUIRED_COUNT = 6;

	private static final String DELIMITER = "\\,";

	private static final List<LottoNumber> numberPool
		= IntStream.range(LOTTO_MIN_NUMBER, LOTTO_LIMIT_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(toList());

	public static Lotto randomLotto() {
		Collections.shuffle(numberPool);
		return new Lotto(numberPool.stream()
			.limit(REQUIRED_COUNT)
			.sorted()
			.collect(toList()));
	}

	public static Lotto stringToLotto(String text) {
		String[] split = text.split(DELIMITER);
		return new Lotto(Stream.of(split)
			.mapToInt(s -> Integer.parseInt(s.trim()))
			.mapToObj(LottoNumber::new)
			.collect(toList()));
	}
}
