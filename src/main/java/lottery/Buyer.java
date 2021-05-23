package lottery;

import static java.util.Objects.*;

import java.util.Collections;
import java.util.List;

public final class Buyer {
	private Money money = Money.ZERO;
	private List<Ticket> tickets;

	private Buyer(Money money) {
		setMoney(money);
		this.tickets = Collections.emptyList();
	}

	public static Buyer of(Money initial) {
		return new Buyer(initial);
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

	public void buyTicket(Store store) {
		requireNonNull(store);
		this.tickets = store.getTicket(this);
	}

	public Result checkTicket(InfoCenter infoCenter) {
		requireNonNull(infoCenter);
		return infoCenter.confirmTicket(this.tickets);
	}

	public void setMoney(Money rest) {
		if (isNull(rest)) {
			throw new IllegalArgumentException("유효하지 않은 값입니다.");
		}
		this.money = rest;
	}
}
