package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketMachine {

    private static final int COUNT = 6;
    private static final List<LottoNumber> TOTAL_NUMBERS = LottoNumber.getAll();

    public static List<LottoTicket> purchase(LottoOrder lottoOrder) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (List<Integer> manualNumber : lottoOrder.getManualNumbers()) {
            tickets.add(new LottoTicket(manualNumber));
        }

        for (int i = 0; (new Count(i)).isLessThan(lottoOrder.getAutoTicketCount()); i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private static LottoTicket generateTicket() {
        List<LottoNumber> numbers = new ArrayList<>(TOTAL_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoTicket(new HashSet<>(numbers.subList(0, COUNT)));
    }

}
