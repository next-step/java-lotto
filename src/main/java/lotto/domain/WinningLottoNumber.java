package lotto.domain;

public class WinningLottoNumber {
	private LottoNumbers winningLottoNumbers;
	private LottoNumber bonusNumber;

	public WinningLottoNumber(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
		checkBonusNumber(winningLottoNumbers, bonusNumber);
		this.winningLottoNumbers = winningLottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	private void checkBonusNumber(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
		if (winningLottoNumbers.getLottoNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException("당첨번호와 보너스 번호는 중복되면 안됩니다.");
		}
	}

	public LottoNumbers getWinningLottoNumbers() {
		return winningLottoNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

}
