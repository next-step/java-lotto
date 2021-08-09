package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import lotto.exception.LottoNumberValidationException;

public class LottoNumber implements Comparable<LottoNumber>{

	private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
	private final int lottoNumber;

	static {
		IntStream.range(1, 46)
			.boxed()
			.forEach(v -> {
				lottoNumberMap.put(v, new LottoNumber(v));
			});
	}

	private LottoNumber(int lottoNumber) {
		validate(lottoNumber);
		
		this.lottoNumber = lottoNumber;
	}

	private void validate(int lottoNumber) {
		if (lottoNumber > 45 ||
			lottoNumber <= 0) {
			throw new LottoNumberValidationException("로또 번호가 잘못 되었습니다.");
		}
	}

	public static LottoNumber valueOf(int lottoNumber) {
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
