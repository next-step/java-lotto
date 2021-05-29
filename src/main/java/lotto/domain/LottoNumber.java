package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int LOTTO_MINIMUM_NUMBER = 1;
	public static final int LOTTO_MAXIMUM_NUMBER = 45;

	private static final Map<Integer, LottoNumber> lottoNumberCache;

	static {
		lottoNumberCache = new HashMap<>();
		for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; i++) {
			lottoNumberCache.put(i, new LottoNumber(i));
		}
	}

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	private static void validateNumber(int number) {
		if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
			throw new RuntimeException("lotto number must be within the range(1 - 45)");
		}
	}

	public static LottoNumber of(int number) {
		validateNumber(number);
		return lottoNumberCache.get(number);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return number - o.number;
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

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
