package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tickets {

	public static final Tickets EMPTY_TICKETS = new Tickets(new ArrayList<>());

	private static final String NOT_FOUND_TICKETS_EXCEPTION_MESSAGE = "Ticket 정보가 없습니다";

	private List<Ticket> value;

	public static Tickets of(List<Ticket> ticketList) {
		return new Tickets(ticketList);
	}

	private Tickets(List<Ticket> value) {
		setValue(value);
	}

	private void setValue(List<Ticket> value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException(NOT_FOUND_TICKETS_EXCEPTION_MESSAGE);
		}
		this.value = value;
	}

	public int size() {
		return value.size();
	}

	public List<Ticket> getValues() {
		return Collections.unmodifiableList(value);
	}

	public Ticket getValue(int i) {
		if (i > value.size() - 1) {
			throw new IndexOutOfBoundsException("잘못된 인덱스 정보입니다");
		}
		return value.get(i);
	}

	public int sizeOfManualTickets() {
		return value.stream()
			.filter(ticket -> ticket.getType().equals(TicketType.MANUAL))
			.mapToInt(a -> 1).sum();
	}

	public int sizeOfAutoTickets() {
		return value.stream()
			.filter(ticket -> ticket.getType().equals(TicketType.AUTO))
			.mapToInt(a -> 1).sum();
	}

	public Tickets merge(Tickets tickets) {
		return Tickets.of(
			Stream.concat(this.getValues().stream(), tickets.getValues().stream()).collect(Collectors.toList()));
	}
}
