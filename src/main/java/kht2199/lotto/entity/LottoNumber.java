package kht2199.lotto.entity;

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

	public static Lotto valuesOf(int ...values) throws LottoNumberRangeException, LottoNumberLengthException {
		return valuesOf(true, values);
	}

	public static Lotto valuesOf(boolean auto, int ...values) throws LottoNumberRangeException, LottoNumberLengthException {
		for (int value : values) {
			validateRange(value);
		}
		return new Lotto(Arrays.stream(values)
			.mapToObj(cache::get)
			.collect(toList()),
			auto
		);
	}

	public static Lotto valuesOf(List<Integer> values, boolean auto) throws
			LottoNumberRangeException,
			LottoNumberLengthException {
		for (Integer value : values) {
			validateRange(value);
		}
		return new Lotto(values.stream()
			.map(cache::get)
			.collect(toList()),
			auto
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

	public int value() {
		return this.number;
	}
}
