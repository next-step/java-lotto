package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private final Purchase purchase;

    public LottoTickets(Purchase purchase) {
        this.purchase = purchase;
        this.lottoTickets = buyLottoTickets(purchase);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseAmount() {
        return purchase.getAmount();
    }

    public int getPurchaseCount() {
        return lottoTickets.size();
    }

    private List<LottoTicket> buyLottoTickets(Purchase purchase) {
        return purchase.buy();
    }
}
