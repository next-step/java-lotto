package lotto.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.exception.TicketRangeException;
import lotto.exception.TicketSizeException;

public class Ticket {
	public static final int SIZE_OF_LOTTO_TICKET = 6;
	public static final int MIN_OF_LOTTO_NUMBERS = 1;
	public static final int MAX_OF_LOTTO_NUMBERS = 45;

	public static final int PRICE = 1000;

	private static final String DUPLICATE_MESSAGE = "티켓 번호는 중복될 수 없습니다.";

	private final Set<Integer> values;

	Ticket(List<Integer> values) {
		this(new LinkedHashSet<>(values));
	}

	Ticket(Set<Integer> values) {
		validate(values);
		this.values = values;
	}

	private void validate(Set<Integer> values) {
		validateSize(values);
		validateRange(values);
		validateDuplicate(values);
	}

	private void validateSize(Set<Integer> values) {
		if (values.size() != SIZE_OF_LOTTO_TICKET) {
			throw new TicketSizeException();
		}
	}

	private void validateRange(Set<Integer> values) {
		long count = values.stream()
			.filter(this::isPossibleRange)
			.count();
		if (count != SIZE_OF_LOTTO_TICKET) {
			throw new TicketRangeException();
		}
	}

	private boolean isPossibleRange(Integer value) {
		return value >= MIN_OF_LOTTO_NUMBERS && value <= MAX_OF_LOTTO_NUMBERS;
	}

	private void validateDuplicate(Set<Integer> values) {
		if (values.size() != SIZE_OF_LOTTO_TICKET) {
			throw new IllegalArgumentException(DUPLICATE_MESSAGE);
		}
	}

	public static Ticket create(List<Integer> values) {
		return new Ticket(new LinkedHashSet<>(values));
	}

	public int getMatchedCount(Ticket winningNumberTicket) {
		return (int)values.stream()
			.filter(winningNumberTicket::contains)
			.count();
	}

	private boolean contains(Integer number) {
		return values.contains(number);
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
