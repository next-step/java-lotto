package lotto.domain;

import lotto.domain.model.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private static final int TICKET_PRICE = 1000;
    private final List<Integer> ticketNumberPool;

    public LottoTicketMachine(){
        ticketNumberPool = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    }

    public List<LottoTicket> purchaseTickets(final int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int ticketCount = purchaseAmount / TICKET_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }

    private LottoTicket generateTicket() {
        Collections.shuffle(ticketNumberPool);
        Set<Integer> ticketNumbers = new TreeSet<>(ticketNumberPool.subList(0, 6));

        return new LottoTicket(ticketNumbers);
    }
}
