package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    List<LottoTicket> lottoTickets;

    public LottoGame() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<LottoTicket> buyLottoTicket(int money) {
        int ticketNum = money / TICKET_PRICE;

        for (int i = 0; i < ticketNum; i++) {
            this.lottoTickets.add(new LottoTicket());
        }

        return this.lottoTickets;
    }
}
