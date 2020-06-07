package lotto.collections;

import lotto.domain.LottoNumber;
import lotto.domain.RewardType;
import lotto.service.WinningService;

public class WinningTicket {

	private WinningNumbers winningNumbers;
	private LottoNumber bonusBall;

	public WinningTicket(WinningNumbers winningNumbers, LottoNumber bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = winningNumbers.validateBonusBall(bonusBall);
	}

	public RewardType checkLottoNumbers(final LottoTicket lottoTicket) {
		return RewardType.findTypeByCount(WinningService.getMatchCount(winningNumbers, lottoTicket),
			lottoTicket.contains(bonusBall));
	}
}
