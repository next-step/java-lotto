package lotto.domain;

import java.util.List;

public class PurchaseAmount {

    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final int amount;
    private final int count;

    public PurchaseAmount(final int amount) {
        this.amount = amount;
        this.count = amount / LOTTO_TICKET_PRICE;
    }

    public PurchaseAmount(final List<LottoTicket> lottoTickets) {
        this.amount = lottoTickets.size() * LOTTO_TICKET_PRICE;
        this.count = lottoTickets.size();
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}
