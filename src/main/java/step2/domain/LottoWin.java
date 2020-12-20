package step2.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoWin implements Comparator<LottoWin> {

	MATCH_0(0, 5000),
	MATCH_1(1, 5000),
	MATCH_2(2, 5000),
	MATCH_3(3, 5000),
	MATCH_4(4, 50000),
	MATCH_5(5, 1500000),
	MATCH_6(6, 2000000000);

	private final int matchCount;
	private final int price;

	LottoWin(final int matchCount, final int price) {
		this.matchCount = matchCount;
		this.price = price;
	}

	public static LottoWin of(final int matchCount) {
		return Arrays.stream(LottoWin.values())
			.filter(lottoWin -> lottoWin.matches(matchCount))
			.findFirst()
			.orElseThrow(RuntimeException::new);
	}

	private boolean matches(final int matchCount) {
		return this.matchCount == matchCount;
	}

	public int getPrice() {
		return price;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public boolean isNotWin() {
		return this.matchCount < 3;
	}

	@Override
	public int compare(final LottoWin o1, final LottoWin o2) {
		return o2.matchCount - o1.matchCount;
	}
}
