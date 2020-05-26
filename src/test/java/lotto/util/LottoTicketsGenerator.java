package lotto.util;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.Arrays;
import java.util.Collections;

public class LottoTicketsGenerator {

    private LottoTicketsGenerator() {
    }

    public static LottoTickets newInstance() {
        return LottoTickets.of(Collections.emptyList());
    }

    public static LottoTickets valueOf(final LottoTicket... lottoTickets) {
        return LottoTickets.of(Arrays.asList(lottoTickets));
    }

    public static LottoTickets valueOf(final int... numbers) {
        return LottoTickets.of(Collections.singletonList(LottoTicketGenerator.valueOf(numbers)));
    }
}
