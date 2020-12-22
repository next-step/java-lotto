package step2.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoWin implements Comparator<LottoWin> {

	MATCH_0(0, 0),
	MATCH_1(1, 0),
	MATCH_2(2, 0),
	MATCH_3(3, 5_000),
	MATCH_4(4, 50_000),
	MATCH_5(5, 1_500_000),
	MATCH_5_BONUS(5, 30_000_000),
	MATCH_6(6, 2_000_000_000);

	private final int matchCount;
	private final int price;

	LottoWin(final int matchCount, final int price) {
		this.matchCount = matchCount;
		this.price = price;
	}

	public static LottoWin of(final int matchCount, final boolean isMatchBonus) {
		if (MATCH_5_BONUS.getMatchCount() == matchCount && isMatchBonus) {
			return MATCH_5_BONUS;
		}
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

	public boolean isWin() {
		final int WINNABLE_MATCH_COUNT = 3;
		return this.matchCount >= WINNABLE_MATCH_COUNT;
	}

	@Override
	public int compare(final LottoWin o1, final LottoWin o2) {
		return o2.matchCount - o1.matchCount;
	}

	public boolean isWinWithBonusBall() {
		return this == LottoWin.MATCH_5_BONUS;
	}

}
