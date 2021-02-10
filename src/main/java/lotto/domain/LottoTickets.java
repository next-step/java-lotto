package lotto.domain;

import java.util.List;

public class LottoTickets implements Tickets{
    private final List<LottoTicket> lottoTickets;
    private final Purchase purchase;

    public LottoTickets(final Purchase purchase) {
        this.purchase = purchase;
        this.lottoTickets = buyLottoTickets(purchase);
    }

    @Override
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String getPurchaseInformation() {
        return purchase.toString();
    }

    @Override
    public int getPurchaseAmount() {
        return purchase.getAmount();
    }

    @Override
    public int getPurchaseCount() {
        return lottoTickets.size();
    }

    private List<LottoTicket> buyLottoTickets(final Purchase purchase) {
        return purchase.buy();
    }
}
