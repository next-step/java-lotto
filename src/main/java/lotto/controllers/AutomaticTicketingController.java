package lotto.controllers;

import java.util.List;

import lotto.AutomaticTicketing;
import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.views.Display;

public class AutomaticTicketingController extends SimpleController {

	AutomaticTicketing automaticTicketing = new AutomaticTicketing();

	int amount;
	List<Ticket> tickets;

	public AutomaticTicketingController(Lotto lotto) {
		super(lotto);

		this.amount = loadTotalTickets();
		this.tickets = loadNewTickets(amount);
	}

	@Override
	protected void show() {
		displayTicketAmount(this.amount);
		displayTickets(this.tickets);
	}

	private void displayTicketAmount(int amount) {
		Display.show(Message.AUTOMATIC_TICKETING, amount);
	}

	private void displayTickets(List<Ticket> tickets) {
		for (Ticket ticket : tickets) {
			Display.show(ticket);
		}
	}

	protected int loadTotalTickets() {
		return this.lotto.storage().loadPurchase().totalTickets();
	}

	protected List<Ticket> loadNewTickets(int amount) {
		List<Ticket> tickets = this.automaticTicketing.newTickets(amount);
		this.lotto.storage().saveAutomatedTickets(tickets);
		return tickets;
	}

	@Override
	protected void toNextController() {
		this.lotto.toWinningTicketController();
	}
}
