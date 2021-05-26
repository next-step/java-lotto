package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;

	private int num;

	public LottoNumber(int num) {
		if(num < MIN_NUMBER || num > MAX_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 0보다 작거나 45보다 클 수 없습니다.");
		}
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return num == that.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return getNum() - lottoNumber.getNum();
	}

	@Override
	public String toString() {
		return Integer.toString(getNum());
	}
}
