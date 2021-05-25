package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {

	public static final Tickets EMPTY_TICKETS = new Tickets(new ArrayList<>());

	private final List<Ticket> value;

	public static Tickets of(List<Ticket> ticketList) {
		return new Tickets(ticketList);
	}

	private Tickets(List<Ticket> value) {
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
}
