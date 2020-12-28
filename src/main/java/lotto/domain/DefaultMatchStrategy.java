package lotto.domain;

public class DefaultMatchStrategy implements MatchStrategy {
	private final int matchCount;

	public DefaultMatchStrategy(int matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return winLottoNumbers.isEqualMatchCount(lottoLottery, matchCount);
	}
}
