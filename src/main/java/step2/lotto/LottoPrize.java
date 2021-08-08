package step2.lotto;

public enum LottoPrize {

    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000),
    ETC(0);

    private final long prizeMoney;

    LottoPrize(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
