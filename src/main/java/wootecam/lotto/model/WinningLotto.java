package wootecam.lotto.model;

public class WinningLotto {
	private final Lotto lotto;
	private final BonusNumber bonusNumber;

	public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
		this.lotto = lotto;
		this.bonusNumber = bonusNumber;
	}

	public boolean containsBonusNumber(Lotto lotto) {
		return this.bonusNumber.containsBonus(lotto);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lotto.contains(lottoNumber);
	}
}
