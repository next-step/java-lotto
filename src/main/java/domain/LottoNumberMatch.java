package domain;

import ui.Rank;

public class LottoNumberMatch {
	private LottoNumberMatch() {
	}

	public static Integer matchCount(Lotto winNumber, Lotto lotto) {
		int matchCount = 0;
		for (Integer number : winNumber.numbers()) {
			matchCount = lotto.numbers().contains(number) ? matchCount + 1 : matchCount;
		}

		return lotto.rank(Rank.valueOf(matchCount)).countOfMatch();
	}

	public static Boolean matchBonus(Integer bonusBall, Lotto lotto) {
		return lotto.contains(bonusBall);
	}
}
