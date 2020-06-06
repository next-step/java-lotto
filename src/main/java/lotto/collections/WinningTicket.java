package lotto.collections;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.service.WinningService;

public class WinningTicket {

	private WinningNumbers winningNumbers;
	private LottoNumber bonusBall;

	public WinningTicket(WinningNumbers winningNumbers, LottoNumber bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = validateBonusBall(bonusBall);
	}

	private LottoNumber validateBonusBall(LottoNumber bonusBall) {
		if (this.winningNumbers.getWinningNumbers()
			.stream()
			.anyMatch(number -> number.compareBonusBallIdentity(bonusBall))) {
			throw new RuntimeException("로또 번호와 보너스 볼은 중복 불가합니다.");
		}
		return bonusBall;
	}

	public RewardType checkLottoNumbers(final LottoTicket lottoTicket) {
		return RewardType.findTypeByCount(WinningService.getMatchCount(winningNumbers, lottoTicket),
			lottoTicket.contains(bonusBall));
	}
}
