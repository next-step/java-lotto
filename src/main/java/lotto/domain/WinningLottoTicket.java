package lotto.domain;

import java.util.List;

import lotto.exception.InvalidBonusNumberException;

public class WinningLottoTicket {

	private final LottoTicket winningTicket;
	private final LottoNumber bonusNumber;

	private WinningLottoTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
		validateBonusNumber(winningTicket, bonusNumber);
		this.winningTicket = winningTicket;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket from(List<Integer> winningNumbers, int bonusNumber) {
		return new WinningLottoTicket(LottoTicket.from(winningNumbers), new LottoNumber(bonusNumber));
	}

	public LottoPrize compareTo(LottoTicket lottoTicket) {
		int matchCount = lottoTicket.matchCount(winningTicket);
		boolean hasBonusNumber = lottoTicket.contains(bonusNumber);
		return LottoPrize.fromMatchCount(matchCount, hasBonusNumber);
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
