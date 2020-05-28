package step2.model;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTicketGenerator {

    private static final int TICKET_COUNT_MIN_VALUE = 1;

    public static LottoTickets generate(int ticketCount) {
        checkTicketCount(ticketCount);

        return IntStream.rangeClosed(TICKET_COUNT_MIN_VALUE, ticketCount)
                .mapToObj(i -> LottoTicket.create(LottoNumberGenerator.generate()))
                .collect(collectingAndThen(toList(), LottoTickets::newInstance));
    }

    private static void checkTicketCount(int ticketCount) {
        if (ticketCount < TICKET_COUNT_MIN_VALUE ) {
            throw new IllegalArgumentException("티켓은 최소 1장부터 생성 할 수 있습니다.");
        }
    }
}
