package lotto.controllers;

import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class WinningTicketController extends InteractionController {

	public WinningTicketController(Lotto lotto) {
		super(lotto);
	}

	@Override
	protected void action() {
		askWinningTicket(Keyboard.read());
	}

	protected void askWinningTicket(String input) {
		saveWinningTicket(readTicket(input));
	}

	private Ticket readTicket(String text) {
		return new Ticket(text);
	}

	private void saveWinningTicket(Ticket ticket) {
		lotto.storage().saveWinningTicket(ticket);
	}

	@Override
	protected void show() {
		Display.show(Message.WINNING_TICKET);
	}

	@Override
	protected void toNextController() {
		lotto.toEndController();
	}
}
