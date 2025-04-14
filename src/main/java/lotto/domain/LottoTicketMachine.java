package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketMachine {

    private static final int COUNT = 6;
    private static final List<LottoNumber> TOTAL_NUMBERS = LottoNumber.getAll();

    public static LottoTickets purchase(LottoOrder order) {
        List<LottoTicket> tickets = new ArrayList<>();
        Count autoTicketCount = order.getAutoTicketCount();
        for (int i = 0; (new Count(i)).isLessThan(autoTicketCount); i++) {
            tickets.add(generateTicket());
        }

        LottoTickets manualTickets = order.getManualTickets();
        return manualTickets.add(new LottoTickets(tickets, false));
    }

    private static LottoTicket generateTicket() {
        List<LottoNumber> numbers = new ArrayList<>(TOTAL_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoTicket(new HashSet<>(numbers.subList(0, COUNT)));
    }

}
