package lotto.model;

import lotto.message.ErrorMessage;

public class WinnerLotto {

	private final Lotto winnerLotto;
	private final LottoNumber bonusNumber;

	public WinnerLotto(Lotto winnerLotto, int bonusNumber) {
		checkNUmberDuplication(winnerLotto, bonusNumber);
		this.winnerLotto = winnerLotto;
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	public Lotto getWinnerLotto() {
		return winnerLotto;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	private void checkNUmberDuplication(Lotto winnerLotto, int bonusNumber) {
		if (winnerLotto.isNumberContain(new LottoNumber(bonusNumber))) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}
}
