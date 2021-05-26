package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNo implements Comparable<LottoNo>{
	public static final int MIN = 1;
	public static final int MAX = 45;

	private static final Map<Integer, LottoNo> DEFAULT_LOTTO_NO_MAP = new HashMap<>();
	static {
		for (int i = MIN; i <= MAX; i++) {
			DEFAULT_LOTTO_NO_MAP.put(i, new LottoNo(i));
		}
	}

	private final int number;

	public LottoNo(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException(String.format("로또 번호는 %d ~ %d 사이의 수여야만 합니다.", MIN, MAX));
		}
		this.number = number;
	}

	public static LottoNo randomNo() {
		int randomNo = (int)(Math.random() * MAX) + MIN;
		return DEFAULT_LOTTO_NO_MAP.get(randomNo);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNo lottoNo = (LottoNo)o;
		return number == lottoNo.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public int number() {
		return this.number;
	}

	@Override
	public int compareTo(LottoNo o) {
		return number() - o.number();
	}
}
