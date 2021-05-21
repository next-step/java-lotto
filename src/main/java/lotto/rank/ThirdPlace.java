package lotto.rank;

public class ThirdPlace implements LottoRank {

	private static final int THIRD_REWARD = 50000;

	@Override
	public int reward() {
		return THIRD_REWARD;
	}
}
