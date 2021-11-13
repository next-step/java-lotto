package lotto.controller;

import java.util.List;

import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
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
		List<Ticket> manualTickets = InputView.getManualTickets(availableTicketSize);
		int sizeOfAutoTickets = availableTicketSize - manualTickets.size();

		Tickets tickets = Tickets.create(generator, sizeOfAutoTickets, manualTickets);

		ResultView.printPurchasesInfo(manualTickets.size(), sizeOfAutoTickets);
		ResultView.printTickets(tickets.getValues());

		WinningTicket winningTicket = InputView.getWinningTicket();
		Statistics statistics = Statistics.create(tickets, winningTicket);

		ResultView.printStatistics(statistics);
	}
}
