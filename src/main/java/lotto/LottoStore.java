package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final LottoPrice price;

    public LottoStore(int ticketPrice) {
        this.price = new LottoPrice(ticketPrice);
    }

    public LottoStore(LottoPrice lottoPrice) {
        this.price = lottoPrice;
    }

    public List<LottoTicket> purchase(int purchasePrice) {
        int count = getPurchaseCount(purchasePrice);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(LottoTicket.create());
        }
        return tickets;
    }

    private int getPurchaseCount(int purchasePrice) {
        return purchasePrice / price.getPrice();
    }
}
