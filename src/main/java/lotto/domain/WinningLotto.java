package lotto.domain;

class WinningLotto {

	private final LottoTicket winningLottoNumbers;

	WinningLotto(String numbersString) {
		winningLottoNumbers = new LottoTicket(numbersString);
	}

}
