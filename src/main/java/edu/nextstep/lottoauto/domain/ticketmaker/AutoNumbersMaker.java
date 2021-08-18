package edu.nextstep.lottoauto.domain.ticketmaker;

import edu.nextstep.lottoauto.domain.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumbersMaker implements NumbersMaker {

    private static final int MIN_NUMBER = Ticket.MIN_NUMBER;
    private static final int MAX_NUMBER = Ticket.MAX_NUMBER;
    private static final int INDEX_FROM_TICKET_NUMBERS = 0;
    private static final int INDEX_TO_TICKET_NUMBERS = 6;

    private final List<Integer> numbers = new ArrayList<>();

    public AutoNumbersMaker() {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            numbers.add(number);
        }
    }

    @Override
    public List<Integer> create() {
        shuffleNumbers();
        return new ArrayList<>(numbers.subList(INDEX_FROM_TICKET_NUMBERS, INDEX_TO_TICKET_NUMBERS));
    }

    protected void shuffleNumbers() {
        Collections.shuffle(numbers);
    }
}
