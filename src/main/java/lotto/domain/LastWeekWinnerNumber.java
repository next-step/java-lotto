package lotto.domain;

public class LastWeekWinnerNumber {
	private final Lotto winnerNumber;

	public LastWeekWinnerNumber(String inputNumber) {
		winnerNumber = new Lotto(inputNumber);
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
