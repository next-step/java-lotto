package lotto.domain;

public class WinningLotto {

	private final WinningNumbers winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
		}
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public void calculateScore(PurchasedLottos purchasedLottos) {
		purchasedLottos.calculateScore(this.winningNumbers, this.bonusNumber);
	}
}
