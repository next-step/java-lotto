package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
	private final List<LottoNumber> winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningNumber(String winningNumbers, String bonusNumber) {
		this.winningNumbers = LottoNumber.asList(winningNumbers);
		this.bonusNumber = LottoNumber.as(bonusNumber);
	}

	public List<LottoNumber> getWinningNumbers() {
		return new ArrayList<>(winningNumbers);
	}

	public LottoNumber getBonusNumber() {
		return new LottoNumber(bonusNumber.getNumber());
	}
}
