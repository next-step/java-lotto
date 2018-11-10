package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.utils.StringUtils;

public class WinningNumber {

	private String winningNumber;
	private LottoNumber bonusNumber;

	public WinningNumber(String winningNumber, LottoNumber bonusNumber) {
		if(StringUtils.isBlank(winningNumber)) {
			throw new IllegalArgumentException("잘못된 당첨 번호입니다.");
		}
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public String getWinningNumber() {
		return winningNumber;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
