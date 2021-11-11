package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.generator.Generator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	private final Generator generator;

	public LottoController(Generator generator) {
		this.generator = generator;
	}

	public void draw() {
		int numberOfPurchases = InputView.getNumberOfPurchases();
		Lotto lotto = Lotto.create(generator, numberOfPurchases);

		ResultView.printTickets(lotto.getTickets());

		Ticket winningNumberTicket = InputView.getWinningNumberTicket();
		Statistics statistics = lotto.createStatistics(winningNumberTicket);

		ResultView.printStatistics(statistics);
	}
}
