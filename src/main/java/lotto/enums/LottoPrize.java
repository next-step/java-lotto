package lotto.enums;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;

    private final int prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(prizeMoney);
    }

}