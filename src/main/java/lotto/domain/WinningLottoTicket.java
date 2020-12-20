package lotto.domain;

import java.util.List;

import lotto.utils.SplitUtils;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningLottoTicket {

	private LottoTicket lottoTicket;
	private LottoNumber bonusNumber;

	public WinningLottoTicket(String winningNumber, LottoNumber bonusNumber) {
		lottoTicket = convertUserInput(winningNumber);
		this.bonusNumber = bonusNumber;
	}

	private LottoTicket convertUserInput(String arg) {
		validateUserInput(arg);
		List<LottoNumber> lottoNumbers = SplitUtils.userInputNumbersToLottoNumbers(arg);
		return new LottoTicket(lottoNumbers);
	}

	private void validateUserInput(String arg) {
		if (arg == null || arg.isEmpty())
			throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
	}

	public LottoTicket getLottoTicket() {
		return lottoTicket;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	public Prize matchPrize(LottoTicket userLottoTicket) {
		return Prize.of(userLottoTicket.getMatchCount(lottoTicket), userLottoTicket.isMatchBonus(bonusNumber));

	}
}
