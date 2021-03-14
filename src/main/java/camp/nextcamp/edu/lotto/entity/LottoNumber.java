package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;
import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static camp.nextcamp.edu.lotto.module.LottoValidator.*;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextcamp.edu.lotto.exception.UserException;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int number;
	private static final Random random = new Random();

	private LottoNumber(int number) {
		this.number = number;
	}

	private static class LottoNumberCache {
		private static final Map<Integer, LottoNumber> numbers;

		static {
			numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
				.boxed()
				.collect(Collectors.toMap(i -> i, LottoNumber::new));
		}
	}

	public static Set<LottoNumber> generateRandomNumber() {
		return random.ints(LOTTO_MIN, LOTTO_MAX)
			.distinct()
			.limit(LOTTO_COUNT)
			.mapToObj(LottoNumber::valueOf)
			.collect(Collectors.toCollection(TreeSet::new));
	}

	public static LottoNumber valueOf(int number) {
		validateNumber(number);
		return LottoNumberCache.numbers.get(number);
	}

	private static void validateNumber(int number) {
		if (!isInRange(number)) {
			throw new UserException(IS_NOT_LOTTO_RANGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return this == that;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int compareTo(LottoNumber otherNumber) {
		return this.number - otherNumber.number;
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}
}
