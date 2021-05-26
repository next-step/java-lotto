package lottery;

import java.util.Comparator;
import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

	private int value;

	public static LottoNo of(int value) {
		return new LottoNo(value);
	}

	public static LottoNo of(String value) {
		return new LottoNo(Integer.parseInt(value));
	}

	private LottoNo(int value) {
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
		if (!(o instanceof LottoNo))
			return false;
		LottoNo lottoNo = (LottoNo)o;
		return value == lottoNo.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(LottoNo o) {
		return Integer.compare(this.value, o.value);
	}
}
