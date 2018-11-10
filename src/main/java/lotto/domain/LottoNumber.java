package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

	private Integer number;

	private LottoNumber(Integer number) {
		this.number = number;
	}

	public static LottoNumber valueOf(String number) {
		return LottoNumber.valueOf(Integer.valueOf(number));
	}

	public static LottoNumber valueOf(Integer number) {
		if(!isInValidRange(number)) {
			throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자만 가능합니다.",
					MIN_NUMBER, MAX_NUMBER));
		}
		if(lottoNumberCache.containsKey(number)) {
			return lottoNumberCache.get(number);
		}
		LottoNumber lottoNumber = new LottoNumber(number);
		lottoNumberCache.put(number, lottoNumber);
		return lottoNumber;
	}

	private static boolean isInValidRange(Integer number) {
		return MIN_NUMBER <= number && number <= MAX_NUMBER;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LottoNumber)) {
			return false;
		}
		LottoNumber that = (LottoNumber) o;
		return Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return number.toString();
	}
}
