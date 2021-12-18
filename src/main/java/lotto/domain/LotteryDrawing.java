package lotto.domain;

import java.util.List;

public class LotteryDrawing {
	private final LottoNumbers winningNumbers;
	private final LottoNumbers myLottoNumbers;
	private int matchingCount;

	public LotteryDrawing(LottoNumbers winningNumbers, LottoNumbers myLottoNumbers) {
		this.winningNumbers = winningNumbers;
		this.myLottoNumbers = myLottoNumbers;
	}

	public CalculatePrize matchingPrize() {
		return CalculatePrize.of(matchingCount());
	}

	private int matchingCount() {
		for (LottoNumber winningLottoNumber : winningNumbers.lottoNumbers()) {
			matchesLottoNumber(myLottoNumbers.lottoNumbers(), winningLottoNumber);
		}
		return matchingCount;
	}

	private void matchesLottoNumber(List<LottoNumber> lottoNumbers, LottoNumber winningLottoNumber) {
		boolean matches = lottoNumbers.contains(winningLottoNumber);
		if (matches) {
			matchingCount++;
		}
	}
}
