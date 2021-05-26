package lotto;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;

	private static final Map<Integer, LottoNumber> NUMBER_CACHE
		= IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
			.boxed()
			.collect(toMap(i -> i, LottoNumber::new));

	private final int value;

	public static LottoNumber valueOf(int value) {
		if (NUMBER_CACHE.containsKey(value)) {
			return NUMBER_CACHE.get(value);
		}

		return NUMBER_CACHE.put(value, new LottoNumber(value));
	}

	public static LottoNumber valueOf(String value) {
		return valueOf(Integer.parseInt(value));
	}

	private LottoNumber(int value) {
		validateNumberValue(value);

		this.value = value;
	}

	private static void validateNumberValue(int value) {
		if (value < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < value) {
			throw new IllegalArgumentException("Number must be between 1 and 45");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber number1 = (LottoNumber)o;
		return value == number1.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(LottoNumber number) {
		return Integer.compare(this.value, number.value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
