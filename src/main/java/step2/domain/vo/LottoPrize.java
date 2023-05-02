package step2.domain.vo;

import java.util.Arrays;

public enum LottoPrize {

    FIRST("1등", 2_000_000_000, 6),
    SECOND("2등", 1_500_000, 5),
    THIRD("3등", 50000, 4),
    FOURTH("4등", 5000, 3),
    NONE("낙첨", 0, 0);

    private final String rank;
    private final int prize;
    private final int prizeCount;

    LottoPrize(String rank, int prize, int prizeCount) {
        this.rank = rank;
        this.prize = prize;
        this.prizeCount = prizeCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize prize(int count) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.prizeCount == count)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }
}
