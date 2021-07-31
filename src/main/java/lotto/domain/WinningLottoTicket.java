package lotto.domain;

import java.util.List;

import lotto.exception.InvalidBonusNumberException;

public class WinningLottoTicket {

	private final LottoTicket winningTicket;
	private final LottoNumber bonusNumber;

	private WinningLottoTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
		this.winningTicket = winningTicket;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket from(List<Integer> winningNumbers, int bonusNumber) {
		validateNumbers(winningNumbers, bonusNumber);
		return new WinningLottoTicket(LottoTicket.from(winningNumbers), new LottoNumber(bonusNumber));
	}

	public LottoPrize compareTo(LottoTicket lottoTicket) {
		int matchCount = lottoTicket.matchCount(winningTicket);
		boolean hasBonusNumber = lottoTicket.contains(bonusNumber);
		return LottoPrize.fromMatchCount(matchCount, hasBonusNumber);
	}

	private static void validateNumbers(List<Integer> winningNumbers, int bonusNumber) {
		if (isBonusNumberDuplicate(winningNumbers, bonusNumber)) {
			throw new InvalidBonusNumberException(winningNumbers, bonusNumber);
		}
	}

	private static boolean isBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
		return winningNumbers.contains(bonusNumber);
	}
}
