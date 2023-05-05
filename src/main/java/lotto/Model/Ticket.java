package lotto.Model;

import java.util.List;

public class Ticket {
    private final TicketNumber numbers;

    public Ticket(TicketNumber numbers) {
        this.numbers = numbers;
    }

    public TicketNumber numbers() {
        return numbers;
    }
}
