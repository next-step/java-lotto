package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    private static final int TICKET_COUNT_MIN_VALUE = 1;

    public static List<LottoTicket> generate(int ticketCount) {
        checkTicketCount(ticketCount);

        return IntStream.rangeClosed(TICKET_COUNT_MIN_VALUE, ticketCount)
                .mapToObj(i -> LottoTicket.create(LottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private static void checkTicketCount(int ticketCount) {
        if (ticketCount < TICKET_COUNT_MIN_VALUE ) {
            throw new IllegalArgumentException("티켓은 최소 1장부터 생성 할 수 있습니다.");
        }
    }
}
