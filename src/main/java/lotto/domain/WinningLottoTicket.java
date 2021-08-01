package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

public class WinningLottoTicket {

	private final LottoTicket winningTicket;
	private final LottoNumber bonusNumber;

	private WinningLottoTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
		validateBonusNumber(winningTicket, bonusNumber);
		this.winningTicket = winningTicket;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket from(LottoNumbers lottoNumbers, int bonusNumber) {
		return new WinningLottoTicket(lottoNumbers.toLottoTicket(), new LottoNumber(bonusNumber));
	}

	public LottoPrize match(LottoTicket lottoTicket) {
		return LottoPrize.from(lottoTicket.matchCount(winningTicket), lottoTicket.contains(bonusNumber));
	}

	private void validateBonusNumber(LottoTicket winningTicket, LottoNumber bonusNumber) {
		if (isBonusNumberDuplicate(winningTicket, bonusNumber)) {
			throw new InvalidBonusNumberException(winningTicket.getNumbers(), bonusNumber.getNumber());
		}
	}

	private boolean isBonusNumberDuplicate(LottoTicket winningTicket, LottoNumber bonusNumber) {
		return winningTicket.contains(bonusNumber);
	}
}
