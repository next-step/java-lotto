package lotto.model;

import common.NumberElement;

public class WinNumber {
	private LottoNumberCollection primaryNumbers;

	private NumberElement bonusNumber;

	public WinNumber(LottoNumberCollection primaryNumbers, NumberElement bonusNumber) {

		if(primaryNumbers.size() < LottoRule.MAX_COUNT){
			throw new IllegalArgumentException("당첨번호의 개수가 부족합니다.");
		}

		if(bonusNumber == null){
			throw new IllegalArgumentException("보너스 번호가 필요합니다.");
		}

		this.primaryNumbers = primaryNumbers;
		this.bonusNumber = bonusNumber;
	}

	public LottoNumberCollection getPrimary() {
		return primaryNumbers;
	}

	public NumberElement getBonus() {
		return bonusNumber;
	}
}
