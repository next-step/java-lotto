package lottery;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

	public static final Tickets EMPTY_TICKETS = new Tickets(new ArrayList<>());

	private final List<Ticket> ticketList;

	public static Tickets of(List<Ticket> ticketList) {
		return new Tickets(ticketList);
	}

	private Tickets(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public int size() {
		return ticketList.size();
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}
}
