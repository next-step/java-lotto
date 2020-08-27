package step4.domain;

import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final List<LottoNumber> winningNumbers;
	private LottoNumber bonusNumber;

	private static final String DUPLICATE_BONUS_NUMBER_PHRASES = "로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	public WinningLotto(List<LottoNumber> winningNumbers) {
		this.winningNumbers = winningNumbers;
		lotto = new Lotto(winningNumbers);
	}

	public void setBonusNumber(LottoNumber bonusNumber) {
		this.bonusNumber = bonusNumber;
		validBonusNumber();
	}

	public List<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	private void validBonusNumber() {
		if (lotto.containNumber(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_PHRASES);
		}
	}
}
