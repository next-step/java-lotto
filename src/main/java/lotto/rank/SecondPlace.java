package lotto.rank;

public class SecondPlace implements LottoRank {

	private static final int SECOND_REWARD = 1500000;

	@Override
	public int reward() {
		return SECOND_REWARD;
	}
}
