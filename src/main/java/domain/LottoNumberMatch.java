package domain;

import ui.Rank;

import java.util.List;

public class LottoNumberMatch {
	private LottoNumberMatch () { }

	public static Integer matchCount (List<Integer> winNumber, Lotto lotto) {
		int matchCount = 0;
		for (Integer number : winNumber) {
			matchCount = lotto.numbers().contains(number) ? matchCount + 1 : matchCount;
		}

		return lotto.rank(Rank.valueOf(matchCount)).countOfMatch();
	}
	public static Boolean matchBonus (int bonusBall, Lotto lotto) {
		return lotto.contains(bonusBall);
	}
}
