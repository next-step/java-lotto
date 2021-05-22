package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.enums.ErrorMessage;
import lotto.exceptions.TicketsOutOfBoundsException;

public class AutomaticTicketing {

    public static final int SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private List<Integer> numbers;

    public AutomaticTicketing() {
        this(MAX_VALUE);
    }

    public AutomaticTicketing(int size) {
        this.numbers = numbers(size);
    }

    public Ticket newTicket() {
        shuffle(numbers);
        List<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, SIZE));
        return new Ticket(selectedNumbers);
    }

    public List<Ticket> newTickets(int count) {
        verifyCount(count);

        List<Ticket> tickets = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tickets.add(newTicket());
        }
        return tickets;
    }

    private void verifyCount(int count) {
        if (count < 1) {
            throw new TicketsOutOfBoundsException(ErrorMessage.TICKETS_OUT_OF_BOUNDS.toString());
        }
    }

    private static List<Integer> numbers(int size) {
        List<Integer> digits = new ArrayList<>(size);
        for (int i = MIN_VALUE; i <= size; i++) {
            digits.add(i);
        }
        return digits;
    }

    private void shuffle(List<Integer> digits) {
        Collections.shuffle(digits);
    }

}
