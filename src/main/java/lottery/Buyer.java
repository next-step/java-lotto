package lottery;

import java.util.Collections;
import java.util.List;

public final class Buyer {
	private final Money money;
	private List<Ticket> tickets;

	private Buyer(Money money) {
		this.money = money;
		this.tickets = Collections.EMPTY_LIST;
	}

	public static Buyer of(Money won) {
		return new Buyer(won);
	}

	public Money money() {
		return money;
	}

	public List<Ticket> lotteryTickets() {
		return tickets;
	}

	public boolean hasTickets() {
		return tickets.size() > 0;
	}

	public void minusAmount(Money target){
		this.money.minus(target);
	}

	public void buyTicket(Store store) {
		this.tickets = store.getTicket(this);
	}

}
