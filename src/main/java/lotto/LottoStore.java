package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int DEFAULT_TICKET_PRICE = 1000;

    private final int tickerPrice;

    public LottoStore() {
        this(DEFAULT_TICKET_PRICE);
    }

    public LottoStore(int ticketPrice) {
        this.tickerPrice = ticketPrice;
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
        return purchasePrice / tickerPrice;
    }
}
