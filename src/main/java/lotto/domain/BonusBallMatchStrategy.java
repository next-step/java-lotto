package lotto.domain;

import java.util.List;

public class BonusBallMatchStrategy implements MatchStrategy {
	private final int matchCount;

	public BonusBallMatchStrategy(int matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return isMatchCountAndBonusBallNumber(lottoLottery, winLottoNumbers);
	}

	private boolean isMatchCountAndBonusBallNumber(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers) {
		return isMatchCount(lottoLottery, winLottoNumbers.getWinNumbers())
			&& isMatchBonusBallNumber(lottoLottery, winLottoNumbers.getBonusBallNumber());
	}

	private boolean isMatchCount(LottoLottery lottoLottery, List<LottoNumber> winLottoNumbers) {
		return matchCount == countMatches(lottoLottery, winLottoNumbers);
	}

	private long countMatches(LottoLottery lottoLottery, List<LottoNumber> winLottoNumbers) {
		return winLottoNumbers.stream()
			.filter(lottoLottery::contains)
			.count();
	}

	private boolean isMatchBonusBallNumber(LottoLottery lottoLottery, LottoNumber bonusBallNumber) {
		return lottoLottery.contains(bonusBallNumber);
	}
}
