package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import lotto.domain.ProfitCalculator;
import lotto.domain.Ticket;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printPrice(price);
		Ticket ticket = new Ticket(Ticket.generate(count));
		printLottoNumber(ticket);
		printWinningNumber();
		int[] winningNumbers = winningNumbers(inputText());
		int[] statistics = ProfitCalculator.calculate(ProfitCalculator.check(winningNumbers, ticket, count));
		printStatistics(statistics, ProfitCalculator.calculateRateOfReturn(statistics, price));
	}
}
