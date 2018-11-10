package lotto.domain;

import lotto.domain.common.Cache;
import lotto.domain.common.HashMapCache;
import lotto.domain.validator.LottoNumberValidator;

import java.util.Objects;

/**
 * Created by hspark on 10/11/2018.
 */
public final class LottoNumber implements Comparable<LottoNumber> {
	private static final Cache<Integer, LottoNumber> CACHE = new HashMapCache<>();

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		LottoNumberValidator.valid(number);
		LottoNumber cache = CACHE.get(number);
		if (Objects.nonNull(cache)) {
			return cache;
		}
		cache = new LottoNumber(number);
		CACHE.put(number, cache);
		return cache;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber anotherNumber) {
		return Integer.compare(this.number, anotherNumber.number);
	}

	@Override
	public String toString() {
		return "" + number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoNumber that = (LottoNumber) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}
}
