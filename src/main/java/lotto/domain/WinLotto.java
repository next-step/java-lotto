package lotto.domain;

public class WinLotto {

	private final WinNumbers winNumbers;
	private final LottoNumber bonusNumber;

	public WinLotto(WinNumbers winNumbers, LottoNumber bonusNumber) {
		this.winNumbers = winNumbers;
		this.bonusNumber = bonusNumber;
	}

	public void calculateScore(PurchasedLottos purchasedLottos) {
		if (this.winNumbers.contains(this.bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
		}
		purchasedLottos.calculateScore(this.winNumbers, this.bonusNumber);
	}
}
