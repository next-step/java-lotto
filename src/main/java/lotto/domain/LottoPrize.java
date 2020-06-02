package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES("3", 5000),
    FOUR_MATCHES("4" ,50000),
    FIVE_MATCHES("5", 1500000),
    SIX_MATCHES("6", 2000000000);

    private final String count;
    private final int prize;

    LottoPrize(String count,int prize) {
        this.count = count;
        this.prize = prize;
    }

    public String getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
