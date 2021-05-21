package lotto.controllers;

import java.util.List;

import lotto.AutomaticTicketing;
import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.views.Display;

public class AutomaticTicketingController extends SimpleController {

	AutomaticTicketing automaticTicketing = new AutomaticTicketing();

	public AutomaticTicketingController(Lotto lotto) {
		super(lotto);
	}

	@Override
	void show() {
		int amount = totalTickets();
		List<Ticket> tickets = newTickets(amount);

		displayTicketAmount(amount);
		displayTickets(tickets);
	}

	private void displayTicketAmount(int amount) {
		Display.show(Message.AUTOMATIC_TICKETING, amount);
	}

	private void displayTickets(List<Ticket> tickets) {
		for (Ticket ticket : tickets) {
			Display.show(ticket);
		}
	}

	protected int totalTickets() {
		return lotto.storage().loadPurchase().totalTickets();
	}

	protected List<Ticket> newTickets(int amount) {
		return automaticTicketing.newTickets(amount);
	}

	@Override
	void toNextController() {
		lotto.toEndController();
	}
}
