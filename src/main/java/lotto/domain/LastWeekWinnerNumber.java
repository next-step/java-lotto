package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LastWeekWinnerNumber {
	private final Lotto winnerNumber;
	private final LottoNumber bonusNumber;

	public LastWeekWinnerNumber(String inputNumber, LottoNumber bonusNumber) {
		validateBonusNumber(inputNumber, bonusNumber);
		this.winnerNumber = new Lotto(inputNumber);
		this.bonusNumber = bonusNumber;
	}

	public Lotto getLastWinnerNumber() {
		return winnerNumber;
	}

	public int getMatchCount(Lotto lotto) {
		return (int)lotto.getGameNumberList()
			.stream()
			.filter(
				lottoNumber -> winnerNumber.hasContain(lottoNumber))
			.count();
	}

	public boolean getMatchBonusCount(Lotto lotto) {
		return lotto.hasContain(bonusNumber);
	}

	private void validateBonusNumber(String inputNumber, LottoNumber bonusNumber) {
		boolean result = Arrays.stream(inputNumber.split(","))
			.map(n -> n.trim())
			.collect(Collectors.toList())
			.contains(bonusNumber);
		if (result) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호와 다른 번호여야 합니다.");
		}
	}
}
