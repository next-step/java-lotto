package lotto.domain;

import java.util.List;

public class LottoTickets {
    private static final Integer TICKET_PRICE = 1_000;
    private final int ticketCount;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int money) {
        this.ticketCount = toTicketCount(money);
        this.lottoTickets = issueTickets(new RandomTicketMachine());
    }

    public LottoTickets(int ticketCount, TicketMachine ticketMachine) {
        this.ticketCount = ticketCount;
        this.lottoTickets = issueTickets(ticketMachine);
    }

    private int toTicketCount(int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }

        return money / TICKET_PRICE;
    }

    private List<LottoTicket> issueTickets(TicketMachine ticketMachine) {
        return ticketMachine.issue(this.ticketCount);
    }
}
