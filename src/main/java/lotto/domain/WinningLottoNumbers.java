package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
	private LottoNumbers winningLottoNumbers;

	public WinningLottoNumbers(List<Integer> winningLottoNumbers) {
		this.winningLottoNumbers = new LottoNumbers(winningLottoNumbers);
	}

	public LottoNumbers getWinningLottoNumbers() {
		return winningLottoNumbers;
	}

}
