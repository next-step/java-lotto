package im.juniq.lotto.domain;

import java.util.List;

public class WinningNumbers {
	private LottoNumbers lottoNumbers;
	private final int bonusNumber;

	public WinningNumbers(List<Integer> numbers, int bonusNumber) {
		this.lottoNumbers = new LottoNumbers(numbers);
		this.bonusNumber = bonusNumber;
	}

	public int matchedCount(LottoNumbers lottoNumbers) {
		return this.lottoNumbers.matchedCount(lottoNumbers);
	}

	public boolean matchedBonusNumber(LottoNumbers lottoNumbers) {
		return lottoNumbers.contain(bonusNumber);
	}
}
