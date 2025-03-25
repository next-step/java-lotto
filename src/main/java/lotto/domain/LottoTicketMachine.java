package lotto.domain;

import lotto.domain.model.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private static final int TICKET_PRICE = 1000;

    public List<LottoTicket> purchaseTickets(final int purchaseAmount) {
        int ticketCount = purchaseAmount / TICKET_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private LottoTicket generateTicket() {
        List<Integer> pool = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(pool);

        Set<Integer> ticketNumbers = new TreeSet<>(pool.subList(0, 6));
        return new LottoTicket(ticketNumbers);
    }
}
