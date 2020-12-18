package lotto.number;

import lotto.result.LottoResult;

public class WinningNumbers {
	private final LottoNumbers lottoNumbers;
	private final LottoNumber bonusLottoNumber;

	public WinningNumbers(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
		this.lottoNumbers = lottoNumbers;
		this.bonusLottoNumber = bonusLottoNumber;
	}

	public LottoResult findMatchedResult(LottoNumbers lottoNumbers) {
		int matchedCount = lottoNumbers.getMatchedLottoNumbers(this.lottoNumbers).size();
		boolean isBonusMatched = lottoNumbers.contains(bonusLottoNumber);
		return LottoResult.findMatchedResult(matchedCount, isBonusMatched);
	}
}
