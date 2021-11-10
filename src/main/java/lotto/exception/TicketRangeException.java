package lotto.exception;

import lotto.domain.Ticket;

public class TicketRangeException extends IllegalArgumentException {
	private static final long serialVersionUID = -5277129326329543708L;

	public TicketRangeException() {
		super(String.format("당첨번호는 %d ~ %d 사이만 가능합니다.", Ticket.MIN_OF_LOTTO_NUMBERS, Ticket.MAX_OF_LOTTO_NUMBERS));
	}
}
