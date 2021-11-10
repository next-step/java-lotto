package lotto.domain;

import java.util.List;
import java.util.Objects;

import lotto.exception.TicketRangeException;
import lotto.exception.TicketSizeException;

public class Ticket {
	public static final int SIZE_OF_LOTTO_TICKET = 6;
	public static final int MIN_OF_LOTTO_NUMBERS = 1;
	public static final int MAX_OF_LOTTO_NUMBERS = 45;

	public static final int PRICE = 1000;

	private final List<Integer> values;

	Ticket(List<Integer> values) {
		validate(values);
		this.values = values;
	}

	private void validate(List<Integer> values) {
		validateSize(values);
		validateRange(values);
		validateDuplicate(values);
	}

	private void validateSize(List<Integer> values) {
		if (values.size() != SIZE_OF_LOTTO_TICKET) {
			throw new TicketSizeException();
		}
	}

	private void validateRange(List<Integer> values) {
		long count = values.stream()
			.filter(value -> !(value < MIN_OF_LOTTO_NUMBERS))
			.filter(value -> !(value > MAX_OF_LOTTO_NUMBERS))
			.count();

		if (count != SIZE_OF_LOTTO_TICKET) {
			throw new TicketRangeException();
		}
	}

	private void validateDuplicate(List<Integer> values) {
		if (values.stream().distinct().count() != SIZE_OF_LOTTO_TICKET) {
			throw new IllegalArgumentException("티켓 번호는 중복될 수 없습니다.");
		}
	}

	public static Ticket create(List<Integer> values) {
		return new Ticket(values);
	}

	public int getMatchedCount(Ticket winningNumberTicket) {
		return (int)values.stream()
			.filter(winningNumberTicket.values::contains)
			.count();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Ticket ticket = (Ticket)obj;

		return Objects.equals(values, ticket.values);
	}

	@Override
	public int hashCode() {
		return values != null ? values.hashCode() : 0;
	}

	@Override
	public String toString() {
		return values.toString();
	}
}
