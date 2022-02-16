package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.generator.LottoAutoGenerator;

public class TicketMachine {

    private static final String INVALID_MANUAL_TICKETS = "수동 구매금액아 총 구매금액을 넘을 수 없습니다.";

    private final List<Ticket> manualTickets;
    private final List<Ticket> autoTickets;

    public TicketMachine(final Amount amount, final List<List<Number>> manualTicketNumbers) {
        validateManualTickets(amount, manualTicketNumbers);

        this.manualTickets = setManualTickets(manualTicketNumbers);
        this.autoTickets = purchaseAutoTickets(amount.getAutoTickets(manualTicketNumbers.size()));
    }

    private void validateManualTickets(final Amount amount, final List<List<Number>> manualTickets) {
        if (!amount.isEnoughToBuy(manualTickets.size())) {
            throw new IllegalArgumentException(INVALID_MANUAL_TICKETS);
        }
    }

    public Tickets purchase() {
        return new Tickets(
            Stream.concat(manualTickets.stream(), autoTickets.stream())
                .collect(Collectors.toList())
        );
    }

    private List<Ticket> setManualTickets(List<List<Number>> manualTickets) {
        return manualTickets.stream()
            .map(Ticket::new)
            .collect(Collectors.toList());
    }

    private List<Ticket> purchaseAutoTickets(final int autoTickets) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < autoTickets; i++) {
            Ticket ticket = new Ticket(new LottoAutoGenerator().generateNumbers());
            tickets.add(ticket);
        }

        return tickets;
    }
}
