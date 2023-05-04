package lotto.domain;

public class WinningLotto {

	private final Lotto winningLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(String input, LottoNumber bonusNumber) {
		this.winningLotto = new Lotto(LottoNumbers.create(input));
		this.bonusNumber = bonusNumber;
	}

	public void calculateScore(PurchasedLottos purchasedLottos) {
		if (this.winningLotto.getLottoNumbers().contains(this.bonusNumber)) {
			throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
		}
		purchasedLottos.calculateScore(this.winningLotto, this.bonusNumber);
	}
}
