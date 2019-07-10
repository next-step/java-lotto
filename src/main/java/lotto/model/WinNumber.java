package lotto.model;

public class WinNumber {

	private LottoNumberSet primaryNumbers;

	private LottoNumber bonusNumber;

	public WinNumber(LottoNumberSet primaryNumbers, LottoNumber bonusNumber) {
		if(primaryNumbers == null){
			throw new IllegalArgumentException("1등 당첨 번호가 필요합니다.");
		}

		if(bonusNumber == null){
			throw new IllegalArgumentException("보너스볼 번호가 필요합니다.");
		}

		if(primaryNumbers.contains(bonusNumber)){
			throw new IllegalArgumentException("보너스볼 번호는 1등 당첨번호에 포함 될 수 없습니다.");
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
