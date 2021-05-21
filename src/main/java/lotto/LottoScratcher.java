package lotto;

import lotto.rank.FirstPlace;
import lotto.rank.FourthPlace;
import lotto.rank.LottoRank;
import lotto.rank.NoRank;
import lotto.rank.SecondPlace;
import lotto.rank.ThirdPlace;

public class LottoScratcher {

	private static final int FIRST_MATCHES = 6;
	private static final int SECOND_MATCHES = 5;
	private static final int THIRD_MATCHES = 4;
	private static final int FOURTH_MATCHES = 3;

	private LottoScratcher() {
	}

	//todo : switch 쓰지마라
	public static LottoRank scratchLotto(int matches) {
		switch (matches) {
			case FIRST_MATCHES:
				return new FirstPlace();
			case SECOND_MATCHES:
				return new SecondPlace();
			case THIRD_MATCHES:
				return new ThirdPlace();
			case FOURTH_MATCHES:
				return new FourthPlace();
			default:
				return new NoRank();
		}
	}
}
