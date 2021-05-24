package wootecam.lotto.model;

import wootecam.lotto.exception.LottoException;

public class BonusNumber {

	private final LottoNumber bonusNumber;

	public BonusNumber(LottoNumber bonusNumber, Lotto winningLotto) {
		if (winningLotto.contains(bonusNumber)) {
			throw new LottoException("보너스 번호가 로또번호와 중복됩니다.");
		}
		this.bonusNumber = bonusNumber;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	public boolean containsBonus(Lotto lotto) {
		return lotto.contains(bonusNumber);
	}
}
