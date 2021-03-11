package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;

import camp.nextcamp.edu.lotto.exception.UserException;

public class BonusNumber {
	private final LottoNumber lottoNumber;

	public BonusNumber(LottoNumber lottoNumber, WinningLotto winningLotto) {
		validateNumber(winningLotto, lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validateNumber(WinningLotto winningLotto, LottoNumber lottoNumber) {
		if (winningLotto.getLotto().getNumbers().contains(lottoNumber)) {
			throw new UserException(OVERLAP_BONUS_NUMBER);
		}
	}

	public LottoNumber getLottoNumber() {
		return lottoNumber;
	}
}
