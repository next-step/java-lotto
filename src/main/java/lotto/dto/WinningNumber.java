package lotto.dto;

import lotto.utils.StringUtils;

public class WinningNumber {

	private String winningNumber;
	private int bonusNumber;

	public WinningNumber(String winningNumber, int bonusNumber) {
		if(StringUtils.isBlank(winningNumber)) {
			throw new IllegalArgumentException("잘못된 당첨 번호입니다.");
		}
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public String getWinningNumber() {
		return winningNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
