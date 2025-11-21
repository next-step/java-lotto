package lotto.domain;

import java.util.Objects;

public class LottoPrice {

    private final Price price;
    private final TicketCount ticketCount;

    public LottoPrice(int price) {
        this(price, price / 1_000);
    }


    public LottoPrice(int price, int ticketCount) {
        this(new Price(price), new TicketCount(ticketCount));
    }

    public LottoPrice(Price price, TicketCount ticketCount) {
        this.price = price;
        this.ticketCount = ticketCount;
    }

    public void create(Runnable runnable) {
        for (int i = 0; i < this.ticketCount.getValue(); i++) {
            runnable.run();
        }
    }

    public double profitPercent(int totalResultPrice) {
        return price.profitPercent(totalResultPrice);
    }

    public int getTicketCount() {
        return ticketCount.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return price == that.price && getTicketCount() == that.getTicketCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, getTicketCount());
    }
}
