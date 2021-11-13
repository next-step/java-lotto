package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import lotto.generator.Generator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	private final Generator generator;

	public LottoController(Generator generator) {
		this.generator = generator;
	}

	public void draw() {
		int availableTicketSize = InputView.geAvailableTicketSize();
		List<Ticket> manualTickets = InputView.getManualTickets();
		int sizeOfAutoTickets = availableTicketSize - manualTickets.size();

		Lotto lotto = Lotto.create(generator, sizeOfAutoTickets, manualTickets);

		ResultView.printPurchasesInfo(manualTickets.size(), sizeOfAutoTickets);
		ResultView.printTickets(lotto.getTickets());

		WinningTicket winningTicket = InputView.getWinningTicket();
		Statistics statistics = lotto.createStatistics(winningTicket);

		ResultView.printStatistics(statistics);
	}
}
