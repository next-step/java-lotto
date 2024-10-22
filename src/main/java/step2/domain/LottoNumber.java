package step2.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoNumber implements Comparable<LottoNumber> {
	private static final List<LottoNumber> CACHE_NUMBER = new ArrayList<>();
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	private LottoNumber() {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			CACHE_NUMBER.add(new LottoNumber(i));
		}
	}

	public static synchronized List<LottoNumber> getLottoNumbers() {
		if (CACHE_NUMBER.isEmpty()) {
			new LottoNumber();
		}
		// 복사로 변조 방지
		return new ArrayList<>(CACHE_NUMBER);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}

	public int getNumber() {
		return number;
	}
}
