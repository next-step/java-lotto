package lotto.domain;

public class WinningLotto {

	private final Lotto winningLotto;

	public WinningLotto(String input) {
		this.winningLotto = new Lotto(LottoNumbers.create(input));
	}

	public void calculateScore(PurchasedLottos purchasedLottos, LottoNumber bonusNumber) {
		if (this.winningLotto.getLottoNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
		}
		purchasedLottos.calculateScore(this.winningLotto, bonusNumber);
	}
}
