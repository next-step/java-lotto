package lotto.domain;

import java.util.List;

public class WinningNumbers {
	private final LottoNumbers winningNumbers;

	public WinningNumbers(LottoNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public WinningNumbers(List<Integer> winningNumbers) {
		this.winningNumbers = LottoNumbers.createManualLottoNumber(winningNumbers);
	}

	public List<LottoNumber> getWinningNumbers() {
		return winningNumbers.lottoNumbers();
	}
}
