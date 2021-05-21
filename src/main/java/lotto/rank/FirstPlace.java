package lotto.rank;

public class FirstPlace implements LottoRank {

	private static final int FIRST_REWARD = 2000000000;

	@Override
	public int reward() {
		return FIRST_REWARD;
	}
}
