package lottery;

public class Store {

	private final TicketMachine machine;

	private static final Money TICKET_PRICE = Money.won(1000L);

	public Store() {
		machine = new TicketMachine();
	}

	public TicketMachine getMachine() {
		return machine;
	}

	public Tickets getTicket(Buyer buyer) {
		Money buyerMoney = buyer.money();
		long ticketCount = buyerMoney.divide(TICKET_PRICE);
		buyer.setMoney(buyerMoney.minus(TICKET_PRICE.multiply(ticketCount)));
		return machine.create(ticketCount);
	}
}
