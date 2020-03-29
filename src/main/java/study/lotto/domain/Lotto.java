package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lottoTickets;
    private LottoTicketIssuer lottoTicketIssuer;

    public Lotto(int amount, LottoTicketIssuer lottoTicketIssuer) {
        this.lottoTicketIssuer = lottoTicketIssuer;
        generateLottoTicket(amount);
    }

    private void generateLottoTicket(int amount) {
        int quantity = amount / LottoTicket.PRICE;
        lottoTickets = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            lottoTickets.add(lottoTicketIssuer.issue());
        }
    }

    public int getQuantity () {
        return lottoTickets.size();
    }
}
