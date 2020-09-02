package step3.domain;

import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final List<LottoNumber> winningNumbers;
	private LottoNumber bonusNumber;

	public WinningLotto(List<LottoNumber> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = new LottoNumber(bonusNumber) ;
		lotto = new Lotto(winningNumbers);
	}

	public List<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

}
