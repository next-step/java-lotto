package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoTicketsFactory {
    public static List<LottoTicket> createAuto(Money money) {
        LottoTicketCreatePolicy createPolicy = new AutoCreatePolicy();

        return LongStream.range(0, money.howManyLottoTickets())
                .mapToObj(number -> LottoTicket.of(createPolicy))
                .collect(Collectors.toList());
    }
}
