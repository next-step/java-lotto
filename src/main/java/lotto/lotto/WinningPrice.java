package lotto.lotto;

public enum WinningPrice {
    TWO_HUNDRED_MILLION(200000000), // 2억
    THIRTY_MILLION(30000000), // 3천만원
    ONE_MILLION_FIVE_HUNDRED(1500000), // 150만
    FIFTY_THOUSAND(50000), // 5만
    FIVE_THOUSAND(5000); // 5천
    public final long winPrice;

    WinningPrice(long winPrice) {
        this.winPrice = winPrice;
    }

    public long getWinPrice() {
        return winPrice;
    }
}
