package lottery;

import static java.util.Objects.*;
import static lottery.Money.*;

import java.util.Objects;

public final class Buyer {

	private Money money = Money.ZERO;
	private Tickets tickets = Tickets.EMPTY_TICKETS;

	public static Buyer of(Money initial) {
		return new Buyer(initial);
	}

	private Buyer(Money money) {
		setMoney(money);
	}

	public Money money() {
		return money;
	}

	public Tickets tickets() {
		return tickets;
	}

	public void buyTicket(Store store) {
		requireNonNull(store);
		this.tickets = store.getTicket(this);
	}

	public Result checkTicket(InfoCenter infoCenter) {
		requireNonNull(infoCenter);
		return infoCenter.confirmTicket(this.tickets);
	}

	public void setMoney(Money money) {
		if (isNull(money) || money.amount() < 0) {
			throw new IllegalArgumentException(NOT_VALID_MONEY_EXCEPTION_MESSAGE);
		}
		this.money = money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Buyer))
			return false;
		Buyer buyer = (Buyer)o;
		return Objects.equals(money, buyer.money) && Objects.equals(tickets, buyer.tickets);
	}

	@Override
	public int hashCode() {
		return hash(money, tickets);
	}
}
