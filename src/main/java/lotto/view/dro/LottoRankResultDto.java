package lotto.view.dro;

import lotto.model.LottoRank;
import lotto.model.Money;

public class LottoRankResultDto {
	private int matchCount;
	private int prize;
	private int resultCount;

	public LottoRankResultDto(LottoRank lottoRank, int resultCount) {
		this.matchCount = lottoRank.getMatchCount();
		Money prize = lottoRank.getPrize();
		this.prize = prize.getMoney();
		this.resultCount = resultCount;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}

	public int getResultCount() {
		return resultCount;
	}
}


