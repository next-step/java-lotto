package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domains.Ticket;
import lotto.domains.Tickets;
import lotto.enums.ErrorMessage;
import lotto.exceptions.TicketsOutOfBoundsException;
import lotto.strategy.AutomaticStrategy;

public class AutomaticTicketing {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private List<Integer> numbers;
    private AutomaticStrategy strategy;

    public AutomaticTicketing(AutomaticStrategy strategy) {
        this.numbers = numbers();
        this.strategy = strategy;
    }

    private static List<Integer> numbers() {
        List<Integer> digits = new ArrayList<>(MAX_VALUE);
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            digits.add(i);
        }
        return digits;
    }

    public Ticket newTicket() {
        Collections.shuffle(this.numbers);
        List<Integer> chosenNumbers = this.strategy.choose(this.numbers);
        return new Ticket(chosenNumbers);
    }

    public Tickets newTickets(int count) {
        if (count < 1) {
            throw new TicketsOutOfBoundsException(ErrorMessage.TICKETS_OUT_OF_BOUNDS.toString());
        }

        List<Ticket> tickets = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tickets.add(newTicket());
        }

        return new Tickets(tickets);
    }

}
