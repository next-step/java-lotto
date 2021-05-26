package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Tickets {

	public static final Tickets EMPTY_TICKETS = new Tickets(new ArrayList<>());

	private List<Ticket> value;
	private String NOT_FOUND_TICKETS_EXCEPTION_MESSAGE = "Ticket 정보가 없습니다";

	public static Tickets of(List<Ticket> ticketList) {
		return new Tickets(ticketList);
	}

	private Tickets(List<Ticket> value) {
		setValue(value);
	}

	private void setValue(List<Ticket> value) {
		if (Objects.isNull(value)){
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
}
