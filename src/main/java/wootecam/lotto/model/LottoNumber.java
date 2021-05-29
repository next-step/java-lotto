package wootecam.lotto.model;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import wootecam.lotto.exception.LottoException;
import wootecam.util.StringUtils;

public class LottoNumber implements Comparable<LottoNumber> {
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;
	private final int number;
	private static Map<Integer, LottoNumber> lottoNumbers = new ConcurrentHashMap<>();

	static {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			lottoNumbers.put(i, new LottoNumber(i));
		}
	}

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(String numberInput) {
		if (!StringUtils.isNumeric(numberInput)) {
			throw new LottoException("정수형이 아닙니다.");
		}
		return of(Integer.parseInt(numberInput));
	}

	public static LottoNumber of(int number) {
		LottoNumber lottoNumber = lottoNumbers.get(number);
		if (lottoNumber == null) {
			throw new LottoException("로또 번호는 1~45만 가능합니다.");
		}
		return lottoNumber;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return this.number - lottoNumber.getNumber();
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

	public String valueOf() {
		return String.valueOf(this.number);
	}
}
