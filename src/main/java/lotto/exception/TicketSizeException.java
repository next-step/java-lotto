package lotto.exception;

import static lotto.domain.Ticket.*;

public class TicketSizeException extends IllegalArgumentException {
	private static final long serialVersionUID = -3815567812618165327L;

	public TicketSizeException() {
		super(String.format("로또 티켓 번호는 %d개만 가능합니다.", SIZE_OF_LOTTO_TICKET));
	}
}
