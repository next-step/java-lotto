package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 %d에서 %d 사이입니다.";
	private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>(LOTTO_NUMBER_UPPER_BOUND);

	static {
		initialize();
	}

	private static void initialize() {
		for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; i++) {
			LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
		}
	}

	static LottoNumber of(int number) {
		validate(number);

		return LOTTO_NUMBER_MAP.get(number);
	}

	private static void validate(int number) {
		if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
			throw new IllegalArgumentException(
				String.format(INVALID_LOTTO_NUMBER_MESSAGE, LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND));
		}
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
