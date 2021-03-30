package lotto.domain.prize;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L);

    private final long equalNumberCount;
    private final long prizeAmount;

    Prize(long equalNumberCount, long prizeAmount) {
        this.equalNumberCount = equalNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public static long getPrizeByEqualNumberCount(long equalNumberCount) {
        return Arrays.stream(Prize.values())
                        .filter(prize -> prize.isSameNumberAs(equalNumberCount))
                        .findAny()
                        .map(Prize::getPrizeAmount)
                        .orElse(0L);
    }

    public long getEqualNumberCount() {
        return this.equalNumberCount;
    }

    private boolean isSameNumberAs(long equalNumberCount) {
        if (this.equalNumberCount == equalNumberCount) {
            return true;
        }
        return false;
    }

    public long getPrizeAmount() {
        return this.prizeAmount;
    }

}
