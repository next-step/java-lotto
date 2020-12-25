package edu.nextstep.lotto.domain.sub;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
	public static final int START_LIMIT = 1;
	public static final int END_LIMIT = 45;
	private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

	static {
		for (int i = START_LIMIT; i <= END_LIMIT; i++) {
			LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
		}
	}

	private final int lottoNumber;

	private LottoNumber(int number) {
		this.lottoNumber = number;
	}

	public static LottoNumber of(int number) {
		if (isNotValid(number)) {
			throw new IllegalArgumentException("로또 번호는 " + START_LIMIT + "부터 " + END_LIMIT + " 사이만 가능합니다.");
		}
		return LOTTO_NUMBER_MAP.get(number);
	}

	public static boolean isNotValid(int number) {
		return !LOTTO_NUMBER_MAP.containsKey(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LottoNumber)) {
			return false;
		}
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}