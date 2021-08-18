package edu.nextstep.lottoauto.ticketmaker;

import edu.nextstep.lottoauto.domain.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumbersMaker implements NumbersMaker {

    private static final int MIN_NUMBER = Ticket.MIN_NUMBER;
    private static final int MAX_NUMBER = Ticket.MAX_NUMBER;
    private static final List<Integer> NUMBERS = new ArrayList<>();
    private static final int INDEX_FROM_TICKET_NUMBERS = 0;
    private static final int INDEX_TO_TICKET_NUMBERS = 6;

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            NUMBERS.add(number);
        }
    }

    @Override
    public List<Integer> create() {
        shuffleNumbers();
        return new ArrayList<>(NUMBERS.subList(INDEX_FROM_TICKET_NUMBERS, INDEX_TO_TICKET_NUMBERS));
    }

    protected void shuffleNumbers() {
        Collections.shuffle(NUMBERS);
    }
}
