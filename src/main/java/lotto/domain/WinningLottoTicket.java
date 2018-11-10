package lotto.domain;

import lotto.domain.validator.WinningLottoTicketValidator;

import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public class WinningLottoTicket {
	private LottoTicket lottoTicket;
	private LottoNumber bonusNumber;

	public WinningLottoTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
		this.lottoTicket = LottoTicket.newInstanceByManual(lottoNumbers);
		this.bonusNumber = bonusNumber;
		WinningLottoTicketValidator.valid(this);
	}

	public LottoWinnerType matchNumber(LottoTicket targetLottoTicket) {
		int matchingCount = this.lottoTicket.getMatchingCount(targetLottoTicket);
		boolean hasBonusNumber = targetLottoTicket.hasNumber(bonusNumber);
		return LottoWinnerType.findByMatchingCountAndBonus(matchingCount, hasBonusNumber);
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	public List<LottoNumber> getNumbers() {
		return lottoTicket.getNumbers();
	}
}
