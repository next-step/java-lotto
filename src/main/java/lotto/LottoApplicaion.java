package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printPrice(price);
		Ticket ticket = new Ticket(Ticket.generate(count));
		printLottoNumber(ticket);

		printWinningNumber();
		Lotto winningNumbers = new Lotto(winningNumbers(inputText()));
		LottoNumber bonus = new LottoNumber(printBonusNumber());
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

		int[] statistics = Rank.calculate(winningLotto.match(ticket));
		printStatistics(statistics, Rank.calculateRateOfReturn(statistics, price));
	}
}
