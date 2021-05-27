package lotto;

import static java.lang.Integer.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 45;

	private static final Map<Integer, LottoNumber> NUMBER_CACHE = new HashMap<>();

	private final int value;

	private LottoNumber(int value) {
		validateNumberValue(value);

		this.value = value;
	}

	private static void validateNumberValue(int value) {
		if (value < MIN_VALUE || MAX_VALUE < value) {
			throw new OutOfBoundValueException("로또 숫자는 1-45 사이의 숫자로 생성할 수 있습니다.");
		}
	}

	public static LottoNumber valueOf(int value) {
		NUMBER_CACHE.putIfAbsent(value, new LottoNumber(value));
		return NUMBER_CACHE.get(value);
	}

	public static LottoNumber valueOf(String value) {
		return valueOf(parseInt(value.trim()));
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
