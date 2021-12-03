package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoTicket> myLottoTickets = new ArrayList<>();

    public Lotto(int numberOfTicket) {
        for (int i = 0; i < numberOfTicket; i++) {
            myLottoTickets.add(LottoTicket.randomLottoTicket());
        }
    }

    public List<LottoTicket> myLottoTickets() {
        return Collections.unmodifiableList(myLottoTickets);
    }
}
