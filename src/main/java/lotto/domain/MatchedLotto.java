package lotto.domain;

import java.util.List;

public class MatchedLotto {
	private final LottoNumbers winningNumbers;
	private final LottoNumbers myLottoNumbers;
	private final LottoNumber bonusNumber;
	private int matchingCount;

	public MatchedLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber, LottoNumbers myLottoNumbers) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
		this.myLottoNumbers = myLottoNumbers;
	}

	public CalculatePrize matchingPrize() {
		matchCount();
		return calculatedPrize();
	}

	private CalculatePrize calculatedPrize() {
		if (matchingCount == 5) {
			boolean matchingBonusNumber = matchingLottoNumber(myLottoNumbers.lottoNumbers(), bonusNumber);
			return CalculatePrize.ofSecondOrThird(matchingBonusNumber);
		}
		return CalculatePrize.of(matchingCount);
	}

	private void matchCount() {
		for (LottoNumber winningLottoNumber : winningNumbers.lottoNumbers()) {
			int numberCount = matchesLottoNumberCount(myLottoNumbers.lottoNumbers(), winningLottoNumber);
			matchingCount += numberCount;
		}
	}

	private int matchesLottoNumberCount(List<LottoNumber> lottoNumbers, LottoNumber winningLottoNumber){
		return matchingLottoNumber(lottoNumbers, winningLottoNumber) ? 1 : 0;
	}

	private boolean matchingLottoNumber(List<LottoNumber> lottoNumbers, LottoNumber winningLottoNumber) {
		return lottoNumbers.contains(winningLottoNumber);
	}


}
