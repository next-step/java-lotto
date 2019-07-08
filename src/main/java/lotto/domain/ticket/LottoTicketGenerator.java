package lotto.domain.ticket;

import lotto.common.PositiveNumber;

public interface LottoTicketGenerator {
    LottoTickets generate(PositiveNumber ticketCount);
}
