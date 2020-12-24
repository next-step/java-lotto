package lotto.domain;

public class DefaultMatchStrategy implements MatchStrategy {
	private final int matchCount;

	public DefaultMatchStrategy(int matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return matchCount == countMatches(lottoLottery, winLottoNumbers);
	}

	private int countMatches(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return winLottoNumbers.getWinNumbers()
			.stream()
			.filter(lottoLottery::contains)
			.mapToInt(value -> 1)
			.sum();
	}
}
