package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import lotto.exception.LottoNumberValidationException;

public class LottoNumber implements Comparable<LottoNumber>{

	private static final int LOTTO_FIRST_NUMBER = 1;
	private static final int LOTTO_LAST_NUMBER = 45;

	private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
	private final int lottoNumber;

	static {
		IntStream.rangeClosed(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)
			.boxed()
			.forEach(v -> {
				lottoNumberMap.put(v, new LottoNumber(v));
			});
	}

	private LottoNumber(int lottoNumber) {
		validate(lottoNumber);
		
		this.lottoNumber = lottoNumber;
	}

	private static void validate(int lottoNumber) {
		if (lottoNumber > LOTTO_LAST_NUMBER ||
			lottoNumber < LOTTO_FIRST_NUMBER) {
			throw new LottoNumberValidationException("로또 번호가 잘못 되었습니다.");
		}
	}

	public static LottoNumber valueOf(int lottoNumber) {
		validate(lottoNumber);

		return lottoNumberMap.get(lottoNumber);
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

	public int getLottoNumber() {
		return lottoNumber;
	}

	@Override
	public int compareTo(LottoNumber compareLottoNumber) {
		return this.lottoNumber - compareLottoNumber.lottoNumber;
	}
}
