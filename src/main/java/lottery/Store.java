package lottery;

public class Store {

	private final TicketMachine machine;

	public static final Money TICKET_PRICE = Money.won(1000L);

	public Store() {
		machine = new TicketMachine();
	}

	public TicketMachine getMachine() {
		return machine;
	}

	public Tickets getTicket(Buyer buyer, Tickets manualTickets) {
		Money buyerMoney = buyer.money();
		int countOfManualTicket = manualTickets.size();

		Money minus = buyerMoney.minus(TICKET_PRICE.multiply(countOfManualTicket));
		long countOfAutomaticTicket = minus.divide(TICKET_PRICE);
		Tickets tickets = machine.automaticTicketCreate(countOfAutomaticTicket);
		buyer.setMoney(buyerMoney.minus(TICKET_PRICE.multiply(countOfAutomaticTicket + countOfManualTicket)));
		return tickets.merge(manualTickets);
	}
}
