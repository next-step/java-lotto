package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.controller.Statistics;
import lotto.controller.TicketGenerator;
import lotto.controller.WinningNumberChecker;
import lotto.domain.Lottos;
import lotto.domain.Ticket;

public class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printPrice(price);
		Ticket ticket = new Ticket(TicketGenerator.generate(count));
		printLottoNumber(ticket);
		printWinningNumber();
		int[] winningNumbers = winningNumbers(inputText());
    	int[] statistics = Statistics.calculate(WinningNumberChecker.check(winningNumbers, ticket, count));
		printStatistics(statistics, Statistics.calculateRateOfReturn(statistics, price));
	}
}
