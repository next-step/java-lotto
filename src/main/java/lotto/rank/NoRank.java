package lotto.rank;

public class NoRank implements LottoRank {

	private static final int NO_RANK_REWARD = 0;

	@Override
	public int reward() {
		return NO_RANK_REWARD;
	}
}
