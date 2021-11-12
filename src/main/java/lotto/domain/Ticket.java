package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import lotto.exception.TicketSizeException;

public class Ticket {
	public static final int SIZE_OF_LOTTO_TICKET = 6;

	public static final int PRICE = 1000;

	private static final String DUPLICATE_MESSAGE = "티켓 번호는 중복될 수 없습니다.";

	private final List<LottoNumber> values;

	private Ticket(List<LottoNumber> values) {
		validate(values);
		this.values = values;
	}

	private void validate(List<LottoNumber> values) {
		validateSize(values);
		validateDuplicate(values);
	}

	private void validateSize(List<LottoNumber> values) {
		if (values.size() != SIZE_OF_LOTTO_TICKET) {
			throw new TicketSizeException();
		}
	}

	private void validateDuplicate(List<LottoNumber> values) {
		if (new HashSet<>(values).size() != SIZE_OF_LOTTO_TICKET) {
			throw new IllegalArgumentException(DUPLICATE_MESSAGE);
		}
	}

	public static Ticket create(List<LottoNumber> values) {
		return new Ticket(values);
	}

	public int getMatchedCount(Ticket winningNumberTicket) {
		return (int)values.stream()
			.filter(winningNumberTicket::contains)
			.count();
	}

	private boolean contains(LottoNumber number) {
		return values.contains(number);
	}

	public boolean isBonusMatched(LottoNumber bonus) {
		return contains(bonus);
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
