package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST_PLACE(new DefaultMatchStrategy(6), 2000000000, "6개 일치"),
	SECOND_PLACE(new BonusBallMatchStrategy(5), 30000000, "5개 일치, 보너스 볼 일치"),
	THIRD_PLACE(new DefaultMatchStrategy(5), 1500000, "5개 일치"),
	FOURTH_PLACE(new DefaultMatchStrategy(4), 50000, "4개 일치"),
	FIFTH_PLACE(new DefaultMatchStrategy(3), 5000, "3개 일치"),
	NONE(new DefaultMatchStrategy(0), 0, "일치 하지 않음");

	private final MatchStrategy matchStrategy;
	private final int prize;
	private final String text;

	LottoRank(MatchStrategy matchStrategy, int prize, String text) {
		this.matchStrategy = matchStrategy;
		this.prize = prize;
		this.text = text;
	}

	public static LottoRank findMatchRank(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.isMatch(lottoLottery, winLottoNumbers))
			.findFirst()
			.orElse(NONE);
	}

	private boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return this.matchStrategy.isMatch(lottoLottery, winLottoNumbers);
	}

	public boolean isNotNone() {
		return this != NONE;
	}

	public String getText() {
		return text;
	}

	public int getPrize() {
		return prize;
	}

	public int getTotalPrize(int count) {
		return prize * count;
	}
}
