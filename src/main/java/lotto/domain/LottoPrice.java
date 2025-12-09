package lotto.domain;

import java.util.Objects;

public class LottoPrice {

    private final Price price;
    private final TicketCount ticketCount;

    public LottoPrice(int price, int passiveTicketCount) {
        this(price, new TicketCount(price, passiveTicketCount));
    }

    public LottoPrice(int price, TicketCount ticketCount) {
        this(new Price(price), ticketCount);
    }

    public LottoPrice(Price price, TicketCount ticketCount) {
        this.price = price;
        this.ticketCount = ticketCount;
    }

    public void create(Runnable runnable) {
        this.ticketCount.create(runnable);
    }

    public double profitPercent(int totalResultPrice) {
        return price.profitPercent(totalResultPrice);
    }

    public TicketCount getTicketCount() {
        return ticketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return Objects.equals(price, that.price) && Objects.equals(getTicketCount(), that.getTicketCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, getTicketCount());
    }
}
