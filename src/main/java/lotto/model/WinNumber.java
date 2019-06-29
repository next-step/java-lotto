package lotto.model;

import common.NumberElement;

public class WinNumber {
	private LottoNumberSet primaryNumbers;

	private LottoNumber bonusNumber;

	public WinNumber(LottoNumberSet primaryNumbers, LottoNumber bonusNumber) {

		if(primaryNumbers.size() < LottoRule.MAX_COUNT){
			throw new IllegalArgumentException("당첨번호의 개수가 부족합니다.");
		}

		if(bonusNumber == null){
			throw new IllegalArgumentException("보너스 번호가 필요합니다.");
		}

		this.primaryNumbers = primaryNumbers;
		this.bonusNumber = bonusNumber;
	}

	public LottoNumberSet getPrimary() {
		return primaryNumbers;
	}

	public LottoNumber getBonus() {
		return bonusNumber;
	}
}
