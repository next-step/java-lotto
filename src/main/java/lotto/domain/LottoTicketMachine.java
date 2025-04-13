package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketMachine {

    private static final int COUNT = 6;
    private static final List<LottoNumber> TOTAL_NUMBERS = LottoNumber.getAll();

    public static LottoTickets purchase(Count ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; (new Count(i)).isLessThan(ticketCount); i++) {
            tickets.add(generateTicket());
        }
        return new LottoTickets(tickets);
    }

    private static LottoTicket generateTicket() {
        List<LottoNumber> numbers = new ArrayList<>(TOTAL_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoTicket(new HashSet<>(numbers.subList(0, COUNT)));
    }

}
