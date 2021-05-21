package lotto.rank;

public class FourthPlace implements LottoRank {

	private static final int FOURTH_REWARD = 5000;

	@Override
	public int reward() {
		return FOURTH_REWARD;
	}
}
