package lotto.enums;

public enum PrizeMoney {

    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int count;
    private final int prizeMoney;

    PrizeMoney(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public static PrizeMoney valueOf(int count) {
        for (PrizeMoney prizeMoney : values()) {
            if (prizeMoney.count == count) {
                return prizeMoney;
            }
        }
        throw new IllegalArgumentException("해당하는 상금이 없습니다.");
    }

}
