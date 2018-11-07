package lotto.domain;

import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public class WinningLottoTicket implements LottoNumber {
	private LottoTicket lottoTicket;
	private Integer bonusNumber;

	public WinningLottoTicket(List<Integer> lottoNumbers, Integer bonusNumber) {
		this.lottoTicket = LottoTicket.newInstanceByManual(lottoNumbers);
		this.bonusNumber = bonusNumber;
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
