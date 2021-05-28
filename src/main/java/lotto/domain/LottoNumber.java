package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
	private final int number;

	static {
		for (int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; ++lottoNumber) {
			lottoNumberMap.put(lottoNumber, new LottoNumber(lottoNumber));
		}
	}

	private LottoNumber(final int number) {
		this.number = number;
	}

	public static LottoNumber of(final int number) {
		validateNumber(number);
		return lottoNumberMap.get(number);
	}

	private static void validateNumber(int number) {
		if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}

	@Override
	public boolean equals(Object otherLottoNumber) {
		if (!(otherLottoNumber instanceof LottoNumber)) {
			return false;
		}
		return ((LottoNumber)otherLottoNumber).number == this.number;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		if (this.number < lottoNumber.number) {
			return -1;
		}
		if (this.number > lottoNumber.number) {
			return 1;
		}
		return 0;
	}

}

