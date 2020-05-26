package lotto.util;

import lotto.domain.ticket.LottoTicket;

public class LottoTicketGenerator {

    private LottoTicketGenerator() {
    }

    public static LottoTicket valueOf(final int... numbers) {
        return LottoTicket.of(LottoNumbersGenerator.valueOf(numbers));
    }
}
