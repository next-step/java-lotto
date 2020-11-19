package step2.constant;

public enum LottoWinningPrizes {
    SIX_MATCHES(6, 2000000000),
    FIVE_MATCHES(5, 1500000),
    FOUR_MATCHES(4, 50000),
    THIRD_MATCHES(3, 5000);

    public int getMatch() {
        return match;
    }

    public long getAmount() {
        return amount;
    }

    private int match;
    private long amount;

    LottoWinningPrizes(int match, long amount) {
        this.match = match;
        this.amount = amount;
    }

}
