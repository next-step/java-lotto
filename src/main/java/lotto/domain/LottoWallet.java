package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private List<LottoTicket> lottoTickets;
    private PurchaseBudget purchaseBudget;

    private LottoWallet(List<LottoTicket> lottoTickets, PurchaseBudget purchaseBudget) {
        this.lottoTickets = lottoTickets;
        this.purchaseBudget = purchaseBudget;
    }

    public static LottoWallet create(List<LottoTicket> lottoTickets, PurchaseBudget purchaseBudget) {
        return new LottoWallet(lottoTickets, purchaseBudget);
    }


    public List<LottoTicket> takeOutLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int getManualTicketCount() {
        return purchaseBudget.getManualTicketCount();
    }

    public int getAutoTicketCount() {
        return purchaseBudget.getAutoTicketCount();
    }
}
