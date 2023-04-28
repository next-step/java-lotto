package lotto.Model;

import java.util.List;

public class Ticket {
    private static final int TICKET_SIZE = 6;
    private final TicketNumber numbers;

    public Ticket(TicketNumber numbers) {
        this.numbers = numbers;
    }

    public TicketNumber numbers() {
        return numbers;
    }
}
