package lottery;

import java.util.Collections;
import java.util.List;

public final class Buyer {
	private final Money money;
	private final List<Ticket> tickets;

	private Buyer(Money money) {
		this.money = money;
		this.tickets = Collections.EMPTY_LIST;
	}

	public static Buyer of(Money won) {
		return new Buyer(won);
	}

	public Money amount() {
		return money;
	}

	public List<Ticket> lotteryTickets() {
		return tickets;
	}
}
