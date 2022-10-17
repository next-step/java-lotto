package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    public static List<LottoTicket> create(int numOfTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

}
