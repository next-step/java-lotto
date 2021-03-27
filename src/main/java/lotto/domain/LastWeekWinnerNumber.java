package lotto.domain;

public class LastWeekWinnerNumber {
	private final Lotto winnerNumber;

	public LastWeekWinnerNumber(String inputNumber) {
		winnerNumber = new Lotto(inputNumber);
	}

	public Lotto getLastWinnerNumber() {
		return winnerNumber;
	}
}
