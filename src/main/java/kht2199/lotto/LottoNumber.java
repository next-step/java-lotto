package kht2199.lotto;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

public class LottoNumber {

	private static final Map<Integer, LottoNumber> cache;

	static {
		cache = IntStream.range(1, 46).boxed()
			.collect(toMap(v -> v, LottoNumber::new));
	}

	private final int number;

	private LottoNumber(int value) {
		this.number = value;
	}

	public static LottoNumber valueOf(int value) throws LottoNumberRangeException {
		validateRange(value);
		return cache.get(value);
	}

	public static LottoNumber valueOf(String value) throws NumberFormatException, LottoNumberRangeException {
		return valueOf(Integer.parseInt(value));
	}

	public static LottoNumbers valuesOf(int ...values) throws LottoNumberRangeException, LottoNumberLengthException {
		for (int value : values) {
			validateRange(value);
		}
		return new LottoNumbers(Arrays.stream(values)
			.mapToObj(cache::get)
			.collect(toList())
		);
	}

	public static LottoNumbers valuesOf(List<Integer> values) throws
			LottoNumberRangeException,
			LottoNumberLengthException {
		for (Integer value : values) {
			validateRange(value);
		}
		return new LottoNumbers(values.stream()
			.map(cache::get)
			.collect(toList())
		);
	}

	private static void validateRange(int value) throws LottoNumberRangeException {
		if (value < 0 || value > 46) {
			throw new LottoNumberRangeException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public char value() {
		return (char) this.number;
	}
}
