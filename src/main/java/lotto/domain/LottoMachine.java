package lotto.domain;

import java.util.stream.IntStream;

public class LottoMachine {

    public static final int AMOUNT_OF_LOTTO_TICKET = 1000;

    public static LottoTicket[] buyLottoTickets(int amount) {
        int ticketCount = amount / AMOUNT_OF_LOTTO_TICKET;

        return IntStream.range(0, ticketCount)
                .mapToObj(i -> LottoTicket.createLottoTicketByAuto())
                .toArray(LottoTicket[]::new);
    }
}
