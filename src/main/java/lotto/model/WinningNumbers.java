package lotto.model;

public class WinningNumbers {
	private final LottoNumbers lottoNumbers;
	private final LottoNumber bonusNumber;

	private WinningNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		this.validateNotContains(lottoNumbers, bonusNumber);
		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningNumbers of(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		return new WinningNumbers(lottoNumbers, bonusNumber);
	}

	private void validateNotContains(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		if (lottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("로또 당첨 숫자에 보너스 숫자는 포함될 수 없습니다.");
		}
	}

	LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}

	LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
