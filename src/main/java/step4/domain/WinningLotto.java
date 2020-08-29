package step4.domain;

import java.util.List;

public class WinningLotto {
	private static final String DUPLICATE_BONUS_NUMBER_PHRASES = "로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final List<LottoNumber> winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(List<LottoNumber> winningNumbers, int bonusNumber) {
		validBonusNumber(winningNumbers, bonusNumber);
		this.winningNumbers = winningNumbers;
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	public List<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	private void validBonusNumber(List<LottoNumber> winningNumbers, int bonusNumber) {
		if (winningNumbers.contains(new LottoNumber(bonusNumber))) {
			throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_PHRASES);
		}
	}
}
