package lotto.domain;

public class BonusBallMatchStrategy implements MatchStrategy {
	private final int matchCount;

	public BonusBallMatchStrategy(int matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return winLottoNumbers.isEqualMatchCount(lottoLottery, matchCount)
			&& winLottoNumbers.isMatchBonusBallNumber(lottoLottery);
	}
}
