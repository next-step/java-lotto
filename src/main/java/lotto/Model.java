package lotto;

import java.util.List;

public class Model {

	private Purchase purchase;
	private List<Ticket> automatedTickets;
	private Ticket winningTicket;

	public Model() {
	}

	public void savePurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Purchase loadPurchase() {
		return this.purchase;
	}

	public void saveAutomatedTickets(List<Ticket> automatedTickets) {
		this.automatedTickets = automatedTickets;
	}

	public List<Ticket> loadAutomatedTickets() {
		return this.automatedTickets;
	}

	public void saveWinningTicket(Ticket winningTicket) {
		this.winningTicket = winningTicket;
	}

	public Ticket loadWinningTicket() {
		return this.winningTicket;
	}

}
