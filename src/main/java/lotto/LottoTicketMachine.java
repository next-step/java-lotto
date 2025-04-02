package lotto;

import java.util.List;

public class LottoTicketMachine {

    private static final int LOTTO_PRICE = 1000;

    public LottoTicket[] purchase(int amount) {
        validateAmount(amount);
        return generateTickets(calculateTicketCount(amount));
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Amount must be a multiple of 1000");
        }
    }

    private int calculateTicketCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private LottoTicket[] generateTickets(int ticketCount) {
        LottoTicket[] tickets = new LottoTicket[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        }
        return tickets;
    }
}
