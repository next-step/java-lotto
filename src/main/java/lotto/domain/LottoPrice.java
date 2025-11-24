package lotto.domain;

import java.util.Objects;

public class LottoPrice {

    private final Price price;
    private final TicketCount ticketCount;
    private final TicketCount passiveTicketCount;

    public LottoPrice(int price) {
        this(price, (price / 1_000), 0);
    }

    public LottoPrice(int price, int passiveTicketCount) {
        this(price, (price / 1_000) - passiveTicketCount, passiveTicketCount);
    }

    public LottoPrice(int price, int ticketCount, int passiveTicketCount) {
        this(new Price(price), new TicketCount(ticketCount), new TicketCount(passiveTicketCount));
    }

    public LottoPrice(Price price, TicketCount ticketCount, TicketCount passiveTicketCount) {
        this.price = price;
        this.ticketCount = ticketCount;
        this.passiveTicketCount = passiveTicketCount;
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

    public int getPassiveTicketCount() {
        return passiveTicketCount.getValue();
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
