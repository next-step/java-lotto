package lottery;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private int value;

	public static LottoNumber of(int value) {
		return new LottoNumber(value);
	}

	public static LottoNumber of(String value) {
		return new LottoNumber(Integer.parseInt(value));
	}

	private LottoNumber(int value) {
		setValue(value);
	}

	public int value() {
		return value;
	}

	private void setValue(int value) {
		if (value <= 0 || value > 45) {
			throw new IllegalArgumentException("유효하지 않는 숫자입니다.");
		}
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoNumber))
			return false;
		LottoNumber lottoNumber = (LottoNumber)o;
		return value == lottoNumber.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.value, o.value);
	}
}
