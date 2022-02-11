package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.generator.LottoAutoGenerator;

public class TicketMachine {

    private static final String INVALID_MANUAL_TICKETS = "수동 구매금액아 총 구매금액을 넘을 수 없습니다.";
    private static final int PRICE_PER_ONE_TICKET = 1000;
    private static final int VALIDATION_BASE_UNIT = 0;

    private final Amount amount;
    private final int manualTickets;
    private final int autoTickets;

    public TicketMachine(final Amount amount, final int manualTickets) {
        validateManualTickets(amount, manualTickets);

        this.amount = amount;
        this.manualTickets = manualTickets;
        this.autoTickets = countTickets() - manualTickets;
    }

    public Amount amount() {
        return amount;
    }

    public int manualTickets() {
        return manualTickets;
    }

    public int autoTickets() {
        return autoTickets;
    }

    public Tickets purchase(final List<Ticket> manualTickets) {
        List<Ticket> purchasedAutoTickets = purchaseAutoTickets(autoTickets);

        return new Tickets(
            Stream.concat(manualTickets.stream(), purchasedAutoTickets.stream())
                .collect(Collectors.toList())
        );
    }

    private List<Ticket> purchaseAutoTickets(final int autoTickets) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < autoTickets; i++) {
            Ticket ticket = new Ticket(new LottoAutoGenerator().generateNumbers());
            tickets.add(ticket);
        }

        return tickets;
    }

    private int countTickets() {
        return amount.value() / PRICE_PER_ONE_TICKET;
    }

    private void validateManualTickets(final Amount amount, final int manualTickets) {
        if (manualTickets < VALIDATION_BASE_UNIT || manualTickets * PRICE_PER_ONE_TICKET > amount.value()) {
            throw new IllegalArgumentException(INVALID_MANUAL_TICKETS);
        }
    }

}
