package lotto.view.dto;

import lotto.model.LottoRank;
import lotto.model.Money;

public class LottoRankResultDto {
	private final int countOfMatch;
	private final int prize;
	private final int resultCount;
	private final boolean matchBonusBall;

	public LottoRankResultDto(LottoRank lottoRank, int resultCount) {
		this.countOfMatch = lottoRank.getCountOfMatch();
		Money prizeOfLank = lottoRank.getPrize();
		this.prize = prizeOfLank.getAmount();
		this.resultCount = resultCount;
		this.matchBonusBall = lottoRank == LottoRank.SECOND;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getPrize() {
		return prize;
	}

	public int getResultCount() {
		return resultCount;
	}

	public boolean isMatchBonusBall() {
		return matchBonusBall;
	}
}


