package domain;

import java.math.BigDecimal;

public class LottoOrderGroupAnalysis {
	private final Integer[] winnerNumbers;
	private final LottoOrderGroup lottoOrderGroup;
	private Integer match3 = 0;
	private Integer match4 = 0;
	private Integer match5 = 0;
	private Integer match6 = 0;

	public LottoOrderGroupAnalysis (Integer[] winnerNumbers, LottoOrderGroup lottoOrderGroup) {
		this.winnerNumbers = winnerNumbers;
		this.lottoOrderGroup = lottoOrderGroup;
		matchSetting();
	}

	private void matchSetting(){
		for (Lotto lotto : lottoOrderGroup.lottos()) {
			final Integer matchCount = LottoNumberMatch.matchCount(winnerNumbers, lotto.numbers());
			match(matchCount);
		}
	}

	private void match (Integer matchCount) {
		if (matchCount == 3) {
			match3++;
		}
		if (matchCount == 4) {
			match4++;
		}
		if (matchCount == 5) {
			match5++;
		}
		if (matchCount == 6) {
			match6++;
		}
	}

	public Integer yield () {
		return new BigDecimal(0).intValue();
	}

	public Integer match3 () {
		return match3;
	}

	public Integer match4 () {
		return match4;
	}

	public Integer match5 () {
		return match5;
	}

	public Integer match6 () {
		return match6;
	}
}
