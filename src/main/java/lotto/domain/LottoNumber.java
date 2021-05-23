package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>(LOTTO_NUMBER_UPPER_BOUND);

	static {
		initialize();
	}

	private static void initialize() {
		for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; i++) {
			LottoNumber lottoNumber = new LottoNumber(i);
			LOTTO_NUMBER_MAP.put(i, lottoNumber);
		}
	}

	static LottoNumber of(int number) {
		return LOTTO_NUMBER_MAP.get(number);
	}

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
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

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return this.number - lottoNumber.number;
	}

}
