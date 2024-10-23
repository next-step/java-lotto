package lotto.lotto;

public enum WinningPrice {
    TWO_HUNDRED_MILLION(2_000_000_000),
    THIRTY_MILLION(30_000_000),
    ONE_MILLION_FIVE_HUNDRED(1_500_000),
    FIFTY_THOUSAND(50_000),
    FIVE_THOUSAND(5_000);
    public final long winPrice;

    WinningPrice(long winPrice) {
        this.winPrice = winPrice;
    }

    public long getWinPrice() {
        return winPrice;
    }
}
