package lotto.domain;

import java.util.List;

public class MockLottoTickets implements Tickets {
    private final static int LOTTO_PRICE = 1_000;
    private final List<LottoTicket> lottoTickets;
    private final int purchaseAmount;

    public MockLottoTickets(final List<LottoTicket> lottoTickets, final int purchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String getPurchaseInformation() {
        return "";
    }

    @Override
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    @Override
    public int getPurchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
