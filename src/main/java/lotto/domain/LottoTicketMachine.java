package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketMachine {

    private static final int AMOUNT_PER_TICKET = 1000;

    public static LottoTickets issue(int amount) {
        int countOfTickets = amount / AMOUNT_PER_TICKET;

        List<LottoTicket> tickets = Stream.generate(LottoNumberGenerator::generate)
                .map(LottoTicket::new)
                .limit(countOfTickets)
                .collect(Collectors.toList());

        return new LottoTickets(tickets);
    }
}
