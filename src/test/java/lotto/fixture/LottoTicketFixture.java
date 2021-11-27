package lotto.fixture;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;

public class LottoTicketFixture {

    public static final LottoTicket LOTTO_TICKET1 = LottoTicket.createTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static final LottoTicket LOTTO_TICKET2 = LottoTicket.createTicket(Arrays.asList(4, 7, 10, 32, 22, 42));
    public static final LottoTicket LOTTO_TICKET3 = LottoTicket.createTicket(Arrays.asList(1, 2, 3, 16, 24, 23));

    public static final LottoTickets LOTTO_TICKETS = LottoTickets.of(
            Arrays.asList(LOTTO_TICKET1, LOTTO_TICKET2, LOTTO_TICKET3));

    public static final double PROFIT_RATE = 666668.3333333334;
}
