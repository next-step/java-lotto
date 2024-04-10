package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    List<LottoTicket> lottoTickets;
    LottoMatch lottoMatch;

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

    public HashMap<LottoMatchNumber, Integer> winLotto() {
        return this.lottoMatch.matchResult(lottoTickets);
    }

}
