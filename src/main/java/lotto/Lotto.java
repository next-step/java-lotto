package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_LIMIT_NUMBER = 46;

	private static final int REQUIRED_COUNT = 6;

	private static final String DELIMITER = "\\,";

	private static final List<LottoNumber> lottoNumberPool
		= IntStream.range(LOTTO_MIN_NUMBER, LOTTO_LIMIT_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(toList());

	private final List<LottoNumber> numbers;

	public Lotto() {
		this(randomNumbers());
	}

	public Lotto(String text) {
		this(stringToNumbers(text));
	}

	public Lotto(List<LottoNumber> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
	}

	public Winner winningCheck(Lotto winLotto) {
		return Winner.valueOf(numbers.stream()
				.filter(winLotto.numbers::contains)
				.count());
	}

	private void validateNumbers(List<LottoNumber> numbers) {
		long distinctCount = numbers.stream()
				.distinct()
				.count();

		if (numbers.size() != REQUIRED_COUNT || distinctCount != REQUIRED_COUNT) {
			throw new IllegalArgumentException("Numbers must consist of 6 distinct numbers.");
		}
	}

	private static List<LottoNumber> randomNumbers() {
		Collections.shuffle(lottoNumberPool);
		return lottoNumberPool.stream()
			.limit(REQUIRED_COUNT)
			.sorted()
			.collect(toList());
	}

	private static List<LottoNumber> stringToNumbers(String text) {
		String[] split = text.split(DELIMITER);
		return Stream.of(split)
			.mapToInt(s -> Integer.parseInt(s.trim()))
			.mapToObj(LottoNumber::new)
			.collect(toList());
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
