package step2.domain.vo;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(2_000_000_000, 6, "6개 일치 (2000000000원)"),
    SECOND_BONUS(30_000_000, 6, "5개 일치, 보너스 볼 일치(30000000원)"),
    SECOND(1_500_000, 5, "5개 일치 (1500000원)"),
    THIRD(50_000, 4, "4개 일치 (50000원)"),
    FOURTH(5_000, 3, "3개 일치 (5000원)"),
    NONE(0, 0, "0개 ~ 2개 일치 (0원)");

    private final int prize;
    private final int prizeCount;
    private final String description;

    LottoPrize(int prize, int prizeCount, String description) {
        this.prize = prize;
        this.prizeCount = prizeCount;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoPrize prize(int count) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.prizeCount == count)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }
}
