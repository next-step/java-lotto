package lotto;

import static java.util.stream.Collectors.*;
import static lotto.LottoNumber.*;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {

	private static final int REQUIRED_COUNT = 6;

	private static final String DELIMITER = "\\,";

	private static final List<LottoNumber> lottoNumberPool
		= IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
			.mapToObj(LottoNumber::valueOf)
			.collect(toList());

	private final TreeSet<LottoNumber> numbers;

	public Lotto() {
		this(randomNumbers());
	}

	public Lotto(String text) {
		this(stringToNumbers(text));
	}

	public Lotto(TreeSet<LottoNumber> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
	}

	public Winner winningCheck(Lotto winLotto) {
		return Winner.valueOf(numbers.stream()
				.filter(winLotto.numbers::contains)
				.count());
	}

	private static void validateNumbers(TreeSet<LottoNumber> numbers) {
		if (numbers.size() != REQUIRED_COUNT) {
			throw new InvalidNumberSetException("Lotto requires only 6 unique numbers.");
		}
	}

	private static TreeSet<LottoNumber> randomNumbers() {
		Collections.shuffle(lottoNumberPool);
		return lottoNumberPool.stream()
			.limit(REQUIRED_COUNT)
			.collect(toCollection(TreeSet::new));
	}

	private static TreeSet<LottoNumber> stringToNumbers(String text) {
		String[] split = text.split(DELIMITER);
		return Stream.of(split)
			.map(String::trim)
			.map(LottoNumber::valueOf)
			.collect(toCollection(TreeSet::new));
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}
}
