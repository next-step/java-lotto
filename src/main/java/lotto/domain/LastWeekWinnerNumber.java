package lotto.domain;

public class LastWeekWinnerNumber {
	private final Lotto winnerNumber;
	private final LottoNumber bonusNumber;

	public LastWeekWinnerNumber(String inputNumber, LottoNumber bonusNumber) {
		this.winnerNumber = new Lotto(inputNumber);
		if (this.winnerNumber.getGameNumberList().contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호와 다른 번호여야 합니다.");
		}
		this.bonusNumber = bonusNumber;
	}

	public Lotto getLastWinnerNumber() {
		return winnerNumber;
	}

	public int getMatchCount(Lotto lotto) {
		return (int)lotto.getGameNumberList()
			.stream()
			.filter(
				lottoNumber -> winnerNumber.getGameNumberList().contains(lottoNumber))
			.count();
	}

	public boolean getMatchBonusCount(Lotto lotto) {
		return lotto.getGameNumberList().contains(bonusNumber);
	}
}
