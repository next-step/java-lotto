package lotto.domain;

public class LottoPrice {

    private final int price;
    private final int ticketCount;

    public LottoPrice(int price) {
        this(price, price / 1000);
    }

    public LottoPrice(int price, int ticketCount) {
        this.price = price;
        this.ticketCount = ticketCount;
    }

    public int getPrice() {
        return price;
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
}
