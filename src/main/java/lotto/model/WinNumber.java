package lotto.model;

public class WinNumber {
	private LottoNumberSet primaryNumbers;

	private LottoNumber bonusNumber;

	public WinNumber(LottoNumberSet primaryNumbers, LottoNumber bonusNumber) {
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
