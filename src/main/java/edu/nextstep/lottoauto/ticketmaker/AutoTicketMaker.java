package edu.nextstep.lottoauto.ticketmaker;

import edu.nextstep.lottoauto.domain.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoTicketMaker implements TicketMaker {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> NUMBERS = new ArrayList<>();
    private static final int INDEX_FROM_TICKET_NUMBERS = 0;
    private static final int INDEX_TO_TICKET_NUMBERS = 6;

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            NUMBERS.add(number);
        }
    }

    @Override
    public Ticket create() {
        shuffleNumbers();
        List<Integer> ticketNumbers =
                new ArrayList<>(NUMBERS.subList(INDEX_FROM_TICKET_NUMBERS, INDEX_TO_TICKET_NUMBERS));
        Collections.sort(ticketNumbers);
        return Ticket.of(ticketNumbers);
    }

    protected void shuffleNumbers() {
        Collections.shuffle(NUMBERS);
    }
}
