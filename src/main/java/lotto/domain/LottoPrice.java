package lotto.domain;

import java.util.Objects;

public class LottoPrice {

    private final int price;
    private final int ticketCount;

    public LottoPrice(int price) {
        this(price, price / 1000);
    }

    public LottoPrice(int price, int ticketCount) {
        validate(price);
        this.price = price;
        this.ticketCount = ticketCount;
    }

    private void validate(int price) {
        checkMinPrice(price);
        checkDivisibleByThousand(price);
    }

    private static void checkDivisibleByThousand(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위로 입력해주세요.");
        }
    }

    private static void checkMinPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요.");
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void create(Runnable runnable) {
        for (int i = 0; i < ticketCount; i++) {
            runnable.run();
        }
    }

    public double profitPercent(int totalResultPrice) {
        return (double) totalResultPrice / price;
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
