package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.dto.WinningNumber;

public class WinningLottoGenerator {

	public static WinningLotto generate(WinningNumber winningNumber) {
		Lotto lotto = getLotto(winningNumber.getWinningNumber());
		LottoNumber bonusNumber = winningNumber.getBonusNumber();
		if(lotto.hasNumber(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
		}
		return new WinningLotto(lotto, bonusNumber);
	}

	private static Lotto getLotto(String winningNumber) {
		return new Lotto(LottoNumberGenerator.parse(winningNumber));
	}
}
