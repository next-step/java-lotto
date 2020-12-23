package lotto.domain;

public class LottoResult {
	private final LottoRank lottoRank;
	private final int winnerCount;

	public LottoResult(LottoRank lottoRank, int winnerCount) {
		this.lottoRank = lottoRank;
		this.winnerCount = winnerCount;
	}

	public boolean isEqualRank(LottoRank lottoRank) {
		return this.lottoRank == lottoRank;
	}

	public LottoRank getLottoRank() {
		return lottoRank;
	}

	public int getWinnerCount() {
		return winnerCount;
	}

	public int getTotalPrize() {
		return lottoRank.getTotalPrize(winnerCount);
	}
}
