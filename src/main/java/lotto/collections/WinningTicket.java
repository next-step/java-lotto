package lotto.collections;

import lotto.domain.LottoNumber;

public class WinningTicket {

	private WinningNumbers winningNumbers;
	private LottoNumber bonusBall;

	public WinningTicket(WinningNumbers winningNumbers, LottoNumber bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = validateBonusBall(bonusBall);
	}

	private LottoNumber validateBonusBall(LottoNumber bonusBall) {
		if (this.winningNumbers.getWinningNumbers()
			.stream()
			.map(number -> number.equals(bonusBall))
			.findFirst()
			.isPresent()) {
			throw new RuntimeException("로또 번호와 보너스 볼은 중복 불가합니다.");
		}
		return bonusBall;
	}
}
