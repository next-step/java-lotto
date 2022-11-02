package lotto;

public class LottoPrice {
    private final int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public int getPurchaseCount(int purchasePrice) {
        return purchasePrice / price;
    }

    public long getPurchasePrice(int ticketCount) {
        return (long) price * ticketCount;
    }
}
