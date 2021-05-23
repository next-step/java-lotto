package lottery;

import java.util.List;

/**
 * Store 가 해야될 역할.
 * 1. Ticket을 발행하는 것
 * 2.
 */
public class Store {

	private GenerateTicketMachine machine;

	private static final Money TICKET_PRICE = Money.won(1000L);

	public Store() {
		machine = new GenerateTicketMachine();
	}

	public List<Ticket> getTicket(Buyer buyer) {
		Money buyerMoney = buyer.money();
		long ticketCount = buyerMoney.divide(TICKET_PRICE);
		Money rest = buyerMoney.minus(Money.won(ticketCount * TICKET_PRICE.amount()));
		buyer.setMoney(rest);
		return machine.create(ticketCount);
	}

	public GenerateTicketMachine getMachine() {
		return machine;
	}
}
