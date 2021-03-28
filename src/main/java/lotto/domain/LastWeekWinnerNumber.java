package lotto.domain;

public class LastWeekWinnerNumber {
	private final Lotto winnerNumber;
	private final int bonusNumber;

	public LastWeekWinnerNumber(String inputNumber) {
		this(inputNumber, 0);
	}

	public LastWeekWinnerNumber(String inputNumber, int bonusNumber) {
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
				lottoNumber -> winnerNumber.getGameNumberList().contains(lottoNumber))
			.count();
	}
}
