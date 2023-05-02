package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {

	public static final int MINIMUM_BOUND = 1;
	public static final int MAXIMUM_BOUND = 45;
	private final static Map<Integer, LottoNumber> LOTTO_NUMBERS_POCKET = new HashMap<>();

	private final int lottoNumber;

	static {
		for (int number = LottoNumber.MINIMUM_BOUND; number <= LottoNumber.MAXIMUM_BOUND; number++) {
			LottoNumber.LOTTO_NUMBERS_POCKET.put(number, new LottoNumber(number));
		}
	}

	private LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber of(int lottoNumber) {
		return Optional.ofNullable(LottoNumber.LOTTO_NUMBERS_POCKET.get(lottoNumber))
			.orElseThrow(() -> new IllegalArgumentException("로또 넘버의 범위를 벗어났습니다."));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public String toString() {
		return String.valueOf(this.lottoNumber);
	}
}
