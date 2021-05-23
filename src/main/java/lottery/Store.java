package lottery;

public class Store {

	private GenerateTicketMachine machine;

	private static final Money TICKET_PRICE = Money.won(1000L);

	public Store() {
		machine = new GenerateTicketMachine();
	}

	public Tickets getTicket(Buyer buyer) {
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
