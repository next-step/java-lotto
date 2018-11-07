package lotto.domain;

import lotto.domain.validator.WinningLottoTicketValidator;

import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public class WinningLottoTicket implements LottoNumber {
	private LottoTicket lottoTicket;
	private Integer bonusNumber;

	private WinningLottoTicket(List<Integer> lottoNumbers, Integer bonusNumber) {
		this.lottoTicket = LottoTicket.newInstanceByManual(lottoNumbers);
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket newInstance(List<Integer> lottoNumbers, Integer bonusNumber) {
		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumbers, bonusNumber);
		WinningLottoTicketValidator.valid(winningLottoTicket);
		return winningLottoTicket;
	}

	@Override
	public List<Integer> getNumbers() {
		return lottoTicket.getNumbers();
	}

	@Override
	public LottoWinnerType matchNumber(LottoNumber lottoNumber) {
		int matchingCount = getMatchingCount(lottoNumber);
		boolean hasBonusNumber = lottoNumber.getNumbers().contains(bonusNumber);
		return LottoWinnerType.findByMatchingCountAndBonus(matchingCount, hasBonusNumber);
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}
}
