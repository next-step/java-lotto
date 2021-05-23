package lottery;

import java.util.List;

/**
 * Store 가 해야될 역할.
 * 1. Ticket을 발행하는 것
 * 2.
 */
public class Store {

	private LotteryGenerateMachine machine;

	private static final Money TICKET_PRICE = Money.won(1000L);

	private Buyer buyer;

	public Store() {
		machine = new LotteryGenerateMachine();
	}

	public List<Ticket> getTicket(Buyer buyer) {
		Money buyerMoney = buyer.money();
		long ticketCount = buyerMoney.divide(TICKET_PRICE);
		buyer.minusAmount(Money.won(ticketCount * buyerMoney.amount()));
		return machine.createTicket(ticketCount);
	}

	public LotteryGenerateMachine getMachine() {
		return machine;
	}
}
